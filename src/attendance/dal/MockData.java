package attendance.dal;

import attendance.be.*;
import javafx.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockData {
    private List<User> users;

    private HashMap<User, Pair<String, String>> userCredentials;
    private List<_Class> classes = new ArrayList<>();

    public MockData(){
        userCredentials = new HashMap<>();
        initMockData();
    }

    private void initMockData() {
        Teacher t = new Teacher("Jeppe");
        Student s = new Student("Milos");

        userCredentials.put(t, new Pair<>("admin", "admin"));
        userCredentials.put(s, new Pair<>("student", "student"));

        //Teacher's Page ---
        //list of classes
        _Class c1 = new _Class("CSe21.B");
        _Class c2 = new _Class("CSe22.B");
        classes.add(c1);
        classes.add(c2);
        //list of students

        //Class overview
        //list of Student (names), total attendance (%), most missed class (String)
        //...
    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }

    public List<_Class> getClasses(){
        return classes;
    }
}
