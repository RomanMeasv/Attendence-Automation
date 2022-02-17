package attendance.be;

import java.time.LocalDateTime;

public class Attended {
    LocalDateTime start;
    LocalDateTime end;

    public Attended(String start, String end)
    {
        this.start = LocalDateTime.parse(start);
        this.end = LocalDateTime.parse(end);
    }
}
