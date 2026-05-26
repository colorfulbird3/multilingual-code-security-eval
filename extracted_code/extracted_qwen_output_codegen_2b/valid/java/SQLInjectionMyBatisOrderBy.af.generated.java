package org.cloudfoundry.samples.service.discovery.dao.user;

import org.cloudfoundry.samples.service.discovery.dao.user.model.User;

import java.util.List;

public interface UserDao {

    User getUser(String id);

    User getUser(String username, String password);

    User getUserByUserName(String username);

    User getUserByUserAddress(String userAddress);

    User getUserByUserId(String id);

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

    User getUserByUserNameAndPassword(String username, String password);

    User getUserByFirstNameAndLastName(String firstName, String lastName);

    User getUserByLastNameAndFirstName(String lastName, String firstName);

    User getUserByUsernameAndPassword(String username, String password);

    User addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> getUsers();
}