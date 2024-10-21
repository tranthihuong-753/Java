package Bai1;

import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        book b1 = new book("Anh", "A", 2000);
        book b2 = new book("Dũng", "B", 2000);
        book b3 = new book("Hường", "C", 2000);
        book b4 = new book("Sang", "D", 2000);
        book b5 = new book("Sơn", "E", 2000);
        book b6 = new book("Như", "F", 2000);
        book b7 = new book("Thu", "G", 2000);
        book b8 = new book("Quỳnh Di", "H", 2000);
        
        sachKyThuat<book> obj_skt = new sachKyThuat<>();
        obj_skt.add(b1);
        obj_skt.add(b7);
        obj_skt.add(b3);
        obj_skt.add(b5);
        
        create cr = new create();
        cr.list_book = obj_skt.get_list();
                
        Iterator<book> it = cr.iterator();
        while(it.hasNext()){
            System.out.println(it.next().returnbook());
        }
        
        System.out.println("Xoa");
        obj_skt.delete(b5);
        Iterator<book> it1 = cr.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next().returnbook());
        }                
    }
    static void run(){
        book b1 = new book("Anh", "A", 2000);
        book b2 = new book("Dũng", "B", 2000);
        book b3 = new book("Hường", "C", 2000);
        book b4 = new book("Sang", "D", 2000);
        book b5 = new book("Sơn", "E", 2000);
        book b6 = new book("Như", "F", 2000);
        book b7 = new book("Thu", "G", 2000);
        book b8 = new book("Quỳnh Di", "H", 2000);
        
        sachKyThuat<book> obj_skt = new sachKyThuat<>();
        obj_skt.add(b1);
        obj_skt.add(b7);
        obj_skt.add(b3);
        obj_skt.add(b5);
        
        sachVanHoc<book> obj_svh = new sachVanHoc<>();
        obj_svh.add(b3);
        obj_svh.add(b6);
        obj_svh.add(b5);
        obj_svh.add(b2);
        
        sachKhoaHoc<book> obj_skh = new sachKhoaHoc<>();
        obj_skh.add(b5);
        obj_skh.add(b3);
        obj_svh.add(b7);
        obj_svh.add(b4);
        
        create cr = new create();
        cr.list_book = obj_skt.get_list();
        
        Iterator<book> it = cr.iterator();
        while(it.hasNext()){
            System.out.println(it.next().returnbook());
        }
        
        System.out.println("Xắp xếp theo tên tác giả");
        xapxep xx = new xapxep();
        xx.set_listbook(obj_skt.get_list());
        Iterator<book> it1 = cr.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next().returnbook());
        }  
    }
}

