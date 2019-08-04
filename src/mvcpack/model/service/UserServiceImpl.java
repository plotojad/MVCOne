package mvcpack.model.service;

import mvcpack.Util;
import mvcpack.bean.User;
import mvcpack.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();


    @Override
    public User deleteUser(long id) {
        User user = userDao.getUserById(id);
        Util.markDeleted(user);
        return user;
    }

    @Override
    public User createOrUpdateUser(String name, long id, int level) {
        User user = new User(name, id, level);
        return userDao.createOrUpdate(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getUsersByName(name);
    }

    @Override
    public List<User> getAllDeletedUsers() {
        List<User> result = new ArrayList<>();
        for (User user : userDao.getAllUsers()){
            if (Util.isUserDeleted(user)){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> getUsersBetweenLevels(int fromLvl, int toLvl) {
        List<User> result = new ArrayList<>();
        for (int i = fromLvl; i < toLvl; i++) {
            result.addAll(userDao.getUsersByLevel(i));
        }
        return result;
    }

    @Override
    public List<User> filterOnlyActiveUsers(List<User> allUsers) {
        List<User> result = new ArrayList<>();
        for (User user : allUsers){
            if (User.NULL_USER != user && !Util.isUserDeleted(user)){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getUsersById(userId);
    }
}
