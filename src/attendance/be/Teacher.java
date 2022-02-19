package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Teacher other = (Teacher) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }
}
