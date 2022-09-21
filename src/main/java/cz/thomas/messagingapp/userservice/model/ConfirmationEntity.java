package cz.thomas.messagingapp.userservice.model;

import cz.thomas.messagingapp.userservice.constants.ConfirmationState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "confirmation")
public class ConfirmationEntity {

    private static final String SEQUENCE_NAME = "confirmation_sequence";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id", updatable = false)
    @Access(AccessType.PROPERTY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConfirmationState confirmationState;

    @Column(nullable = false)
    private String confirmationKey;

}
