package attendance.be;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;
    private double totalAbsence;
    private String mostMissedClass;
    private String mostMissedDay;
    private List<Attended> attendeds;

    public Student(String name, double totalAbsence, String mostMissedClass, String mostMissedDay)
    {
        attendeds = new ArrayList<>();
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

    public List<Attended> getAttendeds(){
        return this.attendeds;
    }
    public void addAttendeds(Attended a ){
        this.attendeds.add(a);
    }

    public List<String> getFormatedAttendace(){
        List<String> formatedAttendance = new ArrayList<>();
        for(Attended a :this.attendeds){
            String result = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(a.start) + " - " + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(a.end);
            formatedAttendance.add(result);
        }
        return formatedAttendance;
    }
}
