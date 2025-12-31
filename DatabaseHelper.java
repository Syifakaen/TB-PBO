import java.sql.*;

public class DatabaseHelper {
    private Connection conn;

    // Constructor untuk koneksi database
    public DatabaseHelper() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laundry"; // sesuai nama DB
        String user = "root"; // username MySQL
        String pass = "";     // password MySQL
        conn = DriverManager.getConnection(url, user, pass);
    }

    // CREATE: tambah pesanan
    public void createPesanan(Pesanan pesanan) throws SQLException {
        String sql = "INSERT INTO pesanan (nama, layanan, berat, total, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, pesanan.pelanggan.getNama());
        stmt.setString(2, pesanan.layanan.namaLayanan);
        stmt.setDouble(3, pesanan.berat);
        stmt.setDouble(4, pesanan.getTotalBiaya());
        stmt.setString(5, pesanan.status);
        stmt.executeUpdate();
        System.out.println("Pesanan berhasil ditambahkan ke database.");
    }

    // READ: tampilkan semua pesanan
    public void readPesanan() throws SQLException {
        String sql = "SELECT * FROM pesanan";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n=== DAFTAR PESANAN ===");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                               ", Nama: " + rs.getString("nama") +
                               ", Layanan: " + rs.getString("layanan") +
                               ", Berat: " + rs.getDouble("berat") +
                               ", Total: " + rs.getDouble("total") +
                               ", Status: " + rs.getString("status"));
        }
    }

    // UPDATE: ubah status pesanan
    public void updatePesanan(int id, String statusBaru) throws SQLException {
        String sql = "UPDATE pesanan SET status=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, statusBaru);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        System.out.println("Pesanan dengan ID " + id + " berhasil diupdate.");
    }

    // DELETE: hapus pesanan
    public void deletePesanan(int id) throws SQLException {
        String sql = "DELETE FROM pesanan WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Pesanan dengan ID " + id + " berhasil dihapus.");
    }
}