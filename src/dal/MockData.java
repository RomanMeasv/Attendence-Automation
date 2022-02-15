package dal;

import attendance.be.Student;
import attendance.be.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockData {
    private List<Teacher> teachers;
    private List<Student> students;

    private HashMap<Teacher, String> teacherPasswords;
    private HashMap<Student, String> studentPasswords;

    public MockData(){
        initTeachers();
        initStudents();
    }

    private void initTeachers(){
        teachers = new ArrayList<>();
        teacherPasswords = new HashMap<>();
        createTeachers();
        createTeacherPasswords();
    }

    private void initStudents(){
        students = new ArrayList<>();
        studentPasswords = new HashMap<>();
        createStudents();
        createStudentPasswords();
    }

    private void createTeachers(){
        Teacher t = new Teacher("Roman", "Masar");
        teachers.add(t);
    }

    private void createStudents(){
        //Student s = new Student("Ádám", "Lorincz");
        //students.add(s);
    }

    public void createTeacherPasswords(){
        for (Teacher t :
                teachers) {
            teacherPasswords.put(t, "admin");
        }
    }

    public void createStudentPasswords(){
        for (Student s :
                students) {
            studentPasswords.put(s, "user");
        }
    }

    public Teacher validateTeacher(String pass){
        return teacherPasswords.entrySet().stream()
                .filter(password -> pass.equals(password.getValue()))
                .map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public Student validateStudent(String pass){
        return studentPasswords.entrySet().stream()
                .filter(password -> pass.equals(password.getValue()))
                .map(Map.Entry::getKey).findFirst().orElse(null);
    }
}
