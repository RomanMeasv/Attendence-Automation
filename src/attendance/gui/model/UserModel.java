package attendance.gui.model;

import attendance.be.User;
import attendance.bll.UserLogic;

public class UserModel {
    User loggedUser;
    UserLogic userLogic;

    private static UserModel instance = new UserModel();

    public static UserModel getInstance(){
        return instance;
    }

    private UserModel()
    {
        userLogic = new UserLogic();
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }

    public User tryLogIn(String username, String password)
    {
        return loggedUser = userLogic.tryLogIn(username, password);
    }
}
