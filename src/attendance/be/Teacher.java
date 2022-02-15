package attendance.be;

public class Teacher {
    private String tfName;
    private String tlName;

    public Teacher(String tfName, String tlName) {
        this.tfName = tfName;
        this.tlName = tlName;
    }

    public String getTfName() {
        return tfName;
    }

    public void setTfName(String tfName) {
        this.tfName = tfName;
    }

    public String getTlName() {
        return tlName;
    }

    public void setTlName(String tlName) {
        this.tlName = tlName;
    }
}
