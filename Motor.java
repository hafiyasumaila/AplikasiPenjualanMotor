import java.util.ArrayList;
import java.util.Scanner;

class Motor {
    String merek;
    String model;
    int tahun;
    String kondisi;
    int harga;

    public Motor(String merek, String model, int tahun, String kondisi, int harga) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
        this.kondisi = kondisi;
        this.harga = harga;
    }

    public String toString() {
        return "Merek: " + merek + ", Model: " + model + ", Tahun: " + tahun + ", Kondisi: " + kondisi + ", Harga: " + harga;
    }
}

class Inventory {
    ArrayList<Motor> daftarMotor = new ArrayList<>();

    public void tambahMotor(Motor motor) {
        daftarMotor.add(motor);
    }

    public void tampilkanMotor() {
        if (daftarMotor.isEmpty()) {
            System.out.println("Belum ada motor yang tersedia.");
        } else {
            System.out.println("Daftar Motor:");
            for (int i = 0; i < daftarMotor.size(); i++) {
                System.out.println((i + 1) + ". " + daftarMotor.get(i));
            }
        }
    }

    public Motor detailMotor(int nomorMotor) {
        if (nomorMotor >= 0 && nomorMotor < daftarMotor.size()) {
            return daftarMotor.get(nomorMotor);
        } else {
            return null;
        }
    }

    public Motor beliMotor(int nomorMotor) {
        if (nomorMotor >= 0 && nomorMotor < daftarMotor.size()) {
            return daftarMotor.remove(nomorMotor);
        } else {
            return null;
        }
    }
}

class Pengguna {
    String username;
    String password;

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean cocok(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}
