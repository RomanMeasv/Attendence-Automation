package attendance.be;

import java.util.List;

public class Lesson {
    private String cName;
    private List<Student> cStudents;

    public Lesson(String cName, List<Student> cStudents){
        this.cName = cName;
        this.cStudents = cStudents;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Student> getcStudents() {
        return cStudents;
    }

    public void setcStudents(List<Student> cStudents) {
        this.cStudents = cStudents;
    }


}
