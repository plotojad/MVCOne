package mvcpack;

import mvcpack.controller.Controller;
import mvcpack.model.MainModel;
import mvcpack.model.Model;
import mvcpack.view.EditUserView;
import mvcpack.view.UsersView;

public class Main {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();



        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
        usersView.fireEventOpenUserEditForm(125);
        editUserView.fireEventUserDeleted(125);
        editUserView.fireEventUserChanged("ABC", 125, 7);
    }
}
