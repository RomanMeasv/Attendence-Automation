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

    public MockData(){
        userCredentials = new HashMap<>();
        initMockData();
    }

    private void initMockData() {
        Teacher t = new Teacher("Jeppe");

        Attended a1 = new Attended(LocalDateTime.parse("2022-02-16T8:00:00"), LocalDateTime.parse("2022-02-16T8:45:00"));
        Attended a2 = new Attended(LocalDateTime.parse("2022-02-16T9:00:00"), LocalDateTime.parse("2022-02-16T10:00:00"));

        List<Attended> attendance = new ArrayList<>();
        attendance.add(a1);
        attendance.add(a2);

        Student s = new Student("Milos", attendance);

        List<Student> students = new ArrayList<>();
        students.add(s);

        Lesson l = new Lesson("SceneBuilder for beginners", t, "A69", LocalDateTime.parse("2022-02-16T8:00:00"), LocalDateTime.parse("2022-02-16T12:00:00"));

        List<Lesson> lessons = new ArrayList<>();
        lessons.add(l);

        _Class c = new _Class("Scrubs", students, lessons);


        userCredentials.put(t, new Pair<>("admin", "admin"));
        userCredentials.put(s, new Pair<>("student", "student"));
    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }
}
