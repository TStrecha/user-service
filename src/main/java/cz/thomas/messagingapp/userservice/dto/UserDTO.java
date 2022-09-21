package cz.thomas.messagingapp.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String name;

    private List<ContactDTO> contacts = new ArrayList<>();

    private OffsetDateTime registeredAt;

}
