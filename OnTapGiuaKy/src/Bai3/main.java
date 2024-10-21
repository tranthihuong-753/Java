package Bai3;

import java.util.Iterator;
import java.util.List;

public class main{
    public static void main(String[] args) {
        run_thread();
    }
    static void run_nothread(){
        book b1 = new book("A", "Anh", 2000);
        book b2 = new book("B", "Dũng",  2000);
        book b3 = new book("C", "Hường",  2000);
        book b4 = new book("D", "Sang", 2000);
        book b5 = new book("E", "Sơn", 2000);
        book b6 = new book("F", "Như", 2000);
        book b7 = new book("G", "Thu",2000);
        
        bookstore store = new bookstore();
        store.addbook(b1);
        store.addbook(b4);
        store.addbook(b7);
        store.addbook(b2);
        store.addbook(b3);
        store.addbook(b6);
        store.addbook(b5);
        
        System.out.println("In ra tất cả các cuốn sachs ");
        create obj = new create();
        obj.list = store.list;
        Iterator<book> it = obj.iterator();
        while(it.hasNext()){
            it.next().printbook();
        }
        /*
Thêm A
Thêm D
Thêm G
Thêm B
Thêm C
Thêm F
Thêm E
In ra tất cả các cuốn sachs 
Sách A của tác giả Anh xuất bản năm 2000
Sách D của tác giả Sang xuất bản năm 2000
Sách G của tác giả Thu xuất bản năm 2000
Sách B của tác giả Dũng xuất bản năm 2000
Sách C của tác giả Hường xuất bản năm 2000
Sách F của tác giả Như xuất bản năm 2000
Sách E của tác giả Sơn xuất bản năm 2000
        */
        
        System.out.println("Xắp xếp theo tên sách");
        sortstrategy ss = new sortstrategy();
        ss.list = store.list;
        ss.set_kieudulieu(new sortbytitle());
        store.set_sortstrategy(ss);
        Iterator<book> it1 = obj.iterator();
        while(it1.hasNext()){
            it1.next().printbook();
        }
/*
Xắp xếp theo tên sách
Sách A của tác giả Anh xuất bản năm 2000
Sách D của tác giả Sang xuất bản năm 2000
Sách G của tác giả Thu xuất bản năm 2000
Sách B của tác giả Dũng xuất bản năm 2000
Sách C của tác giả Hường xuất bản năm 2000
Sách F của tác giả Như xuất bản năm 2000
Sách E của tác giả Sơn xuất bản năm 2000        
*/        
    }
    //Sử dụng Thread để thêm sách vào cửa hàng
    // 1. Thêm key " synchronized " vào addbook() 
    static void run_thread(){
        book b1 = new book("A", "Anh", 2000);
        book b2 = new book("B", "Dũng",  2000);
        book b3 = new book("C", "Hường",  2000);
        book b4 = new book("D", "Sang", 2000);
        book b5 = new book("E", "Sơn", 2000);
        book b6 = new book("F", "Như", 2000);
        book b7 = new book("G", "Thu",2000);
        
        bookstore store = new bookstore();

        // Tạo các luồng cho từng nhóm sách
        List<book> group1 = List.of(b1, b2, b3);
        List<book> group2 = List.of(b4, b5);
        List<book> group3 = List.of(b6, b7);

        // Tạo các luồng cho từng nhóm sách
        Thread thread1 = new AddBookTask(store, group1);
        Thread thread2 = new AddBookTask(store, group2);
        Thread thread3 = new AddBookTask(store, group3);

        // Chạy các luồng
        thread1.start();
        thread2.start();
        thread3.start();
        
        System.out.println("In ra tất cả các cuốn sách ");
        create obj = new create();
        obj.list = store.list;
        Iterator<book> it = obj.iterator();
        while(it.hasNext()){
            it.next().printbook();
        }
/*
In ra tất cả các cuốn sachs 
Sách A của tác giả Anh xuất bản năm 2000
Sách B của tác giả Dũng xuất bản năm 2000
Sách F của tác giả Như xuất bản năm 2000
Sách C của tác giả Hường xuất bản năm 2000
Sách G của tác giả Thu xuất bản năm 2000
Sách D của tác giả Sang xuất bản năm 2000
Sách E của tác giả Sơn xuất bản năm 2000
        */
    }
}