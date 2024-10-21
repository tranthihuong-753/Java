/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;
// Iterable là một interface cho phép trả về 1 Iterator 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Lớp create cài đặt Iterable
class create implements Iterable<String> {
    public List<String> l = new ArrayList<>();
    // Trả về đối tượng Iterator
    public Iterator<String> iterator() {
        hienthi ht = new hienthi();
        ht.set_create(this); // Thiết lập đối tượng create hiện tại cho Iterator
        return ht;
    }
}

// Lớp hienthi cài đặt Iterator
class hienthi implements Iterator<String> {
    private create A; // Đối tượng create mà Iterator sẽ lặp qua
    private int count = 0; // Đếm vị trí trong danh sách
    // Gán đối tượng create cho Iterator
    public void set_create(create A) {
        this.A = A;
    }
    // Kiểm tra xem còn phần tử nào để duyệt hay không
    public boolean hasNext() {
        return count < A.l.size();
    }
    // Lấy phần tử tiếp theo
    public String next() {
        if (hasNext()) {
            return A.l.get(count++);
        }
        return null;
    }
    // Phương thức sắp xếp danh sách theo thứ tự abc
    public void list_abc() {
        Collections.sort(A.l);
    }
}
public class mau1 {
    public static void main(String[] args) {
        create mycreate = new create();
        mycreate.l.add("banana");
        mycreate.l.add("apple");
        mycreate.l.add("cherry");
        
        Iterator<String> it = mycreate.iterator();
        
        System.out.println("Chưa sắp xếp");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("Sắp xếp theo abc");
        // Tạo lại hienthi khi thêm phần tử mới 
        hienthi htit = (hienthi)mycreate.iterator();
        htit.list_abc();
        
        Iterator<String> sortedit = mycreate.iterator();
        while(sortedit.hasNext()){
            System.out.println(sortedit.next());
        }
    }
}


