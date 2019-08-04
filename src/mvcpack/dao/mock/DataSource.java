package mvcpack.dao.mock;

import mvcpack.bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance(){
        return ourInstance;
    }

    private DataSource(){

    }

    private List<User> users = new LinkedList<>(){{
        add(new User("Pelmen", 123, 2));
        add(new User("Zorg", 124, 1));
        add(new User("Boccia", 125, 1));
        add(new User("Minus", 126, 2));
    }};

    private long maxUserId = 126;

    public List<User> getUsers(){
        return users;
    }

    private User createNewUser (User newUser){
        User cloneUser = newUser.clone(++maxUserId);
        users.add(cloneUser);
        return cloneUser;
    }

    private User updateUser(User newUser){
        for (User user : users){
            if (user.getId() == newUser.getId()){
                user.setName(newUser.getName());
                user.setLevel(newUser.getLevel());
                return user;
            }
        }
        return User.NULL_USER;
    }

    public User createOrUpdate (User newUser){
        if (newUser == User.NULL_USER){
            return User.NULL_USER;
        }
        if (newUser.getId() == 0){
            return createNewUser(newUser);
        }
        else {
            return updateUser(newUser);
        }
    }
}
