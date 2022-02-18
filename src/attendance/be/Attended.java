package attendance.be;

import java.time.LocalDateTime;

public class Attended {
    LocalDateTime start;
    LocalDateTime end;

    public Attended(LocalDateTime start, LocalDateTime end)
    {
        this.start = start;
        this.end = start;
    }
}
