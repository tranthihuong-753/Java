package netbean_17_buoi2_MauThietKe_Creational;

/*
Tạo 1 hàm để đảm bảo 1 class chỉ có duy nhất 1 instance 
*/

class hoa{
    private static hoa obj; // Biến static lưu trữ instance duy nhất của lớp
    public static String name;
    private hoa(){ // Constructor private để ngăn không cho tạo đối tượng từ bên ngoài
        
    }
    public static hoa GetInstance(){ // Phương thức static để lấy instance duy nhất của lớp
        if(obj == null){
            obj = new hoa();
        }
        return obj;
    }
    protected static void print(){
        System.out.println("hello " + name);
    }
}

public class s_singleton {
    public static void main(String[] args) {
        hoa h1 = hoa.GetInstance();
        System.out.println("Dia chi 1: " + h1.GetInstance().toString()); // Dia chi 1: netbean_17_buoi2_MauThietKe_Creational.hoa@7cca494b
        h1.name = "hoa huong duong";
        h1.print(); // hello hoa huong duong
         
        hoa h2 = hoa.GetInstance();
        System.out.println("Dia chi 2: " + h2.GetInstance().toString()); // Dia chi 2: netbean_17_buoi2_MauThietKe_Creational.hoa@7cca494b
        h2.name = " hoa hong";
        h1.print(); // hello  hoa hong
        h2.print(); // hello  hoa hong
        
    }
}
