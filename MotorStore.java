import java.util.ArrayList;
class MotorStore {
    private ArrayList<Motor> motorList;

    public MotorStore() {
        motorList = new ArrayList<>();
        initializeMotors();
    }
    private void initializeMotors() {
        motorList.add(new Motor("Honda", "Beat", 2023, 19000000));
        motorList.add(new Motor("Honda", "CBR1000RR-R", 2022, 38000000));
        motorList.add(new Motor("Yamaha", "NMax", 2023, 28000000));
        motorList.add(new Motor("Yamaha", "MT-15", 2021, 25000000));
        motorList.add(new Motor("Suzuki", "GSX-R150", 2021, 23000000));
        motorList.add(new Motor("Suzuki", "SV650X", 2022, 30000000));
    }

    public void displayMotorList() {
        System.out.println("Daftar Motor:");
        for (int i = 0; i < motorList.size(); i++) {
            System.out.println((i + 1) + ". " + motorList.get(i));
        }
    }
    public Motor getMotorByIndex(int index) {
        return motorList.get(index);
    }
    public ArrayList<Motor> getMotorList() {
        return motorList;
    }
}
