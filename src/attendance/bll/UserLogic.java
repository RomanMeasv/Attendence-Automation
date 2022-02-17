package attendance.bll;

import attendance.be.Teacher;
import attendance.be.User;
import attendance.dal.MockData;

import java.util.Map;

public class UserLogic {
    MockData mockData;
    User loggedUser;

    public UserLogic()
    {
        this.mockData = new MockData();
    }

    //Returns the Teacher/Student if the credentials match, returns NULL, if not
    public User tryLogIn(String username, String password){
        loggedUser = mockData.getUserCredentials().entrySet().stream()
                .filter(creds -> creds.getValue().getKey().equals(username) && creds.getValue().getValue().equals(password))
                .map(Map.Entry::getKey).findFirst().orElse(null);
        return loggedUser == null ? null : loggedUser;
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }
}
