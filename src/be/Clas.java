package be;

import java.util.List;

public class Clas {
    private String cName;
    private List<Student> cStudents;

    public Clas(String cName, List<Student> cStudents){
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
