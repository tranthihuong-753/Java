package ptkl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NV {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public double getLuongKhoiDiem() {
        return luongKhoiDiem;
    }

    public void setLuongKhoiDiem(double luongKhoiDiem) {
        this.luongKhoiDiem = luongKhoiDiem;
    }

    public String getCachTra() {
        return cachTra;
    }

    public void setCachTra(String cachTra) {
        if (cachTra.equals("duan") || cachTra.equals("ngay")) {
            this.cachTra = cachTra;
        } else {
            throw new IllegalArgumentException("Giá trị của cachTra phải là 'duan' hoặc 'ngay'.");
        }
    }

    // Phương thức toString để hiển thị thông tin nhân viên
    @Override
    public String toString() {
        return "NV{" +
                "maNV='" + maNV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", luongKhoiDiem=" + luongKhoiDiem +
                ", cachTra='" + cachTra + '\'' +
                '}';
    }

    // Constructor và các phương thức khác
    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;
    }

}
