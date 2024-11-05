//Định nghĩa một đối tượng để bao bọc việc giao tiếp giữa một số đối tượng với nhau.
package netbean_17_buoi3_MauThietKe_Structural;

import java.util.HashMap;
import java.util.Map;

/*
Điều khiển hệ thống chiếu sáng trong một tòa nhà. 
Trong ví dụ này, chúng ta sẽ sử dụng Mediator để quản lý việc bật tắt đèn trong các phòng khác nhau
*/

// Giao diện Mediator để điều khiển việc bật tắt đèn
interface GiaoDienDieuKhienDen {
    void batDen(String phong); // Phương thức để bật đèn trong phòng
    void tatDen(String phong); // Phương thức để tắt đèn trong phòng
}
// Lớp Mediator cụ thể, quản lý các phòng trong tòa nhà
class ToaNhaDieuKhien implements GiaoDienDieuKhienDen {
    private Map<String, Phong> cacPhong; // Danh sách các phòng

    public ToaNhaDieuKhien() {
        this.cacPhong = new HashMap<>(); // Khởi tạo danh sách phòng
    }

    // Thêm phòng vào danh sách
    public void themPhong(Phong phong) {
        cacPhong.put(phong.layTen(), phong);
    }

    // Bật đèn trong phòng
    @Override
    public void batDen(String phong) {
        if (cacPhong.containsKey(phong)) {
            cacPhong.get(phong).batDen();
        }
    }

    // Tắt đèn trong phòng
    @Override
    public void tatDen(String phong) {
        if (cacPhong.containsKey(phong)) {
            cacPhong.get(phong).tatDen();
        }
    }
}
// Lớp trừu tượng đại diện cho một phòng
abstract class Phong {
    protected GiaoDienDieuKhienDen dieuKhien; // Mediator để giao tiếp
    protected String ten; // Tên phòng

    public Phong(GiaoDienDieuKhienDen dieuKhien, String ten) {
        this.dieuKhien = dieuKhien; // Khởi tạo Mediator
        this.ten = ten; // Khởi tạo tên phòng
    }

    public String layTen() {
        return ten; // Lấy tên phòng
    }

    public abstract void batDen(); // Phương thức trừu tượng để bật đèn
    public abstract void tatDen(); // Phương thức trừu tượng để tắt đèn
}
// Lớp cụ thể đại diện cho phòng khách
class PhongKhach extends Phong {
    public PhongKhach(GiaoDienDieuKhienDen dieuKhien) {
        super(dieuKhien, "Phòng Khách"); // Khởi tạo Mediator và tên phòng
    }

    @Override
    public void batDen() {
        System.out.println("Đèn phòng khách đã được bật."); // Thông báo bật đèn
    }

    @Override
    public void tatDen() {
        System.out.println("Đèn phòng khách đã được tắt."); // Thông báo tắt đèn
    }
}
// Lớp cụ thể đại diện cho phòng ngủ
class PhongNgu extends Phong {
    public PhongNgu(GiaoDienDieuKhienDen dieuKhien) {
        super(dieuKhien, "Phòng Ngủ"); // Khởi tạo Mediator và tên phòng
    }

    @Override
    public void batDen() {
        System.out.println("Đèn phòng ngủ đã được bật."); // Thông báo bật đèn
    }

    @Override
    public void tatDen() {
        System.out.println("Đèn phòng ngủ đã được tắt."); // Thông báo tắt đèn
    }
}
public class as_mediator {
    public static void main(String[] args) {
        // Khởi tạo Mediator cho tòa nhà
        ToaNhaDieuKhien toaNhaDieuKhien = new ToaNhaDieuKhien();

        // Tạo các phòng và thêm vào Mediator
        Phong phongKhach = new PhongKhach(toaNhaDieuKhien);
        Phong phongNgu = new PhongNgu(toaNhaDieuKhien);

        toaNhaDieuKhien.themPhong(phongKhach);
        toaNhaDieuKhien.themPhong(phongNgu);

        // Bật và tắt đèn trong các phòng
        toaNhaDieuKhien.batDen("Phòng Khách");
        toaNhaDieuKhien.tatDen("Phòng Khách");
        toaNhaDieuKhien.batDen("Phòng Ngủ");
        toaNhaDieuKhien.tatDen("Phòng Ngủ");
    }
}


