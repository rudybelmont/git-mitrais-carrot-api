package com.mitrais.carrot.services;

import com.mitrais.carrot.models.User;

/**
 *
 * @author rudy@mitrais.com_MW251
 */
public interface UserService {

    /**
     * find user by email
     *
     * @param email
     * @return
     */
    public User findUserByEmail(String email);

    /**
     * create new user
     *
     * @param user
     */
    public void saveUser(User user, String role);
}
