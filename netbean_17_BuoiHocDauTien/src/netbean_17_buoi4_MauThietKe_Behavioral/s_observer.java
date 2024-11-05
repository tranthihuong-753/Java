//Như kiểu mqh 1-n giữa server-client 
//Khi 1 clients thay đổi thì server thông báo tới tất cả clients có liên quan . 
package netbean_17_buoi4_MauThietKe_Behavioral;

import java.util.ArrayList;
import java.util.List;

interface thoitietHN{
    void update(float nhietdo);
}
class noi1 implements thoitietHN{
    public void update(float nhietdo){
        System.out.println("Nhiet do hien tai la " + nhietdo);
    }
}
class noi2 implements thoitietHN{
    public void update(float nhietdo){
        System.out.println("Nhiet do hien tai la " + nhietdo);
    }
}
class datathoitiet{
    // Đưa hết các đối tượng liên quan vào 1 list
    public List<thoitietHN> obsv = new ArrayList<>(); // đẻ prive thì phải tạo hàm add, delete :((( 
    private float nhietdo;
    // Thay đổi ở đây -> Thay đổi full đối tượng
    public void thaydoi(float t){
        this.nhietdo = t;
        for(thoitietHN e : obsv){
            e.update(nhietdo);
        }
    }
}
public class s_observer{
    public static void main(String[] args) {
        datathoitiet thoitiet = new datathoitiet();
        
        thoitietHN n1 = new noi1();
        thoitietHN n2 = new noi2();
        
        thoitiet.obsv.add(n1);
        thoitiet.obsv.add(n2);
        
        thoitiet.thaydoi(23); 
        // Nhiet do hien tai la 23.0
        // Nhiet do hien tai la 23.0
        thoitiet.thaydoi(24); 
        // Nhiet do hien tai la 24.0
        // Nhiet do hien tai la 24.0
    }
}

