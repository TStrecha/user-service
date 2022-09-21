package cz.thomas.messagingapp.userservice.dto;

import cz.thomas.messagingapp.userservice.constants.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Long id;

    private ContactType type;

    private String value;

    private boolean confirmed;

    private boolean primary;

    private boolean secret;

    private OffsetDateTime createdAt;

    private OffsetDateTime confirmedAt;

}
