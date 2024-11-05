package ptkl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        QLNV qlnv = QLNV.getInstance();

        // Thêm observer
        qlnv.themObserver(new ThongBaoHR());
        qlnv.themObserver(new ThongBaoPM());

        // Tạo và thêm nhân viên
        NV nv1 = new NV("NV01", "Nguyen Van A", LocalDate.of(2023, 1, 1), 5000.0, "duan");
        NV nv2 = new NV("NV02", "Tran Thi B", LocalDate.of(2023, 2, 1), 6000.0, "ngay");

        // Gọi phương thức thêm nhân viên
        qlnv.themNhanVien(nv1); // Thông báo cho ThongBaoPM
        qlnv.themNhanVien(nv2); // Thông báo cho ThongBaoHR

        // In danh sách nhân viên
        System.out.println("Danh sách nhân viên:");
        qlnv.inDanhSachNV();
    }
}

