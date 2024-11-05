/*
2. Iterator Pattern:
    Tạo một iterator để duyệt qua danh sách học sinh.
    Học sinh có thể được duyệt theo thứ tự sắp xếp khác nhau (theo tên, theo điểm trung bình, v.v.).
 */
package Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class create<T extends student> implements Iterable<T>{
    public List<T> list = new ArrayList<>();
    @Override
    public Iterator<T> iterator() {
        hienthi ht = new hienthi();
        ht.set_create(this);
        return ht;
    }    
}

class hienthi<T extends student> implements Iterator<T>{
    private create obj = new create();
    private int count = 0;
    public void set_create(create x){
        this.obj = x;
    }
    @Override
    public boolean hasNext() {
        return count < obj.list.size();
    }
    @Override
    public T next() {
        if(hasNext()){
            return (T)obj.list.get(count++);
        }
        return null;
    }
    public void sort_ten(){
        Collections.sort(obj.list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return t1.getTen().compareTo(t2.getTen());
            }
        });
    }
    public void sort_tuoi(){
        Collections.sort(obj.list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                return Integer.compare(t1.getTuoi(), t2.getTuoi());
            }
        });
    }
    public void sort_diemtrungbinh(){
        Collections.sort(obj.list, new Comparator<T>(){
            @Override
            public int compare(T t1, T t2){
                double avg1 = t1.getDiem() // Lấy List<Double> điểm từ đối tượng t1
                        .stream() // Chuyển đổi danh sách điểm thành một luồng (Stream)
                        .mapToDouble(Double::doubleValue) // Chuyển các đối tượng Double trong danh sách thành kiểu nguyên thủy double để tính toán
                        .average() // Tính giá trị trung bình của các giá trị double trong luồng
                        .orElse(0.0); // Nếu danh sách rỗng (không có giá trị để tính trung bình), trả về giá trị mặc định là 0.0
                double avg2 = t2.getDiem().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                return Double.compare(avg1, avg2);
            }
        });
    }
}
