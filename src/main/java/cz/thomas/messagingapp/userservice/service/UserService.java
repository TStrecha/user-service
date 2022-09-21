package cz.thomas.messagingapp.userservice.service;

import cz.thomas.messagingapp.userservice.dto.UserDTO;
import cz.thomas.messagingapp.userservice.dto.UserRegisterDTO;
import cz.thomas.messagingapp.userservice.dto.mapper.ContactMapper;
import cz.thomas.messagingapp.userservice.dto.mapper.UserMapper;
import cz.thomas.messagingapp.userservice.model.UserEntity;
import cz.thomas.messagingapp.userservice.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ContactMapper contactMapper;
    private final ContactService contactService;

    private final SecureRandom random = new SecureRandom();

    public UserDTO getUserById(Long id){
        var user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No user found for id [" + id + "]"));
        return userMapper.toDTO(user);
    }

    public UserDTO getUserByUsername(String username){
        var user = userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("No user found for username [" + username + "]"));
        return userMapper.toDTO(user);
    }

    public UserDTO registerUser(UserRegisterDTO registerDTO) {
        UserEntity user = new UserEntity();
        UserEntity finalUser = user;
        var contacts = registerDTO.getContacts().stream().map(contact -> contactMapper.fromDTO(contact, finalUser)).toList();
        var hashedPassword = hashPassword(registerDTO.getPassword());

        userMapper.fromRegisterDTO(user, registerDTO, contacts, hashedPassword);
        user = userRepository.save(user);

        user.getContacts().forEach(contact -> {
            contactService.createConfirmation(contact);
        });
        return userMapper.toDTO(user);
    }

    @SneakyThrows
    public String hashPassword(String password){
        var salt = new byte[16];
        random.nextBytes(salt);
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        var hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getMimeEncoder().encodeToString(hashedBytes);
    }
}
