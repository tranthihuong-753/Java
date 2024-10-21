/*
4. Observer Pattern
    Khi một loại sách mới được thêm vào hoặc một cuốn sách bị xóa
    hệ thống sẽ phải thông báo cho các đối tượng đã đăng ký (subscribers) về những thay đổi này.
 */
package Bai1;

import java.util.ArrayList;
import java.util.List;

interface quanly<T extends book>{
    void add(T k);
    void delete(T k);
}
class sachKyThuat<T extends book> implements quanly<T>{
    private List<T> list = new ArrayList<>();
    @Override
    public void add(T k){
        this.list.add(k);
    }
    @Override
    public void delete(T k){
        this.list.remove(k);
    }
    public List<T> get_list(){
        return this.list;
    }
}
class sachVanHoc<T extends book> implements quanly<T>{
    private List<T> list = new ArrayList<>();

    @Override
    public void add(T k){
        this.list.add(k);
    }
    @Override
    public void delete(T k){
        this.list.remove(k);
    }
    public List<T> get_list(){
        return this.list;
    }
}
class sachKhoaHoc<T extends book> implements quanly<T>{
    private List<T> list = new ArrayList<>();
    @Override
    public void add(T k){
        this.list.add(k);
    }
    @Override
    public void delete(T k){
        this.list.remove(k);
    }  
    public List<T> get_list(){
        return this.list;
    }
}
class observer<T extends book> implements quanly<T>{
    private quanly obj;
    public void set_kieusach(quanly x){
        this.obj = x;
    }
    public void add(T k) {
        obj.add(k);
        System.out.println("Thêm " + k.returnbook());
    }
    public void delete(T k) {
        obj.delete(k);
        System.out.println("Xóa " + k.returnbook());
    }
}