package mvcpack.model;

import mvcpack.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {

    ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
//        test data
        List<User> users = new ArrayList<>();
        users.add(new User("A", 1, 1));
        users.add(new User("B", 2, 1));
        users.add(new User("C", 3, 2));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {

    }

    @Override
    public void loadUserById(long userId) {

    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public void changeUserData(String name, long id, int level) {

    }
}
