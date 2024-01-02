import java.util.ArrayList;
import java.util.Scanner;

class Motor {
    private String merek;
    private String model;
    private int harga;

    public Motor(String merek, String model, int harga) {
        this.merek = merek;
        this.model = model;
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "merek='" + merek + '\'' +
                ", model='" + model + '\'' +
                ", harga=" + harga +
                '}';
    }
}

class Inventory {
    private ArrayList<Motor> motors = new ArrayList<>();

    public void tambahMotor(Motor motor) {
        motors.add(motor);
    }

    public void tampilkanMotor() {
        if (motors.isEmpty()) {
            System.out.println("Inventaris motor kosong");
        } else {
            System.out.println("Daftar Motor:");
            for (int i = 0; i < motors.size(); i++) {
                System.out.println((i + 1) + ". " + motors.get(i));
            }
        }
    }

    public Motor beliMotor(int index) {
        if (index >= 0 && index < motors.size()) {
            return motors.remove(index);
        }
        return null;
    }
}
