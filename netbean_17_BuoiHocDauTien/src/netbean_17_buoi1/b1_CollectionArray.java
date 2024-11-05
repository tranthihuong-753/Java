package netbean_17_buoi1;

import java.util.ArrayList;

public class b1_CollectionArray {
    public static void main(String[] args) {
        run_fibo(45);
    }
    // collection array 
    static void run_array(){
        ArrayList<String> arr = new ArrayList<>();
        // thêm 
        arr.add("apple");
        arr.add(0, "orange");
        arr.add("no no no");
        // in 
        for(String x : arr){
            System.out.println(x);
        }
        // xóa 
        arr.remove(1);
        // in 
        for(String s:arr){
            System.out.println(s);
        }
    }
    // hien thi n so fibonaci dau tien 
    static void run_fibo(int n){
        Integer x = 0 ;
        Integer y = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(x);
        arr.add(y);
        int count = 0 ;
        while(count < n){
            Integer m = x + y;
            arr.add(m);
            x = y ;
            y = m ;
            count++;
        }
        System.out.println(arr.get(44));
    }
}
