import java.text.SimpleDateFormat;
import java.util.Date;

public class Pesanan {
    Pelanggan pelanggan;
    Layanan layanan;
    double berat;
    String status;

    public Pesanan(Pelanggan pelanggan, Layanan layanan, double berat) {
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.berat = berat;
        this.status = "Proses";
    }

    public double getTotalBiaya() {
        return layanan.hitungBiaya(berat);
    }

    public void updateStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public void cetakStruk() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String waktu = sdf.format(new Date());

        System.out.println("\n===== STRUK LAUNDRY =====");
        System.out.println("Tanggal: " + waktu);
        System.out.println("Nama Pelanggan: " + pelanggan.getNama().toUpperCase());
        System.out.println("Layanan: " + layanan.namaLayanan);
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Total Biaya: Rp" + getTotalBiaya());
        System.out.println("Status: " + status);
    }
}