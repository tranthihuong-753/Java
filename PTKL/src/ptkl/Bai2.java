/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptkl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author dhhuo
 */
public class Bai2 {
    public static void main(String[] args) {
        QLNV qlnv = QLNV.getInstance();

        // Thêm nhân viên
        NV nv1 = new NV("NV01", "Nguyen Van A", LocalDate.of(2023, 1, 1), 5000.0, "duan");
        NV nv2 = new NV("NV02", "Tran Thi B", LocalDate.of(2023, 2, 1), 6000.0, "ngay");
        NV nv3 = new NV("NV03", "Le Van C", LocalDate.of(2023, 3, 1), 4000.0, "duan");
        
        qlnv.themNhanVien(nv1);
        qlnv.themNhanVien(nv2);
        qlnv.themNhanVien(nv3);

        // Sắp xếp nhân viên theo lương khởi điểm và hiển thị danh sách
        sapXepTheoLuongKhoiDiem(qlnv.getDsNV()) // Giả sử hàm này trả về List<NV>
            .thenCompose(danhSach -> {
                return hienThiDanhSachNhanVien(danhSach); // Gọi hàm hiển thị danh sách
            }).join(); // Chờ cho tất cả các tác vụ bất đồng bộ hoàn thành
    }

    // Hàm sắp xếp nhân viên theo lương khởi điểm (chưa viết chi tiết)
    public static CompletableFuture<List<NV>> sapXepTheoLuongKhoiDiem(HashMap<String, NV> dsNV) {
        return CompletableFuture.supplyAsync(() -> {
            List<NV> danhSach = new ArrayList<>(dsNV.values());
            danhSach.sort(Comparator.comparingDouble(NV::getLuongKhoiDiem));
            try {
                Thread.sleep(1000); // Delay 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return danhSach; // Trả về danh sách đã sắp xếp
        });
    }

    // Hàm hiển thị danh sách nhân viên
    public static CompletableFuture<Void> hienThiDanhSachNhanVien(List<NV> danhSach) {
        return CompletableFuture.runAsync(() -> {
            for (NV nv : danhSach) {
                System.out.println(nv);
            }
            try {
                Thread.sleep(2000); // Delay 2 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> System.out.println("Hàm hienThiDanhSachNhanVien đã thực hiện xong."));
    }
}
