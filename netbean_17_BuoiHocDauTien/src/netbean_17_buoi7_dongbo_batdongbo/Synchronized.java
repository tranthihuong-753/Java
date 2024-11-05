package netbean_17_buoi7_dongbo_batdongbo;

class bankaccount{
    private double balance;

    public bankaccount (double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
    // PT rút tiền
    // synchronized có nghĩa là phương thức sẽ bị khóa (lock) khi 1 luồng đang thực hiện nó
    public synchronized void withdraw( double amount ){
        if(balance >= amount){
            try{
                Thread.sleep(100);
            }catch(Exception ex){
                System.out.println(ex.toString());
                ex.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " rut tien thanh cong");
        }else{
            System.out.println(Thread.currentThread().getName() + " ngheo rot mong toi");
        }
    }  
}

class withdrawthread extends Thread{
    private bankaccount account;
    private double amount;

    public withdrawthread(bankaccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    // rut tien 
    public void process(){
        account.withdraw(amount);
    }
}

public class Synchronized {
    public static void main(String[] args) {
        // khoi tao tai khoan co 10k 
        bankaccount tth = new bankaccount(10000);
        
        // rut tien 
        tth.withdraw(7500); // main rut tien thanh cong
        System.out.println("-7500 " + tth.getBalance());
        tth.withdraw(5000); // main ngheo rot mong toi
        System.out.println("-5000 " + tth.getBalance());
        
        withdrawthread t1 = new withdrawthread(tth, 500);
        
        withdrawthread t2 = new withdrawthread(tth, 1000);
        
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        
        t1.process();
        System.out.println("-500 " + tth.getBalance());
        t2.process();
        System.out.println("-1000 " + tth.getBalance());        
    }
}
