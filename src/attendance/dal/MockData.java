package attendance.dal;

import attendance.be.*;
import javafx.util.Pair;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockData {
    private List<User> users;

    private HashMap<User, Pair<String, String>> userCredentials;
    private List<_Class> allClasses;
    private List<Lesson> lessons;

    Student s1;
    Student s2;
    public MockData(){
        userCredentials = new HashMap<>();
        allClasses = new ArrayList<>();
        lessons = new ArrayList<>();
        initMockData();
    }

    private void initMockData() {
        //list of teacher
        Teacher t = new Teacher(1, "Jeppe");
        //list of students
         s1 = new Student(1, "Milos", 21d,"ITO", "Monday");
         s2 = new Student(2,"Roman", 30d,"SCO", "Tuesday");

        //login data for users
        userCredentials.put(t, new Pair<>("", ""));
        userCredentials.put(s1, new Pair<>("s1", "s1"));
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
        Attended a1 = new Attended(LocalDateTime.of(2022, 2, 18, 9, 0), LocalDateTime.of(2022, 2, 18, 12, 45));
        Attended a2 = new Attended(LocalDateTime.of(2022, 2, 19, 6, 0), LocalDateTime.of(2022, 2, 19, 13, 45));
        Attended a3 = new Attended(LocalDateTime.of(2022, 2, 20, 7, 0), LocalDateTime.of(2022, 2, 20, 14, 45));
        Attended a4 = new Attended(LocalDateTime.of(2022, 2, 21, 8, 0), LocalDateTime.of(2022, 2, 21, 16, 45));
        Attended a5= new Attended(LocalDateTime.of(2022, 2, 22, 10, 0), LocalDateTime.of(2022, 2,22 , 17, 45));
        s1.addAttendeds(a1);
        s1.addAttendeds(a2);
        s1.addAttendeds(a3);
        s1.addAttendeds(a4);
        s1.addAttendeds(a5);


        Lesson l1 = new Lesson("ITO", t, "Hell",LocalDateTime.of(2022, 2, 18, 9, 0), LocalDateTime.of(2022, 2, 18, 11, 45));
        Lesson l2 = new Lesson("SDE", t, "Fortress",LocalDateTime.of(2022, 2, 19, 6, 0), LocalDateTime.of(2022, 2, 19, 12, 45));
        Lesson l3 = new Lesson("SCO", t, "Jungle",LocalDateTime.of(2022, 2, 20, 7, 0), LocalDateTime.of(2022, 2, 20, 13, 45));
        Lesson l4 = new Lesson("KKT", t, "Narnia",LocalDateTime.of(2022, 2, 21, 8, 0), LocalDateTime.of(2022, 2, 21, 15, 45));
        Lesson l5 = new Lesson("PCO", t, "Latvia",LocalDateTime.of(2022, 2, 22, 10, 0), LocalDateTime.of(2022, 2,22 , 16, 45));

        c1.addLesson(l1);
        c1.addLesson(l2);
        c1.addLesson(l3);
        c1.addLesson(l4);
        c1.addLesson(l5);

        lessons.add(l1);
        lessons.add(l2);
        lessons.add(l3);
        lessons.add(l4);
        lessons.add(l5);
    }

    public HashMap<User, Pair<String, String>> getUserCredentials()
    {
        return userCredentials;
    }

    public List<_Class> getAllClasses(){
        return allClasses;
    }

    public List<Lesson> getLessons(){return  this.lessons;}
}
