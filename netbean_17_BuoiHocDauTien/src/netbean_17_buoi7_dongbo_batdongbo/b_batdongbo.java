package netbean_17_buoi7_dongbo_batdongbo;

import java.util.concurrent.CompletableFuture;

class ticketbooking{
    private int sovecon = 100;
    // PT đặt vé 
    public void book(String name, int numberticket){
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
    public CompletableFuture<Void> datve(){
        return CompletableFuture.runAsync(()->{
            tb.book(name, numberticket);
        });
    }
}
public class b_batdongbo {
    public static void main(String[] args) {
        ticketbooking tb = new ticketbooking();
        
        customer kh1 = new customer(tb, "kh1", 30);
        customer kh2 = new customer(tb, "kh2", 3);
        customer kh3 = new customer(tb, "kh3", 40);
        customer kh4 = new customer(tb, "kh4", 36);
        customer kh5 = new customer(tb, "kh5", 3);
        
        CompletableFuture<Void> b1 = kh1.datve();
        CompletableFuture<Void> b2 = kh2.datve();
        CompletableFuture<Void> b3 = kh3.datve();
        CompletableFuture<Void> b4 = kh4.datve();
        CompletableFuture<Void> b5 = kh5.datve();
        // Không có 2 dòng này thì còn chả chạy được 
        CompletableFuture<Void> all_datve = CompletableFuture.allOf(b1, b2, b3, b4, b5);
        all_datve.join();
/*
ForkJoinPool.commonPool-worker-1 người đặt là kh1 Đặt thành công 30 vé Số vé còn lại 70
ForkJoinPool.commonPool-worker-5 người đặt là kh5 Đặt thành công 30 vé Số vé còn lại 40
ForkJoinPool.commonPool-worker-4 người đặt là kh4 Đặt thành công 30 vé Số vé còn lại 10
ForkJoinPool.commonPool-worker-3 người đặt là kh3 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10
ForkJoinPool.commonPool-worker-2 người đặt là kh2 Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công. Số vé còn lại 10        
*/        
    }
}
