package mvcpack.model.service;

import mvcpack.bean.User;

import java.util.List;

public interface UserService {
    public User deleteUser(long id);

    public User createOrUpdateUser (String name, long id, int level);

    public List<User> getUserByName(String name);

    public List<User> getAllDeletedUsers();

    public List<User> getUsersBetweenLevels (int fromLvl, int toLvl);

    List<User> filterOnlyActiveUsers (List<User> allUsers);

    User getUserById(long userId);

}
