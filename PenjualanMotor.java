import java.util.Scanner;
import java.util.ArrayList;

public class PenjualanMotor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        ArrayList<Pengguna> daftarPengguna = new ArrayList<>();

        // Menambahkan beberapa motor ke dalam daftar motor
        inventory.tambahMotor(new Motor("Honda", "CBR1000RR", 2022, "Baru", 250000000));
        inventory.tambahMotor(new Motor("Yamaha", "NMAX", 2021, "Baru", 40000000));
        inventory.tambahMotor(new Motor("Suzuki", "GSX-R150", 2020, "Baru", 35000000));

        System.out.println("SELAMAT DATANG DI APLIKASI PENJUALAN MOTOR");

        // Menambahkan pengguna baru

        daftarPengguna.add(new Pengguna("fiyaa", "fiyaa"));

        boolean loggedIn = false;
        Pengguna user = null;

        while (!loggedIn) {
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Password: ");
            String inputPassword = scanner.nextLine();

            for (Pengguna pengguna : daftarPengguna) {
                if (pengguna.cocok(inputUsername, inputPassword)) {
                    loggedIn = true;
                    user = pengguna;
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
        }

        System.out.println("Login berhasil sebagai " + user.username);

        boolean running = true;
        while (running) {
            System.out.println("==========MENU================");
            System.out.println("1. Daftar Motor");
            System.out.println("2. Detail Motor");
            System.out.println("3. Proses Pembelian");
            System.out.println("4. Pembayaran");
            System.out.println("5. Keluar");
            System.out.println("Masukkan Pilihan: ");
            System.out.println("===============================");
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (opsi) {
                case 1:
                    inventory.tampilkanMotor();
                    break;
                case 2:
                    System.out.println("Masukkan nomor motor untuk melihat detail:");
                    int nomorDetailMotor = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    Motor motorDetail = inventory.detailMotor(nomorDetailMotor - 1);
                    if (motorDetail != null) {
                        System.out.println("Detail Motor:");
                        System.out.println(motorDetail);
                    } else {
                        System.out.println("Nomor motor tidak valid atau motor tidak tersedia.");
                    }
                    break;
                case 3:
                    System.out.println("Masukkan nomor motor yang ingin dibeli:");
                    int nomorMotorBeli = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    Motor motorDibeli = inventory.beliMotor(nomorMotorBeli - 1);
                    if (motorDibeli != null) {
                        System.out.println("Anda telah membeli motor:");
                        System.out.println(motorDibeli);
                    } else {
                        System.out.println("Nomor motor tidak valid atau motor tidak tersedia.");
                    }
                    break;
                case 4:
                    System.out.println("-------------------------------");
                    System.out.println("Pilih metode pembayaran:");
                    System.out.println("1. BNI");
                    System.out.println("2. BRI");
                    System.out.println("3. Dana");
                    System.out.println("4. Gopay");
                    System.out.println("-------------------------------");
                    int metodeBayar = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline

                    switch (metodeBayar) {
                        case 1:
                            System.out.println("Anda telah melakukan pembayaran melalui BNI.");
                            break;
                        case 2:
                            System.out.println("Anda telah melakukan pembayaran melalui BRI.");
                            break;
                        case 3:
                            System.out.println("Anda telah melakukan pembayaran melalui Dana.");
                            break;
                        case 4:
                            System.out.println("Amda telah melakukan pembayaran melalaui Gopay");
                            break;
                        default:
                            System.out.println("Metode pembayaran tidak valid.");
                            break;
                    }
                    System.out.println("Proses pembayaran berhasil.");
                    break;
                case 5:
                    running = false;
                    System.out.println("TERIMA KASIH");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang sesuai.");
                    break;
            }
        }
    }
}
