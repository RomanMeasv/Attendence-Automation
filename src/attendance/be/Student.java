package attendance.be;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int id;
    private String name;
    private double totalAbsence;
    private String mostMissedClass;
    private String mostMissedDay;
    private List<Attended> attendeds;

    public Student(int id, String name, double totalAbsence, String mostMissedClass, String mostMissedDay)
    {
        this.id = id;
        this.name = name;
        this.totalAbsence = totalAbsence;
        this.mostMissedClass = mostMissedClass;
        this.mostMissedDay = mostMissedDay;
        attendeds = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public double getTotalAbsence() {
        return totalAbsence;
    }

    public String getTotalAbsenceString()
    {
        return String.format("%.2f", totalAbsence) + "%";
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

    public ObservableList<Attended> getAttendanceForDay(LocalDate localDate){
        List<Attended> dayAttendacne = new ArrayList<>();
        for(Attended a : this.attendeds){
            if(a.start.format(DateTimeFormatter.ISO_DATE).equals(localDate.format(DateTimeFormatter.ISO_DATE))){
                dayAttendacne.add(a);
            }
        }
        return FXCollections.observableList(dayAttendacne);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }
}
