package thiGK;

import java.util.ArrayList;
import java.util.List;

class sach{
    private String tieude;
    private String tacgia;
    private int namxuatban;
    public sach(String tieude, String tacgia, int namxuatban) {
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
    public void print_sach(){
        System.out.println("Sach " + this.tieude + " cua " + this.tacgia + " xuat ban vao nam " + this.namxuatban);
    }
    public String return_sach(){
        return "Sach " + this.tieude + " cua " + this.tacgia + " xuat ban vao nam " + this.namxuatban;
    }
}

class library<T extends sach>{
    private List<T> list = new ArrayList<>();
    public void set_list(List<T> l){
        this.list = l;
    }

    public List<T> get_list() {
        return list;
    }
    
    public synchronized void addDocument(T t){
        this.list.add(t);
        for(thanhvien tv: list_thanhvien){
            this.set_thongbao("Them sach moi " + t.return_sach());
            tv.setThongbao(thongbao);
        }
    }
    public void removeDocument(T t){
        this.list.remove(t);
    }
    public T findDocumentbytitle(String title){
        for(T t: this.list){
            if(t.getTieude().equalsIgnoreCase(title)){
                return t;
            }
        }
        return null;
    }
    
    private List<thanhvien> list_thanhvien = new ArrayList<>() ;
    private String thongbao;

    public void set_thongbao(String thongbao) {
        this.thongbao = thongbao;
    }

    public String get_thongbao() {
        return thongbao;
    }
    
    public void set_list_thanhvien(List<thanhvien> list_thanhvien) {
        this.list_thanhvien = list_thanhvien;
    }  
}
