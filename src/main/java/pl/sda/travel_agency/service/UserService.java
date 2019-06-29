package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.User;
import pl.sda.travel_agency.repository.RoleRepository;
import pl.sda.travel_agency.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    //zapisujemy użytkownika po rejestracji do bazy danych
    public void saveUser(UserDto userDto) {

        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());

        User user = new User(userDto.getName(),
                userDto.getLastname(),
                userDto.getEmail(),
                encodedPassword);

        user.addRole(roleRepository.getOne(1L));
        System.out.println(user);
        userRepository.save(user);
    }

    public  void confirmUser(String email){
        User confirmedUser = userRepository.findFirstByEmail(email);
        confirmedUser.setActive(true);
        userRepository.save(confirmedUser);
    }
    public User loginUser(String email, String password){
        return userRepository.findFirstByEmailAndPassword(email,password);
    }

    public void addAdmin(Long id){
        User user = userRepository.getOne(id);
        user.addRole(roleRepository.getOne(1L));
        userRepository.save(user);
    }


}
