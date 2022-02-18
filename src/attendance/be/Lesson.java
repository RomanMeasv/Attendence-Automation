package attendance.be;

import java.sql.Time;
import java.time.LocalDateTime;

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
        return  result + this.name+" " + start.getHour()+":"+start.getMinute()+" - " + end.getHour()+":" + end.getMinute();

    }
}
