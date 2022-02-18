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
    LocalDateTime start;
    LocalDateTime end;

    public Lesson(String name, Teacher teacher, String room, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart(){
        return this.start;
    }

    @Override
    public String toString(){
        return "%s:%s".formatted(start.toString(), end.toString());
    }

    public String getFormatOverView(){
        String result = "";
        return  result + this.name+" "+DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(start) + " - " + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(end);
    }
}
