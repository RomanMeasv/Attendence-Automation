package attendance.be;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class _Class {
    private String name;
    private List<Student> students;
    private List<Lesson> lessons;

    public _Class(String name)
    {
        this.name = name;
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void addLesson(Lesson lesson)
    {
        lessons.add(lesson);
    }

    public Lesson getLessonAt(LocalDateTime dateTime)
    {
        return lessons.stream().filter(lesson -> dateTime.isAfter(lesson.getStart()) && dateTime.isBefore(lesson.getEnd())).findFirst().orElse(null);
    }
}
