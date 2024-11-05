// Sử dụng Iterator cho phép duyệt qua 1 list, array, .. mà không cần biết cấu trúc cụ thể của nó 

package netbean_17_buoi3_MauThietKe_Structural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Iterable là một interface cho phép trả về 1 Iterator 
class create implements Iterable<String>{
    public List<String> l = new ArrayList<>();
    public Iterator<String> iterator(){
        return new hienthi();
    }
}
class hienthi implements Iterator<String>{
    private create A;
    private int count = 0;
    public void setA(create A) {
        this.A = A;
    }
    public boolean hasNext() {
        return count<A.l.size();
    }
    public String next() {
        if(hasNext()){
            return A.l.get(count++);
        }
        return null;
    }
    public void list_abc(){
        Collections.sort(A.l);
    }
}
public class as_iterator_bolap {
    public static void main(String[] args) {
        create list = new create();
        hienthi pr = new hienthi();
        pr.setA(list);
        list.l.add("Cho");
        list.l.add("meo");
        list.l.add("ca");
        list.l.add("ho");
        list.l.add("ha ha");
        
        System.out.println("Chưa sắp xếp");
        while(pr.hasNext()){
            System.out.println(pr.next());
        }
        System.out.println("Sắp xếp");
        pr.list_abc();
        while(pr.hasNext()){
            System.out.println(pr.next());
        }
    }
}
