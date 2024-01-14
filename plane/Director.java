package plane;

public class Director {
    airplaneBuilder builder;

    public void setBuilder(airplaneBuilder builder) {
        this.builder = builder;
    }
    public airplane buildAirplane() {
        builder.createAirplane();
        builder.buildPlaneType();
        builder.buildFuel();
        builder.buildSerialNo();
        builder.buildLandingTime();

        return builder.getAirplane();
    }
}