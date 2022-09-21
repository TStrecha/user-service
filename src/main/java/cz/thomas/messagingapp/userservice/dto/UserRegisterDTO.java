package cz.thomas.messagingapp.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private String username;

    private String name;

    private String password;

    private List<ContactDTO> contacts;

}
