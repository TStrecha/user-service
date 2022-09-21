package cz.thomas.messagingapp.userservice.model.repository;

import cz.thomas.messagingapp.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
