package Bai4;

import java.util.ArrayList;
import java.util.List;

class sanpham{
    private String tensanpham;
    private String nhasanxuat;
    private float giaban;

    public sanpham(String tensanpham, String nhasanxuat, float giaban) {
        this.tensanpham = tensanpham;
        this.nhasanxuat = nhasanxuat;
        this.giaban = giaban;
    }
    public void printsanpham(){
        System.out.println("Ten san pham la " + this.tensanpham + " den tu nha san xuat " + this.nhasanxuat + " co gia ban " + this.giaban);
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public float getGiaban() {
        return giaban;
    }
    
}
class electronicstore<T extends sanpham>{
    public List<T> list = new ArrayList<>();
    public synchronized void addsp(T sp){
        list.add(sp);
        for(member m: listthongbao){
            System.out.println("Them san pham " + sp);
        }
    }
    public void removesp(T sp){
        list.remove(sp);
    }
    public T findspbytensp(String tensp){
        for(T t: list){
            if(t.getTensanpham().equalsIgnoreCase(tensp)){
                return (T)t;
            }
        }
        return null;
    }
    public void set_strategysort(strategysort<T> x) {
        x.sort(list);  // Gọi phương thức sort từ đối tượng strategysort
    }

    List<member> listthongbao = new ArrayList<>();
}