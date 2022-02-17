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
    Student s1;
    Student s2;
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
        //Student attendance
        Attended a1 = new Attended("08:02", "10:30");
        Attended a2 = new Attended("06:02", "9:30");
        Attended a3 = new Attended("04:02", "11:30");
        Attended a4 = new Attended("13:02", "19:30");
        Attended a5= new Attended("15:02", "16:30");
        s1.addAttendeds(a1);
        s1.addAttendeds(a2);
        s1.addAttendeds(a3);
        s1.addAttendeds(a4);
        s1.addAttendeds(a5);
        s2.addAttendeds(a1);
        s1.addAttendeds(a2);
        s1.addAttendeds(a3);
        s1.addAttendeds(a4);
        s1.addAttendeds(a5);



    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }

    public List<_Class> getAllClasses(){
        return allClasses;
    }

    public List<Attended> getS1Attendance(){
        return s1.getAttendeds();
    }
    public List<Attended> getS2Attendance(){
        return s2.getAttendeds();
    }
}
