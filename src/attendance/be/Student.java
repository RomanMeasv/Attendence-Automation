package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
