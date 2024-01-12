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
        motorList.add(new Motor("Honda", "CBR1000RR-R", 2022, 40000000));
        motorList.add(new Motor("Yamaha", "NMax", 2022, 21000000));
        motorList.add(new Motor("Yamaha", "MT-15", 2022, 25000000));
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
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-6.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("===============Menu=================");
        System.out.println("1. Daftar Motor");
        System.out.println("2. Cari Motor");
        System.out.println("3. Motor Yang Ingin Dibeli");
        System.out.println("4. Info Pembelian");
        System.out.println("5. Pembayaran");
        System.out.println("6. Keluar");
        System.out.println("=====================================");
        System.out.print("Masukkan Pilihan : ");
    }
    private static void searchMotor(Scanner scanner, MotorStore motorStore) {
        System.out.print("Masukkan merek motor yang ingin dicari: ");
        String merekCari = scanner.next();
        boolean ditemukan = false;
        for (Motor motor : motorStore.getMotorList()) {
            if (motor.merek.equalsIgnoreCase(merekCari)) {
                System.out.println("Motor ditemukan:");
                System.out.println(motor);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Motor dengan merek " + merekCari + " tidak ditemukan.");
        }
    }
    private static BeliMotor inputBeliMotor(Scanner scanner, MotorStore motorStore) {
        motorStore.displayMotorList();
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

        System.out.println("--------------------------------");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        Motor selectedMotor = motorStore.getMotorByIndex(nomorMotor);
        System.out.println(selectedMotor);
        System.out.println("----------------------------------");

        return new BeliMotor(nama, alamat, nomorTelepon, selectedMotor, 1);
    }

    private static int displayPembelianDetail(Scanner scanner, MotorStore motorStore, BeliMotor beliMotor, int hargaDiskon, int diskon) {
        System.out.print("Masukkan nomor motor yang ingin dibeli: ");
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
            hargaDiskon -= diskon;  // Corrected calculation for discounted price
            System.out.println("Anda mendapatkan diskon 10%");
            System.out.println("Harga: Rp " + diskon);
        }

        System.out.println("Detail Pembelian:");
        System.out.println("---------------------");
        System.out.println(motorStore.getMotorByIndex(nomorMotorDiskon));
        System.out.println("Jumlah: " + jumlahDiskon);
        System.out.println("Harga: Rp " + diskon);
        System.out.println("TotalDiskon: Rp " + hargaDiskon);  // Corrected line
        System.out.println("----------------------");

       return hargaDiskon;
    }
    private static void processPembayaran(Scanner scanner, int hargaDiskon, int diskon) {
        System.out.println("Metode Pembayaran:");
        System.out.println("1. Pembayaran Tunai");
        System.out.println("2. Pembayaran Non Tunai");
        System.out.print("Masukkan pilihan: ");
        int metodePembayaran = scanner.nextInt();

        //proses pembayaran
        if (metodePembayaran == 1) {
            System.out.println("Total Pembelian: Rp " + hargaDiskon);
            System.out.println("Terima kasih telah berbelanja di TOKO MOTOR JAYA.");
            System.out.println("===============================================");
        } else if (metodePembayaran == 2) {
            System.out.print("Masukkan nomor rekening Anda: ");
            String rekening = scanner.next();
            System.out.println("Total Pembelian: Rp " + hargaDiskon);
            System.out.println("Terima kasih telah berbelanja di TOKO MOTOR.");
            System.out.println("===============================================");
        } else {
            System.out.println("Pilihan tidak valid, silakan pilih kembali.");
        }
    }
}


