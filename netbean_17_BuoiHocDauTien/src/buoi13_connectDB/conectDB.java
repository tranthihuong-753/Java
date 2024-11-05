package buoi13_connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectDB {
    String url = "jdbc:sqlserver://HuongDuong:1433;databaseName=db;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

    public static Connection connectDB(String url) {
        Connection connection = null;

        try {
            // Kết nối tới SQL Server
            connection = DriverManager.getConnection(url);
            System.out.println("Kết nối thành công tới SQL Server");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }
    public static void main(String[] args) throws SQLException {
    String url = "jdbc:sqlserver://HuongDuong:1433;databaseName=db;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        // Gọi hàm connectDB và lấy kết quả kết nối
        Connection conn = connectDB(url);

//        if (conn != null) {
//            try {
//                // Thực hiện các tác vụ cần thiết với kết nối (nếu có)
//                
//                // Đóng kết nối khi không cần thiết
//                conn.close();
//                System.out.println("Đã đóng kết nối.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }        
    }
}
