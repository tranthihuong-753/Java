/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbean_17_buoi8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author dhhuo
 */
public class bigdata_future {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(1);
        Future<String> f = ex.submit(()->{
            Thread.sleep(3000);
            return "xu ly du lieu thanh cong";
        });
        try{
            System.out.println(f.get());
        }catch(Exception exx){
            System.out.println(exx.toString());
            ex.shutdown();
        }
    }
}
