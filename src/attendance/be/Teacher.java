package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
