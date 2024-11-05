package ptkl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface QuanSat {
    void capNhat(String thongTin, NV nhanVien);
}

class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String thongTin, NV nhanVien) {
        System.out.println("Thông báo cho phòng nhân sự: " + thongTin + " - Nhân viên: " + nhanVien);
    }
}
class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String thongTin, NV nhanVien) {
        System.out.println("Thông báo cho đội dự án: " + thongTin + " - Nhân viên: " + nhanVien);
    }
}


