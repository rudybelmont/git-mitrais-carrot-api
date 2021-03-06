package com.mitrais.carrot.implementation;

/**
 *
 * @author rudy@mitrais.com
 */

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mitrais.carrot.models.Role;
import com.mitrais.carrot.models.User;
import com.mitrais.carrot.repositories.RoleRepository;
import com.mitrais.carrot.repositories.UserRepository;
import com.mitrais.carrot.services.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user, String role) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        user.setActive(1);
        Role userRole = roleRepository.findByRoleName(role);
        user.setRole(userRole);
        userRepository.save(user);
    }

}
