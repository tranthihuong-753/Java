/*
3. Strategy Pattern
    Người dùng có thể chọn chiến lược để sắp xếp sách theo các tiêu chí khác nhau như 
    tên sách, năm xuất bản, hoặc tác giả.
*/
package Bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface sort<T>{
    void xapxep(List<T> l);
}
class sort_tentacgia<T extends book> implements sort<T>{  
    private List<T> list_book = new ArrayList<>(); 
    @Override
    public void xapxep(List<T> l) {
        Collections.sort(list_book, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return t1.getTensach().compareTo(t2.getTentacgia());
            }
        });        
    } 
}
class sort_tensach<T extends book> implements sort<T>{  
    private List<T> list_book = new ArrayList<>();   
    @Override
    public void xapxep(List<T> l) {
        Collections.sort(list_book, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return t1.getTensach().compareTo(t2.getTensach());
            }
        });        
    } 
}
class sort_namxuatban<T extends book> implements sort<T>{  
    private List<T> list_book = new ArrayList<>();  
    @Override
    public void xapxep(List<T> l) {
        Collections.sort(list_book, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return Integer.compare(t1.getNamxuatban(), t2.getNamxuatban());
            }
        });        
    } 
}
class xapxep<T>{
    private List<T> list_book = new ArrayList<>(); 
    private sort xx;
    public void set_listbook(List<T> list_book) {
        this.list_book = list_book;
    }
    public void thucthixapxep(sort xx) {
        this.xx = xx;
        xx.xapxep(list_book);
    }
}