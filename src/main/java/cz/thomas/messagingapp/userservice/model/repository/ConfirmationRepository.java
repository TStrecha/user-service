package cz.thomas.messagingapp.userservice.model.repository;

import cz.thomas.messagingapp.userservice.model.ConfirmationEntity;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {

}
