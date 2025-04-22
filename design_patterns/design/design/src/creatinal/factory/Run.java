package creatinal.factory;

public class Run {
    public static void main(String[] args) {
        ChooesVehicle chooseVehicle = new ChooesVehicle();
        Deliver deliver = chooseVehicle.getVehicle("car");
        System.out.println(deliver.deliver());
    }
}
