package ptkl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class QLNV {
    private static QLNV instance; // Biến lưu trữ instance duy nhất
    private HashMap<String, NV> dsNV; // Danh sách nhân viên

    // Constructor riêng để không thể khởi tạo lớp từ bên ngoài
    private QLNV() {
        dsNV = new HashMap<>();
        dsNV = new HashMap<>();
        dsQS = new ArrayList<>();
    }

    // Phương thức để lấy instance của lớp QLNV
    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }

    // Phương thức để thêm nhân viên vào danh sách
    public void themNV(NV nhanVien) {
        dsNV.put(nhanVien.getMaNV(), nhanVien);
    }

    // Phương thức để lấy danh sách nhân viên
    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }

    // Phương thức để in danh sách nhân viên
    public void inDanhSachNV() {
        for (NV nv : dsNV.values()) {
            System.out.println(nv);
        }
    }
    private List<QuanSat> dsQS; // Danh sách observer


    // Phương thức để cập nhật observer tương ứng
    private void capNhatObservers(String thongTin, NV nhanVien, Class<?> observerClass) {
        for (QuanSat observer : dsQS) {
            if (observer.getClass().equals(observerClass)) {
                observer.capNhat(thongTin, nhanVien);
            }
        }
    }

    public void themObserver(QuanSat observer) {
        dsQS.add(observer);
    }

    // Phương thức thêm nhân viên mới
    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);

        // Thông báo cho các observer tương ứng
        if ("duan".equals(nv.getCachTra())) {
            for (QuanSat observer : dsQS) {
                if (observer instanceof ThongBaoPM) {
                    observer.capNhat("Có nhân viên mới theo dự án: " + nv.getHoTen(), nv);
                }
            }
        } else if ("ngay".equals(nv.getCachTra())) {
            for (QuanSat observer : dsQS) {
                if (observer instanceof ThongBaoHR) {
                    observer.capNhat("Có nhân viên mới theo ngày công: " + nv.getHoTen(), nv);
                }
            }
        }
    }
}


