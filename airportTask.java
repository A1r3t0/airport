import plane.*;

import java.util.ArrayList;
import java.util.Objects;

public class airportTask {
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < airplanes.size(); i++) {
//            if (airplanes.get(i) != null) {
//            }


            ArrayList<runway> runways = new ArrayList<>();
            ArrayList<airplane> landedPlanes = new ArrayList<>();
            ArrayList<airplane> wantLand = new ArrayList<>();
            ArrayList<airplane> wantTakeoff = new ArrayList<>();
            runway runway1 = new runway(false, 1);
            runway runway2 = new runway(false, 2);
            runway runway3 = new runway(false, 3);
            runways.add(runway1);
            runways.add(runway2);
            runways.add(runway3);
            while (true) {
                int min = 20000;
                wantLand.add(airplaneGenerator.generatePlane());
                wantTakeoff.add(airplaneGenerator.generatePlane());
                wantLand.removeIf(Objects::isNull);
                wantTakeoff.removeIf(Objects::isNull);

                if (!wantLand.isEmpty()) { //есть самолеты, которые хотят приземлиться
                    System.out.println("Есть самолёт для посадки!");
                    for (int i = 0; i < wantLand.size(); i++) {
                        if (wantLand.get(i).getFuel() < min) {
                            min = wantLand.get(i).getFuel();
                        }
                    }
                    for (int i = 0; i < runways.size(); i++) {
                        if (runways.get(i).isBusy == false) {
                            runways.get(i).isBusy = true;
                            System.out.println("Полоса " + runways.get(i).getType() + " свободна.");
                            for (int j = 0; j < wantLand.size(); j++) {
                                if (wantLand.get(j).getFuel() == min) {
                                    System.out.println("Самолёт " + wantLand.get(j).getType() + ", с бортовым номером " + wantLand.get(j).getSerialNo() + " приземляется...");
                                    Thread.sleep(wantLand.get(j).getLandingTime());
                                    System.out.println("Самолёт " + wantLand.get(j).getType() + ", с бортовым номером " + wantLand.get(j).getSerialNo() + " приземлился.");
                                    runways.get(i).busyBy = wantLand.get(j).getType();
                                    landedPlanes.add(wantLand.get(j));
                                    wantLand.remove(j);
                                    runways.get(i).setBusy(false);
                                    runways.get(i).setBusyBy(null);
                                    for (int k = 0; k < wantLand.size(); k++) {
                                        wantLand.get(k).setFuel(wantLand.get(k).getFuel() - 20);
                                    }
                                }
                            }
                        } else {
                            for (int j = 0; j < wantLand.size(); j++) {
                                System.out.println("Нет свободных полос для посадки!");
                                wantLand.get(j).setFuel(wantLand.get(j).getFuel() - 20);
                            }
                        }
                    }
                } /////////////////////////////
                if (!wantTakeoff.isEmpty()) { // если есть самолёты для взлёта
                    System.out.println("Есть самолёт для взлёта!");
                    int max = 0;
                    for (int i = 0; i < wantTakeoff.size(); i++) {
                        if (wantTakeoff.get(i).getStatus() > max) {
                            max = wantTakeoff.get(i).getStatus();
                        }
                    }
                    for (int i = 0; i < runways.size(); i++) {
                        if (runways.get(i).isBusy == false) {
                            System.out.println("Полоса " + runways.get(i).getType() + " свободна.");
                            runways.get(i).isBusy = true;
                            for (int j = 0; j < wantTakeoff.size(); j++) {
                                if (wantTakeoff.get(i).getStatus() == max) {
                                    runways.get(i).busyBy = wantTakeoff.get(j).getType();
                                    System.out.println("Самолёт " + wantTakeoff.get(j).getType() + ", с бортовым номером " + wantTakeoff.get(j).getSerialNo() + " взлетел.");
                                    wantTakeoff.remove(j);
                                    runways.get(i).setBusy(false);
                                    runways.get(i).isBusy = false;
                                    runways.get(i).setBusyBy(null);
                                    for (int k = 0; k < wantTakeoff.size(); k++) {
                                        wantTakeoff.get(k).setStatus(wantTakeoff.get(k).getStatus() + 1);
                                    }
                                }
                            }
                        } else {
                            System.out.println("Нет свободных полос для взлёта!");
                            for (int j = 0; j < wantTakeoff.size(); j++) {
                                wantTakeoff.get(j).setStatus(wantTakeoff.get(j).getStatus() + 1);
                            }
                        }
                    }
                }
            }
        }
    }