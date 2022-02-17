package attendance.be;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;
    private double totalAbsence;
    private String mostMissedClass;
    private String mostMissedDay;

    public Student(String name, double totalAbsence, String mostMissedClass, String mostMissedDay)
    {
        this.name = name;
        this.totalAbsence = totalAbsence;
        this.mostMissedClass = mostMissedClass;
        this.mostMissedDay = mostMissedDay;
    }

    public String getName()
    {
        return name;
    }

    public double getTotalAbsence() {
        return totalAbsence;
    }

    public String getMostMissedClass() {
        return mostMissedClass;
    }

    public String getMostMissedDay() {
        return mostMissedDay;
    }
}
