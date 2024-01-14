package plane;

public class airplaneGenerator {
    static Director director = new Director();
    public static airplane generatePlane() {
        int rand = (Math.random()<0.5)?0:1;
        if (rand == 1) {
            int randNum = getRandom1to3();
            switch (randNum) {
                case 1 -> {
                    director.setBuilder(new boeingBuilder());
                    return (director.buildAirplane());
                }
                case 2 -> {
                    director.setBuilder(new airbusBuilder());
                    return (director.buildAirplane());
                }
                case 3 -> {
                    director.setBuilder(new kukuruznikBuilder());
                    return (director.buildAirplane());
                }
            }
        }
        return null;
    }
    private static int getRandom1to3()
    {
        return (int) (Math.random() * 3)+1;
    }
}
