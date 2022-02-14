package be;

public class TimeTable {
    private Clas [][] slots = new Clas[5][6];

    public TimeTable(Clas[][] slots) {
        this.slots = slots;
    }
    public Clas[][] getSlots() {
        return slots;
    }

    public void setSlots(Clas[][] slots) {
        this.slots = slots;
    }


}
