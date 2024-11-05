// Đặt vé máy bay 
package netbean_17_buoi7_dongbo_batdongbo;

// class A có 1 method chứa key synchronized 
// clas B extends Thread , khai báo A và có 1 method chạy (method chứa key synchronized của class A)

class ticketbooking{
    private int sovecon = 100;
    // PT đặt vé 
    public synchronized void book(String name, int numberticket){
        if(numberticket <= sovecon){
            // Giả lập thời gian cho mấy hành đọng tỏng thực tế 
            sovecon -= numberticket;
            System.out.println(Thread.currentThread().getName() +" người đặt là " + name + " Đặt thành công " + numberticket + " vé" + " Số vé còn lại " + sovecon);
        }else{
            System.out.println(Thread.currentThread().getName()+" người đặt là " + name  + " Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công."+ " Số vé còn lại " + sovecon);
        }
    }
}

class customer extends Thread{
    private ticketbooking tb;
    private String name;
    private int numberticket;

    public customer(ticketbooking tb, String name, int numberticket) {
        this.tb = tb;
        this.name = name;
        this.numberticket = numberticket;
    }
    public void run(){
        tb.book(name, numberticket);
    }
    public void datve(){
        tb.book(name, numberticket);
    }
}

public class a_dongbo {
    public static void main(String[] args) {
        ticketbooking tb = new ticketbooking();
        
        customer kh1 = new customer(tb, "kh1", 30);
        customer kh2 = new customer(tb, "kh2", 30);
        customer kh3 = new customer(tb, "kh3", 30);
        customer kh4 = new customer(tb, "kh4", 30);
        customer kh5 = new customer(tb, "kh5", 30);

        kh1.datve();
        kh2.datve();
        kh3.datve();
        kh4.datve();
        kh5.datve();
/*
        Chạy Thread bởi hàm tự tạo , dù có từ khóa synchronize hay không thì đều 
            + Không lấy được name qua Thread.currentThread.getname()
            + Chạy lần lượt 
main người đặt là kh1 Đặt thành công 30 vé Số vé còn lại 70
main người đặt là kh2 Đặt thành công 30 vé Số vé còn lại 40
main người đặt là kh3 Đặt thành công 30 vé Số vé còn lại 10
main người đặt là kh4 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
main người đặt là kh5 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
        
*/
        
//        kh1.start();
//        kh2.start();
//        kh3.start();
//        kh4.start();
//        kh5.start();
        
/*
    Chạy theo hàm run() kế thừa Thread thì 
        1. Khi không sử dụng từ khóa synchonized 
Thread-2 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
Thread-4 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
Thread-0 Đặt thành công 30 vé Số vé còn lại 40
Thread-3 Đặt thành công 30 vé Số vé còn lại 10
Thread-1 Đặt thành công 30 vé Số vé còn lại 40        

        2. Khi sử dụng từ khóa synchonized 
Thread-0 Đặt thành công 30 vé Số vé còn lại 70
Thread-4 Đặt thành công 30 vé Số vé còn lại 40
Thread-2 Đặt thành công 30 vé Số vé còn lại 10
Thread-3 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
Thread-1 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
*/
    }
}
