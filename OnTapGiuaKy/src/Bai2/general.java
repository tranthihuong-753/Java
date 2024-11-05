/*
1. Danh sách học sinh (Generic/Collections):
    Tạo một lớp Student, chứa các thuộc tính như tên, tuổi, và danh sách điểm các môn học.
    Sử dụng List<Student> để quản lý danh sách học sinh. 
    Danh sách này cần sử dụng Generics và Collections.
*/
package Bai2;

import java.util.ArrayList;
import java.util.List;

class student{
    private String ten;
    private int tuoi;
    private List<Double> diem;

    public student(String ten, int tuoi, List<Double> diem) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public List<Double> getDiem() {
        return diem;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setDiem(List<Double> diem) {
        this.diem = diem;
    }
    
}
interface thaotac<T>{
    void add(T t);
    void delete(T t);
}
class lop<T extends student> implements thaotac<T>{
    List<student> list = new ArrayList<>();
    @Override
    public void add(T t) {
        list.add(t);
    }
    @Override
    public void delete(T t) {
        list.remove(t);
    } 
}
