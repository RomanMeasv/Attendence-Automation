package be;

import java.util.List;

public class Student {
    private  String sfName;
    private String slName;
    private Clas sClas;

    public Student(String sfName, String slName, Clas sClas) {
        this.sfName = sfName;
        this.slName = slName;
        this.sClas = sClas;
    }

    public String getSfName() {
        return sfName;
    }

    public void setSfName(String sfName) {
        this.sfName = sfName;
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }

    public Clas getsClas() {
        return sClas;
    }

    public void setsClas(Clas sClas) {
        this.sClas = sClas;
    }

    public List<Period> getsPeriods() {
        return sPeriods;
    }

    public void setsPeriods(List<Period> sPeriods) {
        this.sPeriods = sPeriods;
    }

    private List<Period> sPeriods;

}
