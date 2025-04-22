package creatinal.factory;

public class ChooesVehicle {
    public Deliver getVehicle(String vehicle) {
        Deliver deliver = null;
        switch (vehicle) {
            case "car":
                deliver = new CarDeliver();
                break;
            case "moto":
                deliver = new MotoDeliver();
                break;
        }
        return deliver;
    }
}
