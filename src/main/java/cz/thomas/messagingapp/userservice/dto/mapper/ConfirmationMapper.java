package cz.thomas.messagingapp.userservice.dto.mapper;

import cz.thomas.messagingapp.userservice.model.ConfirmationEntity;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Random;

@Mapper
public interface ConfirmationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "confirmationKey", expression = "java(createConfirmationKey())") // in after mapping
    @Mapping(target = "confirmationState", constant = "NEW")
    ConfirmationEntity createFromContact(ContactEntity contact);

    default String createConfirmationKey(){
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 12;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
