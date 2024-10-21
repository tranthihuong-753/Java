/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

import java.util.ArrayList;
import java.util.List;

class book{
    private String tieude;
    private String tacgia;
    private int namxuatban;

    public book(String tieude, String tacgia, int namxuatban) {
        this.tieude = tieude;
        this.tacgia = tacgia;
        this.namxuatban = namxuatban;
    }

    public String getTieude() {
        return tieude;
    }

    public String getTacgia() {
        return tacgia;
    }

    public int getNamxuatban() {
        return namxuatban;
    }
    public void printbook(){
        System.out.println("Sách " + this.tieude + " của tác giả " + this.tacgia + " xuất bản năm " + this.namxuatban);
    }
}
class bookstore<T extends book> extends Thread{
    public List<T> list = new ArrayList<>();
    public synchronized void addbook(T book){
        list.add(book);
        for(member m: listmember){
            System.out.println("Thêm " + book.getTieude());
        }
    }
    public void removebook(T book){
        list.remove(book);
        for(member m: listmember){
            System.out.println("Xóa " + book.getTieude());
        }
    }
    public T findbookbytitle(String title){
        for(T x : list){
            if(x.getTieude().equals(title)){
                return x;
            }
        }
        return null;
    }
    public void set_sortstrategy(sortstrategy x){
        x.sapxep();
    }
    public List<member> listmember = new ArrayList<>();
}
class member{
    
}
