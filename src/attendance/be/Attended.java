package attendance.be;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Attended {
    LocalDateTime start;
    LocalDateTime end;
    private String startTime;
    private String endTime;



    public Attended(LocalDateTime start, LocalDateTime end)
    {
        this.start = start;
        this.end = end;
        this.startTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(start);
        this.endTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(end);
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
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

}
