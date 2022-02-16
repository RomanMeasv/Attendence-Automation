package attendance.be;

import java.util.List;

public class _Class {
    private String name;
    private List<Student> students;
    private List<Lesson> lessons;

    public _Class(String name, List<Student> students, List<Lesson> lessons)
    {
        this.name = name;
        this.students = students;
        this.lessons = lessons;
    }
}
