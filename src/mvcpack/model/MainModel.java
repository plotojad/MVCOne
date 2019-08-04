package mvcpack.model;

import mvcpack.bean.User;
import mvcpack.model.service.UserService;
import mvcpack.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    private List<User> getActiveUsers(List<User> actUserList) {
        return userService.filterOnlyActiveUsers(actUserList);
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 200)));
        modelData.setDisplayDeletedUserList(false);

    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);

    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUserById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 200)));
        modelData.setDisplayDeletedUserList(false);

    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 200)));
        modelData.setDisplayDeletedUserList(false);

    }
}
