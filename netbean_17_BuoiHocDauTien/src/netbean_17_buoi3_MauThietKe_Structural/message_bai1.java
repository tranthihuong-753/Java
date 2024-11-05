package netbean_17_buoi3_MauThietKe_Structural;

import java.util.concurrent.CompletableFuture;

interface message{
    void createmessage();
}

class audiomessage implements message{
    public void createmessage(){
        System.out.println("create audio");
    }
}

class txtmessage implements message{
    public void createmessage(){
        System.out.println("create txt");
    }
}

class messagefactory{
    public message get_mess(String m){
        if(m.equals("audiomessage")){
            return new audiomessage();
        }
        else if(m.equals("txtmessage")){
            return new txtmessage();
        }
        return null;
    }
    // Không đồng bộ 
    public CompletableFuture<message> get_mess_thread(String m) {
        return CompletableFuture.supplyAsync(() -> {
            if (m.equals("audiomessage")) {
                return new audiomessage();  // Trả về audiomessage
            } else if (m.equals("txtmessage")) {
                return new txtmessage();  // Trả về txtmessage
            }
            return null;  // Trả về null nếu không khớp
        });
    }
}

public class message_bai1 {
    public static void main(String[] args) {
        messagefactory obj = new messagefactory();
        
        message m1 = obj.get_mess("audiomessage");
        m1.createmessage(); // create audio
        
        obj.get_mess_thread("txtmessage").thenAccept(message -> {
                message.createmessage();
        }); // create txt 
    }
}
