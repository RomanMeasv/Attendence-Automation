package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;
    private List<Attended> attendance;

    public Student(String name)
    {
        this.name = name;
    }
}
