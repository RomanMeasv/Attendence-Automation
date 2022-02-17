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
    private List<_Class> allClasses;

    public MockData(){
        userCredentials = new HashMap<>();
        allClasses = new ArrayList<>();

        initMockData();
    }

    private void initMockData() {
        //list of teacher
        Teacher t = new Teacher("Jeppe");
        //list of students
        Student s1 = new Student("Milos", 0.11f,"Monday", "ITO");
        Student s2 = new Student("Roman", 0.12f,"Tuesday", "SCO");

        //login data for users
        userCredentials.put(t, new Pair<>("", ""));
        userCredentials.put(s1, new Pair<>("student1", "student1"));
        userCredentials.put(s2, new Pair<>("student2", "student2"));

        //Teacher's Page ---
        //list of classes
        _Class c1 = new _Class("CSe21.B");
        c1.addStudent(s1);
        _Class c2 = new _Class("CSe22.B");
        c2.addStudent(s2);

        allClasses.add(c1);
        allClasses.add(c2);

        //Class overview
        //list of Student (names), total attendance (%), most missed class (String)
        //...
    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }

    public List<_Class> getAllClasses(){
        return allClasses;
    }
}
