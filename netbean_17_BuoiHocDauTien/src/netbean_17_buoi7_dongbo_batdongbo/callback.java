package netbean_17_buoi7_dongbo_batdongbo;

interface datacallback{
    void uploaddatasuccess(String data);
    void uploaddatafail(Exception ex);
}
// Khởi rạo callback trong uploaddataasync() 
class uploaddata{
    // phuong thuc taiuploaddataasync du lieu bat dong bo va goi callback khi hoan than 
    public void uploaddataasync(datacallback cb){
        new Thread(()->{
            try{
                System.out.println("dang tai du lieu");
                Thread.sleep(2000);
                String data = "DL tai thanh cong";
                cb.uploaddatasuccess(data);
            }catch(Exception ex){
                cb.uploaddatafail(ex);
            }
        }).start();
    }
}
// Thực thi callback 
public class callback {
    public static void main(String[] args) {
        uploaddata obj = new uploaddata();
        
        System.out.println("bat dau tai du lieu");
        
        // goi phuong thuc bat dong bo 
        obj.uploaddataasync(new datacallback(){
            public void uploaddatasuccess(String data){
                System.out.println("tai du lieu thanh cong " + data);
            }
            public void uploaddatafail(Exception ex){
                System.out.println("tai du lieu khong thanh cong " + ex.toString());
            }
        });
        
        System.out.println("luong chinh tiep tuc chay");
    }
}
