package netbean_17_buoi2_MauThietKe_Creational;

interface trobonlemot{
    void study();
}
class anhduong implements trobonlemot{
    public void study(){
        System.out.println(this.getClass().getName() + " dang hoc chu nghĩa xa hoi khoa hoc. ");
    }
}
class huongduong implements trobonlemot{
    public void study(){
        System.out.println(this.getClass().getName() + " dang hoc java. ");
    }
}
class linhduong implements trobonlemot{
    public void study(){
        System.out.println(this.getClass().getName() + " dang hoc xac suat thong ke. ");
    }
}
class trofactory{
    public trobonlemot createtro(String e){ // e = {anhduong, huongduong, linhduong}
        if(e.equalsIgnoreCase("anhduong")){
            return new anhduong();
        }
        else if(e.equalsIgnoreCase("huongduong")){
            return new huongduong();
        }
        else if(e.equalsIgnoreCase("linhduong")){
            return new linhduong();
        }    
        return null;
    }
}

public class s_factory{
    public static void main(String[] args) {
        trofactory e = new trofactory();
        e.createtro("anhduong").study(); // netbean_17_buoi2_MauThietKe_Creational.anhduong dang hoc chu nghĩa xa hoi khoa hoc. 
        e.createtro("cho").study(); // loi 
    }
}

