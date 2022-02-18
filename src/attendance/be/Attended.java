package attendance.be;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Attended {
    LocalDateTime start;
    LocalDateTime end;

    public Attended(LocalDateTime start, LocalDateTime end)
    {
        this.start = start;
        this.end = start;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getFormatOverView(){
        String result = "";
        return  result + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(start) + " - " + DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(end);
    }

}
