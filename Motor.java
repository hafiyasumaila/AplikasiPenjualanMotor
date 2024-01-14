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
