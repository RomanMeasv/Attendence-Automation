package attendance.be;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Lesson {
    private String name;
    private Teacher teacher;
    private String room;
    private LocalDateTime start;
    private LocalDateTime end;
    private String startTime;
    private String endTime;

    public Lesson(String name, Teacher teacher, String room, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
        this.start = start;
        this.end = end;
        this.startTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(start);
        this.endTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(end);
    }

    @Override
    public String toString(){
        return "%s:%s".formatted(start.toString(), end.toString());
    }

    public String getFullLessonInfoString(){
        String result = "";
        return  result + getName()+" "+getLessonPeriodString();
    }

    public String getLessonPeriodString(){
        String result = "";
        return  result + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(start) + " - " + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(end);
    }

    public LocalDateTime getStart(){
        return start;
    }

    public LocalDateTime getEnd()
    {
        return end;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
