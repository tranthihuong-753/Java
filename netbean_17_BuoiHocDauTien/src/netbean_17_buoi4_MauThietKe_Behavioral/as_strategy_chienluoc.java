package netbean_17_buoi4_MauThietKe_Behavioral;

interface strategy{
    void tratien(int sotienphaitra);
}
class tratienmat implements strategy{
    public void tratien(int sotienphaitra) {
        System.out.println("Tra het " + sotienphaitra);
    }
}
class trataikhoan implements strategy{
    public void tratien(int sotienphaitra) {
        System.out.println("Tra het " + sotienphaitra);
    }    
}
class ungdung{
    private strategy st;
    public void setstrategy (strategy s){
        this.st = s;
    }
    public void tratien(int sotienphaitra){
        st.tratien(sotienphaitra);
    }
}
public class as_strategy_chienluoc {
    public static void main(String[] args) {
        ungdung a = new ungdung();
        a.setstrategy(new tratienmat());
        a.tratien(200);
        a.setstrategy(new trataikhoan());
        a.tratien(300);
    }
}
