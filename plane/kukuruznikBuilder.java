package plane;

public class kukuruznikBuilder extends airplaneBuilder {
    @Override
    void buildPlaneType() {
        airplane.setType(airplaneType.KUKURUZNIK);
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
        airplane.setLandingTime(3000);
    }
    public int getRandomSerialNo()
    {
        return (int) (Math.random() * 10000);
    }
    public int getRandomFuel()
    {
        return (int) (Math.random() * 1000 + 100);
    }
}
