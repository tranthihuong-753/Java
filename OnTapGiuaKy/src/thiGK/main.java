package thiGK;

import java.util.Iterator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        run_nothread();
//        run_thread();
    }
    static void run_nothread(){
        // Tạo sách 
        sach book1 = new sach("Tôi thấy ohoa vàn trên cỏ xanh", "tac_gia m", 2000);
        sach book2 = new sach("sách g", "tac_gia fds", 2003);
        sach book3 = new sach("sách ad", "tac_gia h", 2002);
        sach book4 = new sach("sách e", "tac_gia dung", 2010);
        sach book5 = new sach("sách hj", "tac_gia mai", 2013);
        sach book6 = new sach("sách m", "tac_gia mhaha", 2020);
        sach book7 = new sach("sách t", "tac_gia u", 2001);
        
        // Tạo list 
        library thuvien = new library();
        thuvien.addDocument(book1);
        thuvien.addDocument(book2);
        thuvien.addDocument(book3);
        thuvien.addDocument(book4);
        thuvien.addDocument(book5);
        
        // Hiển thị toàn bộ sách trong thư viện một cách tuần tự 
        System.out.println("Tất cả sách trong thư viện ");
        create c = new create();
        c.set_list(thuvien.get_list());
        Iterator<sach> it = c.iterator();
        while(it.hasNext()){
            it.next().print_sach();
        }
        
        // Hiển thị toàn bộ sách trong thư viện sắp xếp theo tiêu đề 
        System.out.println("Tất cả sách trong thư viện sắp xếp theo tiêu đề ");
        strategy_sort sort = new strategy_sort();
        sort.set_sort(new sort_tieude());
        sort.sort(thuvien.get_list());
        Iterator<sach> it1 = c.iterator();
        while(it1.hasNext()){
            it1.next().print_sach();
        }
        
        // Thành viên nhận thông báo 
        // Tạo thành viên 
        thanhvien tv1 = new thanhvien("Tran Huong", 2005);
        thanhvien tv2 = new thanhvien("Ngoc Anh", 2003);
        thanhvien tv3 = new thanhvien("Phan Linh", 2008);
        
        // Tạo list thành viên 
        List<thanhvien> list_thanhvien = List.of(tv1, tv2, tv3);
        thuvien.set_list_thanhvien(list_thanhvien);
        tv1.nhanthongbao();// Mới khởi tạo nên chưa có thông báo: Tran Huong sinh nam 2005 nhan thong bao null
        thuvien.addDocument(book6); 
        for(thanhvien tv: list_thanhvien){
            tv.nhanthongbao();
        }
        /*
        Tất cả thàn viên đã nhận thông báo 
Tran Huong sinh nam 2005 nhan thong bao Them sach moi Sach sách m cua tac_gia mhaha xuat ban vao nam 2020
Ngoc Anh sinh nam 2003 nhan thong bao Them sach moi Sach sách m cua tac_gia mhaha xuat ban vao nam 2020
Phan Linh sinh nam 2008 nhan thong bao Them sach moi Sach sách m cua tac_gia mhaha xuat ban vao nam 2020        
        */
    }
    static void run_thread(){
        // Tạo sách 
        sach book1 = new sach("sách a", "tác giả m", 2000);
        sach book2 = new sach("sách g", "tác giả fds", 2003);
        sach book3 = new sach("sách ad", "tác giả h", 2002);
        sach book4 = new sach("sách e", "tác giả dung", 2010);
        sach book5 = new sach("sách hj", "tác giả mai", 2013);
        sach book6 = new sach("sách m", "tác giả mhaha", 2020);
        sach book7 = new sach("sách t", "tác giả u", 2001);
        
        // Tạo list 
        List<sach> list1 = List.of(book1, book2, book3);
        List<sach> list2 = List.of(book4, book5, book6, book7);
        
        library thuvien = new library();
        
        // Tạo Thread 
        Thread luong1 = new sach_thread(list1, thuvien.get_list());
        Thread luong2 = new sach_thread(list2, thuvien.get_list());
        
        luong1.start();
        luong2.start();
        
        // Hiển thị sách 
        // Hiển thị toàn bộ sách trong thư viện một cách tuần tự 
        System.out.println("Tất cả sách trong thư viện ");
        create c = new create();
        c.set_list(thuvien.get_list());
        Iterator<sach> it = c.iterator();
        while(it.hasNext()){
            it.next().print_sach();
        }        
    }
}
