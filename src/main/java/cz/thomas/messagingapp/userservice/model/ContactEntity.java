package cz.thomas.messagingapp.userservice.model;

import cz.thomas.messagingapp.userservice.constants.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "contact")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "unique_type_primary", columnNames = {"isPrimary", "user_id", "type"}),
        @UniqueConstraint(name = "unique_value", columnNames = {"value", "type"})
})
public class ContactEntity {

    private static final String SEQUENCE_NAME = "contact_sequence";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id", updatable = false)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContactType type;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false, name = "isPrimary")
    private boolean primary = false;

    @Column(nullable = false, name = "isPrivate")
    private boolean secret = true;

    @ManyToOne(optional = false)
    private UserEntity user;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    private OffsetDateTime confirmedAt;

    @OneToOne(mappedBy = "contact")
    private ConfirmationEntity confirmation;
}
