package netbean_17_buoi7_dongbo_batdongbo;

import java.util.concurrent.CompletableFuture;

public class Unsynchronized {
    public static CompletableFuture<String> attacheddata(){
        return CompletableFuture.supplyAsync(()->{
            return "thanh cong";
        });
    }
    public static void main(String[] args) {
        CompletableFuture<String> future = attacheddata();
        future.thenAccept(result -> {
            System.out.println("ket qua : " + result);
        });
        System.out.println("luong chinh tiep tuc htuc hien cong viec khác");
        
        try{
            Thread.sleep(30000);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    } 
}
