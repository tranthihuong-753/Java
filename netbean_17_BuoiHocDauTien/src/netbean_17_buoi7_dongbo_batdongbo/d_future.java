package netbean_17_buoi7_dongbo_batdongbo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ticketbookingg{
    private int sovecon = 100;
    // PT đặt vé 
    public synchronized String book(String name, int numberticket){
        if(numberticket <= sovecon){
            // Giả lập thời gian cho mấy hành đọng tỏng thực tế 
            sovecon -= numberticket;
            return (Thread.currentThread().getName() +" người đặt là " + name + " Đặt thành công " + numberticket + " vé" + " Số vé còn lại " + sovecon);
        }else{
            return (Thread.currentThread().getName()+" người đặt là " + name  + " Xin lỗi. Vì một số lý do mà viẹc đặt vé chưa thành công."+ " Số vé còn lại " + sovecon);
        }
    }
}
class customerr implements Callable<String> {
    private ticketbookingg tb;
    private String name;
    private int numberticket;

    public customerr(ticketbookingg tb, String name, int numberticket) {
        this.tb = tb;
        this.name = name;
        this.numberticket = numberticket;
    }
    @Override
    public String call() throws Exception {
        return tb.book(name, numberticket); // Gọi phương thức đặt vé
    }
}

public class d_future {
    public static void main(String[] args) {
        ticketbookingg tb = new ticketbookingg();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // Executor để quản lý các tác vụ bất đồng bộ
        Future<String> kh1 = executor.submit(new customerr(tb, "kh1", 30));
        Future<String> kh2 = executor.submit(new customerr(tb, "kh2", 50));
        Future<String> kh3 = executor.submit(new customerr(tb, "kh3", 40));
        // Các khách hàng đặt vé
        try {
            // Lấy kết quả đặt vé sau khi tác vụ hoàn thành
            System.out.println(kh1.get());
            System.out.println(kh2.get());
            System.out.println(kh3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown Executor
        executor.shutdown();
    }
}