//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Motor {
//    String merek;
//    String model;
//    int tahun;
//    int harga;
//
//    Motor(String merek, String model, int tahun, int harga) {
//        this.merek = merek;
//        this.model = model;
//        this.tahun = tahun;
//        this.harga = harga;
//    }
//}
//
//class BeliMotor {
//    String nama;
//    String alamat;
//    String nomorTelepon;
//    Motor motor;
//    int jumlah;
//    int totalHarga;
//    BeliMotor(String nama, String alamat, String nomorTelepon, Motor motor, int jumlah) {
//        this.nama = nama;
//        this.alamat = alamat;
//        this.nomorTelepon = nomorTelepon;
//        this.motor = motor;
//        this.jumlah = jumlah;
//        this.totalHarga = motor.harga * jumlah;
//    }
//}
//
//public class PenjualanMotor {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Motor> motorList = new ArrayList<>();
//
//        Motor[] data = {
//                new Motor("Honda", "Beat", 2023, 19000000),
//                new Motor("Yamaha", "NMax", 2022, 28000000),
//                new Motor("Suzuki", "GSX-R150", 2021, 22000000)
//        };
//        for (Motor motor : data) {
//            motorList.add(motor);
//        }
//
//        boolean selesai = false;
//        int hargaDiskon = 0;
//        int diskon = 0;
//
//        while (!selesai) {
//            System.out.println("===============Menu=================:");
//            System.out.println("1. Daftar Motor");
//            System.out.println("2. Cari Motor");
//            System.out.println("3. Motor YangIngin Dibeli");
//            System.out.println("4. Info Pembelian");
//            System.out.println("5. Pembayaran");
//            System.out.println("6. Keluar");
//            System.out.println("======================================");
//            System.out.print("Masukkan Pilihan : ");
//
//            int pilihan = scanner.nextInt();
//
//            switch (pilihan) {
//                case 1:
//                    System.out.println("Daftar Motor:");
//                    for (int i = 0; i < data.length; i++) {
//                        System.out.println((i + 1) + ". " + data[i].merek + " " + data[i].model + " - Tahun " + data[i].tahun + " - Rp " + data[i].harga);
//                    }
//                    break;
//                case 2:
//                    System.out.print("Masukkan merek motor yang ingin dicari: ");
//                    String merekCari = scanner.next();
//                    boolean ditemukan = false;
//                    for (Motor motor : data) {
//                        if (motor.merek.equalsIgnoreCase(merekCari)) {
//                            System.out.println("Motor ditemukan:");
//                            System.out.println("Merek: " + motor.merek);
//                            System.out.println("Model: " + motor.model);
//                            System.out.println("Tahun: " + motor.tahun);
//                            System.out.println("Harga: Rp " + motor.harga);
//                            ditemukan = true;
//                            break;
//                        }
//                    }
//                    if (!ditemukan) {
//                        System.out.println("Motor dengan merek " + merekCari + " tidak ditemukan.");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Masukkan nomor motor yang ingin dibeli: ");
//                    int nomorMotor = scanner.nextInt() - 1;
//                    while (nomorMotor < 0 || nomorMotor >= data.length) {
//                        System.out.print("Nomor motor tidak valid, silakan masukkan nomor yang valid: ");
//                        nomorMotor = scanner.nextInt() - 1;
//                    }
//
//                    System.out.println("Masukkan data diri:");
//                    System.out.print("Nama: ");
//                    String nama = scanner.next();
//                    System.out.print("Alamat: ");
//                    String alamat = scanner.next();
//                    System.out.print("Nomor Telepon: ");
//                    String nomorTelepon = scanner.next();
//
//                    System.out.println("-------------------");
//                    System.out.println("Nama: " + nama);
//                    System.out.println("Alamat: " + alamat);
//                    System.out.println("Nomor Telepon: " + nomorTelepon);
//                    System.out.println("Merk: " + data[nomorMotor].merek);
//                    System.out.println("Model: " + data[nomorMotor].model);
//                    System.out.println("Tahun: " + data[nomorMotor].tahun);
//                    System.out.println("Harga: Rp " + data[nomorMotor].harga);
//                    System.out.println("-------------------");
//                    BeliMotor Beli = new BeliMotor(nama, alamat, nomorTelepon, data[nomorMotor], 1);
//                    break;
//                case 4:
//                    System.out.print("Masukkan nomor motor yang ingin dibeli: ");
//                    int nomorMotorDiskon = scanner.nextInt() - 1;
//                    while (nomorMotorDiskon < 0 || nomorMotorDiskon >= data.length) {
//                        System.out.print("Nomor motor tidak valid, silakan masukkan nomor yang valid: ");
//                        nomorMotorDiskon = scanner.nextInt() - 1;
//                    }
//
//                    System.out.print("Masukkan jumlah motor yang ingin dibeli: ");
//                    int jumlahDiskon = scanner.nextInt();
//
//                    hargaDiskon = data[nomorMotorDiskon].harga * jumlahDiskon;
//
//                    if (hargaDiskon >= 5000000) {
//                        diskon = hargaDiskon / 10;
//                        hargaDiskon = diskon;
//                        System.out.println("Anda mendapatkan diskon 10%");
//                        System.out.println("Diskon: Rp " + diskon);
//                    }
//
//                    System.out.println("\nDetail Pembelian:");
//                    System.out.println("-------------------");
//                    System.out.println("Merk: " + data[nomorMotorDiskon].merek);
//                    System.out.println("Model: " + data[nomorMotorDiskon].model);
//                    System.out.println("Tahun: " + data[nomorMotorDiskon].tahun);
//                    System.out.println("Harga: Rp " + data[nomorMotorDiskon].harga);
//                    System.out.println("Jumlah: " + jumlahDiskon);
//                    System.out.println("Total: Rp " + hargaDiskon);
//                    System.out.println("Diskon: Rp " + diskon);
//                    System.out.println("-------------------");
//                    break;
//                case 5:
//                    System.out.println("\nMetode Pembayaran:");
//                    System.out.println("1. Pembayaran Tunai");
//                    System.out.println("2. Pembayaran Non Tunai");
//                    System.out.print("Masukkan pilihan: ");
//                    int metodePembayaran = scanner.nextInt();
//
//                    //proses pembayaran
//                    if (metodePembayaran == 1) {
//                        System.out.println("Total Pembelian: Rp " + hargaDiskon);
//                        System.out.println("Diskon: Rp " + diskon);
//                        System.out.println("\nTerima kasih telah berbelanja di TOKO MOTOR JAYA.");
//                        System.out.println("===============================================");
//                    } else if (metodePembayaran == 2) {
//                        System.out.print("\nMasukkan nomor rekening Anda: ");
//                        String rekening = scanner.next();
//                        System.out.println("Total Pembelian: Rp " + hargaDiskon);
//                        System.out.println("Diskon: Rp " + diskon);
//                        System.out.println("\nTerima kasih telah berbelanja di TOKO MOTOR JAYA.");
//                        System.out.println("===============================================");
//                    } else {
//                        System.out.println("\nPilihan tidak valid, silakan pilih kembali.");
//                    }
//                    break;
//                case 6:
//                    selesai = true;
//                    System.out.println("Terima kasih!");
//                    break;
//                default:
//                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-6.");
//            }
//        }
//    }
//}
