package netbean_17_buoi7_dongbo_batdongbo;

// Giao diện callback
interface BookingCallback {
    void onSuccess(String name, int numberTicket, int remainingTickets);
    void onFailure(String name, int numberTicket, int remainingTickets);
}
// khởi tạo callback trong book()
// Lớp quản lý đặt vé
class TicketBooking {
    private int sovecon = 100;

    // Phương thức đặt vé
    public synchronized void book(String name, int numberTicket, BookingCallback callback) {
        if (numberTicket <= sovecon) {
            sovecon -= numberTicket;
            callback.onSuccess(name, numberTicket, sovecon);
        } else {
            callback.onFailure(name, numberTicket, sovecon);
        }
    }
}
//Sử dụng callback trong run() 
// Lớp khách hàng
class Customer extends Thread {
    private TicketBooking ticketBooking;
    private String name;
    private int numberTicket;

    public Customer(TicketBooking ticketBooking, String name, int numberTicket) {
        this.ticketBooking = ticketBooking;
        this.name = name;
        this.numberTicket = numberTicket;
    }

    public void run() {
        ticketBooking.book(name, numberTicket, new BookingCallback() {
            @Override
            public void onSuccess(String name, int numberTicket, int remainingTickets) {
                System.out.println(Thread.currentThread().getName() + " người đặt là " + name + " Đặt thành công " + numberTicket + " vé. Số vé còn lại: " + remainingTickets);
            }

            @Override
            public void onFailure(String name, int numberTicket, int remainingTickets) {
                System.out.println(Thread.currentThread().getName() + " người đặt là " + name + " Xin lỗi. Việc đặt vé chưa thành công. Số vé còn lại: " + remainingTickets);
            }
        });
    }
}

public class c_callback {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();

        Customer kh1 = new Customer(ticketBooking, "kh1", 30);
        Customer kh2 = new Customer(ticketBooking, "kh2", 30);
        Customer kh3 = new Customer(ticketBooking, "kh3", 30);
        Customer kh4 = new Customer(ticketBooking, "kh4", 30);
        Customer kh5 = new Customer(ticketBooking, "kh5", 30);

        kh1.start();
        kh2.start();
        kh3.start();
        kh4.start();
        kh5.start();
    }    
}
