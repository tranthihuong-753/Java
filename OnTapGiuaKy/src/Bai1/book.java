/*
1. Generic/Collections
    Ứng dụng phải có khả năng quản lý nhiều loại sách khác nhau như sách kỹ thuật, văn học, khoa học, v.v. 
    Mỗi loại sách bao gồm danh sách các chi tiết cụ thể như tên, tác giả, năm xuất bản, v.v.
 */
package Bai1;

// không public book thì không sử dụng được trong lớp khác 
class book{
    private String tentacgia;
    private String tensach;
    private int namxuatban;
    public book(String x, String y, int z){
        this.tentacgia = x;
        this.tensach = y;
        this.namxuatban = z;
    }
    public String getTentacgia() {
        return tentacgia;
    }
    public String getTensach() {
        return tensach;
    }
    public int getNamxuatban() {
        return namxuatban;
    }
    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }
    public void setTensach(String tensach) {
        this.tensach = tensach;
    }
    public void setNamxuatban(int namxuatban) {
        this.namxuatban = namxuatban;
    }   
    public String returnbook(){
        return "Sách " + this.getTensach() + " của tác giả " + this.tentacgia + " xuất bản vào năm " + this.namxuatban;
    }
}
