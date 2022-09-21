package cz.thomas.messagingapp.userservice.dto.mapper;

import cz.thomas.messagingapp.userservice.dto.ContactDTO;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ContactMapper {

    ContactDTO toDTO(ContactEntity source);

}
