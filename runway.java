import plane.airplaneType;

public class runway {
    boolean isBusy;
    int type;
    airplaneType busyBy;

    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public int getType() {
        return type;
    }

    public void setBusyBy(airplaneType busyBy) {
        this.busyBy = busyBy;
    }
    public runway(boolean isBusy, int i) {
        this.isBusy = isBusy;
        this.type = i;
    }
}
