package plane;

public class boeingBuilder extends airplaneBuilder {

    @Override
    void buildPlaneType() {
        airplane.setType(airplaneType.BOEING737);
    }

    @Override
    void buildSerialNo() {
        airplane.setSerialNo("RE-" + getRandomSerialNo());
    }

    @Override
    void buildFuel() {
        airplane.setFuel(getRandomFuel());
    }
    public int getRandomSerialNo()
    {
        return (int) (Math.random() * 10000);
    }
    public int getRandomFuel()
    {
        return (int) (Math.random() * 10000 + 100);
    }
    @Override
    void buildLandingTime() {
        airplane.setLandingTime(8000);
    }
}
