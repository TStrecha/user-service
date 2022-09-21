package cz.thomas.messagingapp.userservice.service;

import cz.thomas.messagingapp.userservice.dto.mapper.ConfirmationMapper;
import cz.thomas.messagingapp.userservice.model.ConfirmationEntity;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import cz.thomas.messagingapp.userservice.model.repository.ConfirmationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ConfirmationMapper confirmationMapper;
    private final ConfirmationRepository confirmationRepository;

    public ConfirmationEntity createConfirmation(ContactEntity contact){
        var confirmation = confirmationMapper.createFromContact(contact);
        return confirmationRepository.save(confirmation);
    }

}
