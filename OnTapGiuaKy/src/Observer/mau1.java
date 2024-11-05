// Cô giáo phải thông báo tới 3 lớp 
// Vào ngày quóc khánh, cô thông báo tới các lớp lịch nghỉ 
// Nhưng gửi tin tới từng lớp thì mệt ẻ 

/*
Sử dụng List<>
.remove(giá trị / index)
.get(index)
*/
package Observer;

import java.util.ArrayList;
import java.util.List;

interface cogiao{
    void thongbao(String txtthongtin);
}
class lop1 implements cogiao{
    public void thongbao(String txtthongtin) {
        System.out.println("Thông báo : " + txtthongtin);
    }
}
class lop2 implements cogiao{
    public void thongbao(String txtthongtin) {
        System.out.println("Thông báo : " + txtthongtin);
    }
}
class observer_thongtin{
    // Đưa hết các đối tượng liên quan vào 1 list 
    List<cogiao> list = new ArrayList<>();
    public String txtthongtin;
    // Thay đổi ở đây -> Thay đổi full đối tượng 
    public void toAll(String txt){
        this.txtthongtin = txt;
        for(cogiao x : list){
            x.thongbao(txtthongtin);
        }
    }
}

public class mau1 {
    public static void main(String[] args) {
        //send_no_observer();
        send_observer();
    }
    // Hàm gửi thông tin khi không sử dụng Observer
    static void send_no_observer(){
        lop1 lop23it1 = new lop1();
        lop2 lop23it2 = new lop2();
        // Nhà trường thông báo txtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 24/2/2020. 25/2/2020 đi học bình thường. "
        String txtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 24/2/2020. 25/2/2020 đi học bình thường. ";
        lop23it1.thongbao(txtthongtin);
        lop23it2.thongbao(txtthongtin);
        // Nhà trường có thông báo khác   
        txtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 25/2/2020. 26/2/2020 đi học bình thường.";
        lop23it1.thongbao(txtthongtin);
        //lop23it1.thongbao(txtthongtin); // Gọi thông báo lớp 2 
        // Không chỉnh sửa thông tin thì lớp 23it2 sẽ không nhạn được tin mới nhất 
    }
    // Hàm gửi thông tin khi sử dụng Observer
    static void send_observer(){
        observer_thongtin ob = new observer_thongtin();
        
        lop1 lop23it1 = new lop1();
        lop2 lop23it2 = new lop2();
        
        ob.list.add(lop23it1);
        ob.list.add(lop23it2);
        
        // Nhà trường thông báo txtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 24/2/2020. 25/2/2020 đi học bình thường. "
        String txtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 24/2/2020. 25/2/2020 đi học bình thường. "; 
        ob.toAll(txtthongtin);
        // Nhà trường có thông báo khác   
        String newtxtthongtin = "Sinh viên được nghỉ từ ngày 22/2/2020 - 25/2/2020. 26/2/2020 đi học bình thường.";
        ob.toAll(newtxtthongtin);     
    }
}
