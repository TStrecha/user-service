package cz.thomas.messagingapp.userservice.dto.mapper;

import cz.thomas.messagingapp.userservice.constants.ConfirmationState;
import cz.thomas.messagingapp.userservice.dto.ContactDTO;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface ContactMapper {

    @Mapping(target = "confirmed", source = "source", qualifiedByName = "checkConfirmed")
    ContactDTO toDTO(ContactEntity source);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", ignore = true)
    ContactEntity fromDTO(ContactDTO source, UserEntity user);

    @Named("checkConfirmed")
    default boolean checkConfirmed(ContactEntity source){
        return source.getConfirmation() != null && source.getConfirmation().getConfirmationState() == ConfirmationState.COMPLETE;
    }

}
