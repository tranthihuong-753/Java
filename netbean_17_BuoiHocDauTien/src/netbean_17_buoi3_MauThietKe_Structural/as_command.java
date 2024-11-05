/*
cho phép đóng gói một yêu cầu dưới dạng một đối tượng, 
cho phép truyền yêu cầu như một tham số, lưu trữ nó và thực thi sau này.
*/

package netbean_17_buoi3_MauThietKe_Structural;

import java.util.ArrayList;
import java.util.List;


// Giao diện Command định nghĩa phương thức thực thi
interface Lenh {
    void thucHien(); // Phương thức thực thi lệnh
}
// Lớp lệnh cụ thể để bật đèn
class LenhBatDen implements Lenh {
    private Den den; // Tham chiếu đến đối tượng đèn

    public LenhBatDen(Den den) {
        this.den = den; // Khởi tạo đèn
    }

    @Override
    public void thucHien() {
        den.bat(); // Gọi phương thức bật đèn
    }
}
// Lớp lệnh cụ thể để tắt đèn
class LenhTatDen implements Lenh {
    private Den den; // Tham chiếu đến đối tượng đèn

    public LenhTatDen(Den den) {
        this.den = den; // Khởi tạo đèn
    }

    @Override
    public void thucHien() {
        den.tat(); // Gọi phương thức tắt đèn
    }
}
// Lớp đèn sẽ nhận và thực hiện lệnh
class Den {
    public void bat() {
        System.out.println("Đèn đã được bật."); // Thông báo bật đèn
    }

    public void tat() {
        System.out.println("Đèn đã được tắt."); // Thông báo tắt đèn
    }
}

// Lớp Bộ điều khiển lưu trữ và thực thi các lệnh
class BoDieuKhien {
    private List<Lenh> danhSachLenh; // Danh sách các lệnh

    public BoDieuKhien() {
        this.danhSachLenh = new ArrayList<>(); // Khởi tạo danh sách lệnh
    }

    public void themLenh(Lenh lenh) {
        danhSachLenh.add(lenh); // Thêm lệnh vào danh sách
    }

    public void thucHienLenh() {
        for (Lenh lenh : danhSachLenh) {
            lenh.thucHien(); // Thực hiện từng lệnh trong danh sách
        }
        danhSachLenh.clear(); // Xóa danh sách lệnh sau khi thực hiện
    }
}
public class as_command {
    public static void main(String[] args) {
        Den den = new Den(); // Khởi tạo đối tượng đèn
        Lenh lenhBatDen = new LenhBatDen(den); // Tạo lệnh bật đèn
        Lenh lenhTatDen = new LenhTatDen(den); // Tạo lệnh tắt đèn

        BoDieuKhien boDieuKhien = new BoDieuKhien(); // Khởi tạo bộ điều khiển
        boDieuKhien.themLenh(lenhBatDen); // Thêm lệnh bật đèn
        boDieuKhien.themLenh(lenhTatDen); // Thêm lệnh tắt đèn

        // Thực hiện các lệnh
        boDieuKhien.thucHienLenh();
    }
}