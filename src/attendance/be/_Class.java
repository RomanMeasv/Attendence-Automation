package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class _Class {
    private String name;
    private List<Student> students;

    public _Class(String name)
    {
        this.name = name;
        this.students = new ArrayList<>();
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
}
