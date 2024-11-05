package netbean_17_buoi2_MauThietKe_Creational;

interface vehicle{
    void driver();
}

class car implements vehicle{
    public void driver(){
        System.out.println("car");
    }
}

class moto implements vehicle{
    public void driver(){
        System.out.println("moto");
    }
}

class truck implements vehicle{
    public void driver(){
        System.out.println("truck");
    }
}

public class bai1_factory {
    public vehicle ini (String type){
        if(type.equals("car")){
            return new car();
        }
        else if(type.equals("moto")){
            return new moto();
        }
        else if(type.equals("truck")){
            return new truck();
        }
        return null;
    }
    public static void main(String[] args) {
        bai1_factory obj = new bai1_factory();
        obj.ini("moto").driver(); // moto 
        System.out.println(obj.ini("abc")); // null 
    }
}
