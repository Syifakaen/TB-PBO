public class Layanan {
    String namaLayanan;
    double hargaPerKg;

    public Layanan(String namaLayanan, double hargaPerKg) {
        this.namaLayanan = namaLayanan;
        this.hargaPerKg = hargaPerKg;
    }

    public double hitungBiaya(double berat) {
        return berat * hargaPerKg;
    }
}

// Subclass Setrika
class LayananSetrika extends Layanan {
    public LayananSetrika() {
        super("Setrika", 5000);
    }
}

// Subclass Cuci + Setrika
class LayananCuciSetrika extends Layanan {
    public LayananCuciSetrika() {
        super("Cuci + Setrika", 7000);
    }
}

// Subclass Cuci Kering
class LayananCuciKering extends Layanan {
    public LayananCuciKering() {
        super("Cuci Kering", 8000);
    }
}