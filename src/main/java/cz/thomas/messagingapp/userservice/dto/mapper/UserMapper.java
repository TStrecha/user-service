package cz.thomas.messagingapp.userservice.dto.mapper;

import cz.thomas.messagingapp.userservice.dto.UserDTO;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toDTO(UserEntity source);

}
