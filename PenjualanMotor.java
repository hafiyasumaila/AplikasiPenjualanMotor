import java.util.ArrayList;
import java.util.Scanner;

class Motor {
    String merek;
    String model;
    int tahun;
    int harga;

    Motor(String merek, String model, int tahun, int harga) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return merek + " " + model + " - Tahun " + tahun + " - Rp " + harga;
    }
}

class BeliMotor {
    String nama;
    String alamat;
    String nomorTelepon;
    Motor motor;
    int jumlah;
    int totalHarga;

    BeliMotor(String nama, String alamat, String nomorTelepon, Motor motor, int jumlah) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.motor = motor;
        this.jumlah = jumlah;
        this.totalHarga = motor.harga * jumlah;
    }

    public void printInfo() {
        System.out.println("-------------------");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        System.out.println("Merk: " + motor.merek);
        System.out.println("Model: " + motor.model);
        System.out.println("Tahun: " + motor.tahun);
        System.out.println("Harga: Rp " + motor.harga);
        System.out.println("-------------------");
    }
}

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

public class PenjualanMotor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MotorStore motorStore = new MotorStore();
        BeliMotor beliMotor = null;
        int hargaDiskon = 0;
        int diskon = 0;

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    motorStore.displayMotorList();
                    break;
                case 2:
                    searchMotor(scanner, motorStore);
                    break;
                case 3:
                    beliMotor = inputBeliMotor(scanner, motorStore);
                    break;
                case 4:
                    hargaDiskon = displayPembelianDetail(scanner, motorStore, beliMotor, hargaDiskon, diskon);
                    break;
                case 5:
                    processPembayaran(scanner, hargaDiskon, diskon);
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi penjualan motor.");
                    System.out.println("Semoga anda puas dengan layanan kami.");
                    System.out.println("Selamat tinggal dan sampai jumpa lagi!!!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu kembali.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=============MENU=================");
        System.out.println("1. Tampilkan Daftar Motor");
        System.out.println("2. Cari Motor");
        System.out.println("3. Detail Motor Yang Ingin Dibeli");
        System.out.println("4. Info Pembelian");
        System.out.println("5. Info Pembayaran");
        System.out.println("6. Keluar");
        System.out.println("===================================");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void searchMotor(Scanner scanner, MotorStore motorStore) {
        System.out.print("Masukkan merek motor yang ingin dicari: ");
        String merekCari = scanner.next();
        System.out.print("Masukkan model motor yang ingin dicari: ");
        String modelCari = scanner.next();

        boolean ditemukan = false;
        for (Motor motor : motorStore.getMotorList()) {
            if (motor.merek.equalsIgnoreCase(merekCari) && motor.model.equalsIgnoreCase(modelCari)) {
                System.out.println("Motor ditemukan:");
                System.out.println(motor);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Motor dengan merek " + merekCari + " dan model " + modelCari + " tidak ditemukan.");
        }
    }

    private static BeliMotor inputBeliMotor(Scanner scanner, MotorStore motorStore) {
        System.out.print("Masukkan nomor motor yang ingin dibeli: ");
        int nomorMotor = scanner.nextInt() - 1;
        while (nomorMotor < 0 || nomorMotor >= motorStore.getMotorList().size()) {
            System.out.print("Nomor motor tidak valid, silakan masukkan nomor yang valid: ");
            nomorMotor = scanner.nextInt() - 1;
        }
        System.out.println("Masukkan data diri:");
        System.out.print("Nama: ");
        String nama = scanner.next();
        System.out.print("Alamat: ");
        String alamat = scanner.next();
        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.next();

        System.out.println("-----------------------------");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        Motor selectedMotor = motorStore.getMotorByIndex(nomorMotor);
        System.out.println(selectedMotor);
        System.out.println("-------------------------------");

        return new BeliMotor(nama, alamat, nomorTelepon, selectedMotor, 1);
    }

    private static int displayPembelianDetail(Scanner scanner, MotorStore motorStore, BeliMotor beliMotor, int hargaDiskon, int diskon) {
        System.out.print("Masukkan nomor motor yang dibeli: ");
        int nomorMotorDiskon = scanner.nextInt() - 1;
        while (nomorMotorDiskon < 0 || nomorMotorDiskon >= motorStore.getMotorList().size()) {
            System.out.print("Nomor motor tidak valid, silakan masukkan nomor yang valid: ");
            nomorMotorDiskon = scanner.nextInt() - 1;
        }

        System.out.print("Masukkan jumlah motor yang ingin dibeli: ");
        int jumlahDiskon = scanner.nextInt();

        hargaDiskon = motorStore.getMotorByIndex(nomorMotorDiskon).harga * jumlahDiskon;


        if (hargaDiskon >= 3500000) {
            diskon = hargaDiskon / 10;
            hargaDiskon -= diskon;
        }
        System.out.println("------------Detail Pembelian-----------");
        System.out.println(motorStore.getMotorByIndex(nomorMotorDiskon));
        System.out.println("Jumlah: " + jumlahDiskon);
        System.out.println("Harga: Rp " + diskon);
        System.out.println("TotalDiskon: Rp " + hargaDiskon);
        System.out.println("Anda mendapatkan diskon");
        System.out.println("----------------------------------------");

        return hargaDiskon;
    }

    private static void processPembayaran(Scanner scanner, int hargaDiskon, int diskon) {
        System.out.println("Metode Pembayaran:");
        System.out.println("1. BNI");
        System.out.println("2. BRI");
        System.out.println("3. Dana");
        System.out.print("Masukkan pilihan: ");
        int metodePembayaran = scanner.nextInt();

        // proses pembayaran
        if (metodePembayaran == 1 || metodePembayaran == 2 || metodePembayaran == 3) {
            System.out.print("Masukkan nomor rekening: ");
            String rekening = scanner.next();
            System.out.println("Total Pembelian: Rp " + hargaDiskon);
            System.out.println("Selamat anda telah berhasil membeli motor ");
            System.out.println("===============================================");
        } else {
            System.out.println("Pilihan tidak valid, silakan pilih kembali.");
        }
    }
}

