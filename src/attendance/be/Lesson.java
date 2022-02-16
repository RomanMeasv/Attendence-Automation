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
}
