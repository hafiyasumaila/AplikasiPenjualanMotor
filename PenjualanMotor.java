import java.util.Scanner;

public class PenjualanMotor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        System.out.println("SELAMAT DATANG DI PENJUALAN MOTOR");

        boolean running = true;
        while (running) {
            System.out.println("==========MENU================");
            System.out.println("1. Pilih Motor");
            System.out.println("2. Tampilkan Daftar Motor");
            System.out.println("3. Beli Motor");
            System.out.println("4. Keluar");
            System.out.println("Masukkan Pilihan: ");
            System.out.println("===============================");
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (opsi) {
                case 1:
                    System.out.print("Masukkan merek motor: ");
                    String merek = scanner.nextLine();
                    System.out.print("Masukkan model motor: ");
                    String model = scanner.nextLine();
                    System.out.print("Masukkan harga motor: ");
                    int harga = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    Motor newMotor = new Motor(merek, model, harga);
                    inventory.tambahMotor(newMotor);
                    System.out.println("Motor berhasil ditambahkan!");
                    break;
                case 2:
                    inventory.tampilkanMotor();
                    break;
                case 3:
                    System.out.println("Masukkan nomor motor yang ingin dibeli:");
                    int nomorMotor = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    Motor motorDibeli = inventory.beliMotor(nomorMotor - 1);
                    if (motorDibeli != null) {
                        System.out.println("Anda telah membeli motor:");
                        System.out.println(motorDibeli);
                    } else {
                        System.out.println("Nomor motor tidak valid atau motor tidak tersedia.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("TERIMA KASIH.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang sesuai.");
                    break;
            }
        }
    }
}

