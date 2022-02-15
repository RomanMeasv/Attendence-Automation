package attendance.be;

public class TimeTable {
    private Lesson[][] slots = new Lesson[5][6];

    public TimeTable(Lesson[][] slots) {
        this.slots = slots;
    }
    public Lesson[][] getSlots() {
        return slots;
    }

    public void setSlots(Lesson[][] slots) {
        this.slots = slots;
    }


}
