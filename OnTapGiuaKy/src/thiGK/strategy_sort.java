package thiGK;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface sort<T extends sach>{
    void sort(List<T> l);
}

class sort_tieude<T extends sach> implements sort<T>{
    @Override
    public void sort(List<T> l) {
        Collections.sort(l, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return o1.getTieude().compareTo(o2.getTieude());
            }
            
        });
    }   
}
class sort_tacgia<T extends sach> implements sort<T>{
    @Override
    public void sort(List<T> l) {
        Collections.sort(l, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return o1.getTacgia().compareTo(o2.getTacgia());
            }
            
        });
    }   
}
class sort_namxuatban<T extends sach> implements sort<T>{
    @Override
    public void sort(List<T> l) {
        Collections.sort(l, new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                return Integer.compareUnsigned(o1.getNamxuatban(), o2.getNamxuatban());
            }
            
        });
    }   
}
class strategy_sort<T extends sach> implements sort<T>{
    private sort s ;

    public void set_sort(sort s) {
        this.s = s;
    }

    @Override
    public void sort(List<T> l) {
        this.s.sort(l);
    }
    
}