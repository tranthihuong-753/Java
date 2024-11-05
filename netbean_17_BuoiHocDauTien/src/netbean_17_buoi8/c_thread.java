package netbean_17_buoi8;

class countnumbers extends Thread{
    @Override
    public void run(){
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(Thread.currentThread().getName() + " - Dem " + i);
            try{
                Thread.sleep(1000);
            }catch(Exception exx){
                System.out.println(exx.toString());
            }
        }
    } 
}
public class c_thread {
    public static void main(String[] args) {
        countnumbers th1 = new countnumbers();
        countnumbers th2 = new countnumbers();
        
        th1.setName("l 1");
        th2.setName("l 2");
        
        th1.start();
        th2.start();
    }
}
