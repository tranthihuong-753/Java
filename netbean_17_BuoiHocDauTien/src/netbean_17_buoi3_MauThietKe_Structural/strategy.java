
package netbean_17_buoi3_MauThietKe_Structural;

interface paymentstrategy{
    void pay(int amount);
}

class creditcardpayment implements paymentstrategy{
    private String name;
    private String cardnumber;
    private String cvv;
    private String expirydate;
    public creditcardpayment(String name, String cardnumber, String cvv, String expirydate){
        this.name = name;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.expirydate = expirydate;
    }
    public void pay(int amount){
        System.out.println("payyyy");
    }
}

class paypalpayment implements paymentstrategy{
    private String email;
    private String password;
    public paypalpayment(String a, String b){
        this.email = a;
        this.password = b;
    }
    public void pay(int amount){
        System.out.println("paypalllllllll");
    }
}

public class strategy {
    private paymentstrategy pmobj;

    public void setPmobj(paymentstrategy pmobj) {
        this.pmobj = pmobj;
    }
    public void checkout(int i){
        if(pmobj == null){
            System.out.println("please select 1 payment method");
        }else{
            pmobj.pay(i);
        }
    }
    public static void main(String[] args) {
        
    }
}
