package netbean_17_buoi1;

import java.util.Scanner;

public class b1_GenericMethod {
    // a la kieu du lieu 
    public static <a> void demo(a[] bien){
        int i;
        for(i = 0 ; i< bien.length ; i++){
            System.out.println(bien[i]);
        }
    }
    static void run_demo(){
        // tao mang
        Integer[] arr = new Integer[]{1, 2, 4, 5};
        demo(arr);
        // Khong dung int duoc 
//        int[] arr1 = new int[]{1, 2, 4, 5};
//        demo(arr1);
        String[] fooddrink = {"com", "Com", "cOm", "coM", "COM"};
        demo(fooddrink);
    }
    // cong 2 data 
    public static <a> void add(a a1, a a2){
        Integer x = (Integer)a2 + (Integer)a1;
        System.out.println(x);
    } 
    static void run_add(){
        String a1 = "f";
        String a2 = "1";
        add(a1, a2);
    }
    public static <a extends Number> double add1(a x, a y){
        return x.doubleValue()+y.doubleValue();
    }
    static void run_add1(){
        System.out.println(add1(234567894, 6.35436674325874758943750458));
    }
    public static <a> Integer add2(a x, a y){
        return (Integer)x + (Integer)y;
    }
    static void run_add2(){
        System.out.println(add2(1, 'f'));
    }
    static void run_test(){
        
    }
    public static void main(String[] args) {
        run_add2();
    }
}
