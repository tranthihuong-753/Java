package netbean_17_buoi1;

class Box<T>{
    private T value;
    public Box(T a){
        this.value = a;
    }
//    public T v1;
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}

public class b1_GenericClass {
    public static void main(String[] args) {
        //su dung generic class 
        Box<Integer> intbox = new Box<>(123);
        System.out.println("integer value : " + intbox.getValue());
        
        Box<String> stringbox = new Box<>("Chó mèo .");
        System.out.println("string : " + stringbox.getValue());
        
    }
}
