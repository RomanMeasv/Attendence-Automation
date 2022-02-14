package be;

import java.sql.Time;

public class Period {
    private String pName;
    private Teacher pTeacher;
    private String classRoom;
    private Time pStart;
    private Time pEnd;

    public Period(String pName, Teacher pTeacher, String classRoom, Time pStart, Time pEnd) {
        this.pName = pName;
        this.pTeacher = pTeacher;
        this.classRoom = classRoom;
        this.pStart = pStart;
        this.pEnd = pEnd;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Teacher getpTeacher() {
        return pTeacher;
    }

    public void setpTeacher(Teacher pTeacher) {
        this.pTeacher = pTeacher;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Time getpStart() {
        return pStart;
    }

    public void setpStart(Time pStart) {
        this.pStart = pStart;
    }

    public Time getpEnd() {
        return pEnd;
    }

    public void setpEnd(Time pEnd) {
        this.pEnd = pEnd;
    }
}
