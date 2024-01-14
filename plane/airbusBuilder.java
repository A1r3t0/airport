package plane;

public class airbusBuilder extends airplaneBuilder {
    @Override
    void buildPlaneType() {
        airplane.setType(airplaneType.AIRBUSA320);
    }

    @Override
    void buildSerialNo() {
        airplane.setSerialNo("RE-" + getRandomSerialNo());
    }

    @Override
    void buildFuel() {
        airplane.setFuel(getRandomFuel());
    }

    @Override
    void buildLandingTime() {
        airplane.setLandingTime(7000);
    }

    public int getRandomSerialNo()
    {
        return (int) (Math.random() * 10000);
    }
    public int getRandomFuel()
    {
        return (int) (Math.random() * 10000 + 100);
    }
}
