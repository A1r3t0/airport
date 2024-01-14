package plane;

public class airplane {
    private String serialNo;
    private int fuel, landingTime;
    private int status = 1;
    private airplaneType type;

    public String getSerialNo() {
        return serialNo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getFuel() {
        return fuel;
    }

    public airplaneType getType() {
        return type;
    }

    public int getLandingTime() {
        return landingTime;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public void setLandingTime(int landingTime) {
        this.landingTime = landingTime;
    }
    public void setType(airplaneType type) {
        this.type = type;
    }
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "airplane{" +
                "serialNo='" + serialNo + '\'' +
                ", fuel=" + fuel +
                ", landingTime=" + landingTime +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
