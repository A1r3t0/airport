package plane;

public abstract class airplaneBuilder {
    airplane airplane;
    void createAirplane() {
        airplane = new airplane();
    }
    abstract void buildPlaneType();
    abstract void buildSerialNo();
    abstract void buildFuel();
    abstract void buildLandingTime();
    airplane getAirplane() {
        return airplane;
    }
}
