import java.util.*;

public class LaundryAlif {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {  // otomatis close

            // Input data pelanggan
            System.out.print("Masukkan nama pelanggan: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan no. telepon: ");
            String noTelp = sc.nextLine();

            Pelanggan p1 = new Pelanggan(nama, noTelp);

            // Pilih layanan
            System.out.println("Pilih layanan:");
            System.out.println("1. Setrika");
            System.out.println("2. Cuci + Setrika");
            System.out.println("3. Cuci Kering");
            int pilihan = sc.nextInt();

            Layanan layananDipilih;
            if (pilihan == 1) {
                layananDipilih = new LayananSetrika();
            } else if (pilihan == 2) {
                layananDipilih = new LayananCuciSetrika();
            } else {
                layananDipilih = new LayananCuciKering();
            }

            // Input berat cucian
            System.out.print("Masukkan berat cucian (kg): ");
            double berat = sc.nextDouble();

            // Percabangan: diskon jika > 10 kg
            if (berat > 10) {
                System.out.println("Diskon 10% diberikan!");
            }

            // Buat pesanan
            Pesanan pesanan1 = new Pesanan(p1, layananDipilih, berat);

            // Cetak struk
            pesanan1.cetakStruk();

            // Proses pembayaran
            Pembayaran bayar = new BayarTunai();
            bayar.prosesBayar(pesanan1.getTotalBiaya());

            // Update status cucian
            pesanan1.updateStatus("Selesai");

            // Integrasi DatabaseHelper (CRUD)
            DatabaseHelper db = new DatabaseHelper();
            db.createPesanan(pesanan1);   // CREATE
            db.readPesanan();             // READ
            db.updatePesanan(1, "Selesai"); // UPDATE
            db.deletePesanan(2);          // DELETE

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harus berupa angka.");
        } catch (Exception e) {
            System.out.println("Terjadi error database: " + e.getMessage());
        }
    }
}
