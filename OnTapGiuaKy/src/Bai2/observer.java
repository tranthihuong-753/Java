/*
4. Observer Pattern:
    Khi điểm số của một học sinh thay đổi, các đối tượng khác (ví dụ: giáo viên, phụ huynh) sẽ được thông báo.
    Tạo một lớp Observer để lắng nghe và cập nhật thông tin khi có thay đổi trong điểm số.
 */
package Bai2;

import java.util.ArrayList;
import java.util.List;

interface doituong{
    void thongbao(String txt);
}
class giaovien implements doituong{
    @Override
    public void thongbao(String txt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}
class phuhuynh implements doituong{
    @Override
    public void thongbao(String txt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}
class observer extends student{
    List<doituong> list = new ArrayList<>();
    public observer(String ten, int tuoi, List<Double> diem) {
        super(ten, tuoi, diem);
    }
    @Override
    public void setDiem(List<Double> diem) {
        this.setDiem(diem);
    }
}

