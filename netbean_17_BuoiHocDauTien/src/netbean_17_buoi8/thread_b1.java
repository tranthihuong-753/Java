package netbean_17_buoi8;

class songuyento extends Thread{
    private int head;
    private int tail;

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
    
    boolean checksonguyento(int n){
        if(n == 1 || n == 2){
            return true;
        }
        for(int i = 2; i <= n/2 ; i++){
            if(n % i ==0){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void run(){
        for(int i = head; i <= tail ; i++){
            if(checksonguyento(i) == true){ 
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try{
                    Thread.sleep(1500);
                }catch(Exception ex){
                    System.out.println(ex.toString());
                }
            }
        }
    }
}

public class thread_b1 {
    public static void main(String[] args) {
        songuyento hd1 = new songuyento();
        songuyento hd2 = new songuyento();
        
        hd1.setName("Luong 1");
        hd2.setName("Luong 2");
        
        hd1.setHead(1);
        hd1.setTail(50);
        
        hd2.setHead(51);
        hd2.setTail(100);
        
        hd1.start();
        hd2.start();
    } 
}
