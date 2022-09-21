package cz.thomas.messagingapp.userservice.service;

import cz.thomas.messagingapp.userservice.constants.ContactType;
import cz.thomas.messagingapp.userservice.constants.GlobalRoleType;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import cz.thomas.messagingapp.userservice.model.repository.ContactRepository;
import cz.thomas.messagingapp.userservice.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.time.OffsetDateTime;

@Slf4j
@Component
@Profile("!migration")
public class UserInitializer implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ContactRepository contactRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        if(userRepository.count() != 0){
            return;
        }

        OffsetDateTime now = OffsetDateTime.now();

        UserEntity user = UserEntity.builder()
                .registeredAt(now)
                .globalRole(GlobalRoleType.ADMINISTRATOR)
                .username("App administrator")
                .registeredAt(now)
                .password("") //TODO: Set hashed password
                .build();

        user = userRepository.save(user);

        ContactEntity emailContact = ContactEntity.builder()
                .type(ContactType.EMAIL)
                .value("ts.strecha@gmail.com")
                .isPrimary(true)
                .isConfirmed(true)
                .createdAt(now)
                .confirmedAt(now)
                .user(user)
                .build();
        contactRepository.save(emailContact);
    }

}
