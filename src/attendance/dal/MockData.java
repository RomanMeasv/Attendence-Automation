package attendance.dal;

import attendance.be.Lesson;
import attendance.be.Student;
import attendance.be.Teacher;
import attendance.be.User;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockData {
    private List<User> users;

    private HashMap<User, Pair<String, String>> userCredentials;

    public MockData(){
        userCredentials = new HashMap<>();
        initUsers();
    }

    private void initUsers() {
        Teacher t = new Teacher("Jeppe","Moritz");
        Student s = new Student("Roman", "Masár", new Lesson("CS", new ArrayList<>()));

        userCredentials.put(t, new Pair<>("admin", "admin"));
        userCredentials.put(s, new Pair<>("student", "student"));
    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }
}
