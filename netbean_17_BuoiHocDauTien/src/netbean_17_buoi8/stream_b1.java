package netbean_17_buoi8;

import java.util.ArrayList;
import java.util.List;

public class stream_b1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(12);

        int num = numbers.stream() 
                .filter(i -> i > 10 && i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        
        System.out.println("tong = " + num);        
    }
}
