package cz.thomas.messagingapp.userservice.dto.mapper;

import cz.thomas.messagingapp.userservice.dto.UserDTO;
import cz.thomas.messagingapp.userservice.dto.UserRegisterDTO;
import cz.thomas.messagingapp.userservice.model.ContactEntity;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(uses = { ContactMapper.class }, builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserDTO toDTO(UserEntity source);

    @Mapping(target = "contacts", source = "contacts")
    @Mapping(target = "password", source = "password")
    void fromRegisterDTO(@MappingTarget UserEntity user, UserRegisterDTO source, List<ContactEntity> contacts, String password);

}
