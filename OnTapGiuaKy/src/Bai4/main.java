package Bai4;

import java.util.Iterator;
import java.util.List;

public class main {
    public static void main(String[] args) {  
       run_thread();       
    }
    static void run_nothread(){
        // tao san pham 
        sanpham s1 = new sanpham("But", "NSX A", 5000);
        sanpham s2 = new sanpham("Vo", "NSX B", 10000);
        sanpham s3 = new sanpham("Tap", "NSX C", 15000);
        sanpham s4 = new sanpham("Keo", "NSX D", 3000);
        sanpham s5 = new sanpham("Thước", "NSX A", 7000);
        sanpham s6 = new sanpham("Cặp sách", "NSX E", 20000);
        sanpham s7 = new sanpham("Giấy", "NSX B", 2500);
        sanpham s8 = new sanpham("Bút mực", "NSX C", 6000);
        sanpham s9 = new sanpham("Sách", "NSX D", 12000);
        sanpham s10 = new sanpham("Bảng viết", "NSX E", 25000);
        sanpham s11 = new sanpham("Đèn học", "NSX A", 40000);
        
        
        electronicstore store = new electronicstore();
        store.addsp(s1);
        store.addsp(s2);
        store.addsp(s3);
        store.addsp(s4);
        store.addsp(s5);
        store.addsp(s6);
        store.addsp(s7);
        store.addsp(s8);
        
        System.out.println("Hien thi toan bo san pham");
        create c = new create();
        c.list = store.list;
        Iterator<sanpham> x = c.iterator();
        while(x.hasNext()){
            x.next().printsanpham();
        }
        
        System.out.println("Hien thi toan bo san pham sap xep theo ten");  
        
        strategysort<sanpham> strategy = new strategysort<>();
        strategy.set_sort(new sort_ten<>());
        store.set_strategysort(strategy);
        Iterator<sanpham> x2 = c.iterator();
        while(x2.hasNext()){
            x2.next().printsanpham();
        }   
        
        System.out.println("Hien thi toan bo san pham sap xep theo gia");
        strategysort<sanpham> st1 = new strategysort<>();
        st1.set_sort(new sort_gia<>());
        store.set_strategysort(st1);
        Iterator<sanpham> x3 = c.iterator();
        while(x3.hasNext()){
            x3.next().printsanpham();
        }  
    }
    static void run_thread(){
        // tao san pham 
        sanpham s1 = new sanpham("But", "NSX A", 5000);
        sanpham s2 = new sanpham("Vo", "NSX B", 10000);
        sanpham s3 = new sanpham("Tap", "NSX C", 15000);
        sanpham s4 = new sanpham("Keo", "NSX D", 3000);
        sanpham s5 = new sanpham("Thước", "NSX A", 7000);
        sanpham s6 = new sanpham("Cặp sách", "NSX E", 20000);
        
        electronicstore store = new electronicstore();
        
        List<sanpham> l1 = List.of(s1, s2, s3) ;
        
        List<sanpham> l2 = List.of(s3, s5,s6);     
        
        Thread t1 = new ES_thread(l1, store.list);
        Thread t2 = new ES_thread(l2, store.list);
        
        t1.start();
        t2.start();
        
        System.out.println("Hien thi toan bo san pham");
        create c = new create();
        c.list = store.list;
        Iterator<sanpham> x = c.iterator();
        while(x.hasNext()){
            x.next().printsanpham();
        }
    }
}
