// Gom hết các phương thức vào làm 1 , che dấu sự phức tạp 

package netbean_17_buoi3_MauThietKe_Structural;
// class ăn cơm = class nấu + class dọn bàn + class tắm 
class nau {
    public void nauan(String monan) {
        System.out.println("Nau com hoiiii " + monan);
    }
}
class don {
    public void donban() {
        System.out.println("Ngoan xinh iuu oi, don ban an thoi");
    }
}
class tam {
    public void ditam(int time) {
        System.out.println("Tam tam tam " + time + " giờ. ");
    }
}
// Lớp Facade
class an {
    private nau nau;
    private don don;
    private tam tam;
    public an(){
        this.nau = new nau();
        this.don = new don();
        this.tam = new tam();
    }
    public void an(String monan, int time) {
        nau.nauan("cơm vịt");
        don.donban();
        tam.ditam(time);
        System.out.println("Hí hí ngon ngonnn");
    }
}
public class s_facade {
    public static void main(String[] args) {
        an ban1 = new an();
        ban1.an("cơm vịt", 2);
    }
}

