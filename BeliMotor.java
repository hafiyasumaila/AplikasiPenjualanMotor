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
