package cz.thomas.messagingapp.userservice.model.repository;

import cz.thomas.messagingapp.userservice.model.ContactEntity;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {


}
