package netbean_17_buoi3_MauThietKe_Structural;

interface quanlydonhang{
    String chiphi();
}

class giaohangnhanh implements quanlydonhang{
    public String chiphi(){
        return  "phi giao hang nhanh";
    }
}
class giaohangtieuchuan implements quanlydonhang{
    public String chiphi(){
        return "phi gia0 hang tieu chuan";
    }
}
class giaohangquocte implements quanlydonhang{
    public String chiphi(){
        return "phi giao hang quoc te";
    }
}

class donhang{
    private quanlydonhang phuongthuc;
    public donhang(quanlydonhang x){
        this.phuongthuc = x;
    }
    public String get_chiphi(){
        return phuongthuc.chiphi();
    }
}

public class strategy_bai1 {
    public static void main(String[] args) {
        donhang don = new donhang(new giaohangnhanh());
        System.out.println("chi phi : " + don.get_chiphi());
    }
}
