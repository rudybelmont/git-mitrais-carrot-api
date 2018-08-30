package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rudy@mitrais.com
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * find user by email
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);
}
