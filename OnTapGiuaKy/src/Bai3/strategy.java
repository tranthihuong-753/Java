package Bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface sort<T>{
    void sapxep();
}
class sortbytitle<T extends book> implements sort<T>{
    private List<T> list = new ArrayList<>();
    @Override
    public void sapxep() {
        Collections.sort(list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return t1.getTieude().compareTo(t2.getTieude());
            }
        });
    }    
}
class sortbyauthor<T extends book> implements sort<T>{
    private List<T> list = new ArrayList<>();
    @Override
    public void sapxep() {
        Collections.sort(list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return t1.getTacgia().compareTo(t2.getTacgia());
            }
        });
    }    
}
class sortbyyear<T extends book> implements sort<T>{
    private List<T> list = new ArrayList<>();
    @Override
    public void sapxep() {
        Collections.sort(list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return Integer.compareUnsigned(t1.getNamxuatban(), t2.getNamxuatban());
            }
        });
    }    
}
class sortstrategy<T> implements sort<T>{
    public List<T> list = new ArrayList<>();
    sort<T> kieudulieu;
    public void set_kieudulieu(sort<T> x){
        this.kieudulieu = x;
    }
    public void sapxep() {
        this.kieudulieu.sapxep();
    }
    
}
