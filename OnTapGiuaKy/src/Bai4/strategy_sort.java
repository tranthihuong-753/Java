package Bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

interface sort<T>{
    void sort(List<T> t);
}
class sort_ten<T extends sanpham> implements sort<T>{
    @Override
    public void sort(List<T> t) {
        Collections.sort(t, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return o1.getTensanpham().compareTo(o2.getTensanpham());
            }
        });
    }
}
class sort_nhasx<T extends sanpham> implements sort<T>{
    @Override
    public void sort(List<T> t) {
        Collections.sort(t, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return o1.getNhasanxuat().compareTo(o2.getNhasanxuat());
            }
        });
    }   
}
class sort_gia<T extends sanpham> implements sort<T>{
    @Override
    public void sort(List<T> t) {
        Collections.sort(t, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return Float.compare(o1.getGiaban(),o2.getGiaban() );
            }         
        });
    }
}
class strategysort<T extends sanpham> implements sort<T>{
    private sort<T> obj ;
    public void set_sort(sort<T> x){
        this.obj = x;
    }
    @Override
    public void sort(List<T> t) {
        this.obj.sort(t);
    }
}