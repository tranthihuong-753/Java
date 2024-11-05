package netbean_17_buoi8;

import java.util.ArrayList;
import java.util.List;

public class a_stream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(-5);
        
        int num = numbers.stream()
                .filter(i -> i < 2) //giữ lại những phần tử nhỏ hơn 2
                .mapToInt(Integer::intValue) // Chuyển các đối tượng Integer thành kiểu nguyên thủy int
                .sum(); // Tính tổng các phần tử đã được lọc và chuyển đổi
        
        System.out.println("tong = " + num);
        
                // Tính số lượng phần tử trong danh sách
        long count = numbers.stream()
            .count(); // Đếm số lượng phần tử
        System.out.println("Số lượng phần tử trong danh sách: " + count);

        // Tìm số lớn nhất trong danh sách
        int max = numbers.stream()
            .mapToInt(Integer::intValue) // Chuyển đổi sang kiểu int
            .max() // Tìm giá trị lớn nhất
            .orElse(0); // Nếu không có phần tử nào thì trả về 0
        System.out.println("Số lớn nhất trong danh sách: " + max);

        // Tính trung bình của các phần tử trong danh sách
        double average = numbers.stream()
            .mapToInt(Integer::intValue) // Chuyển đổi sang kiểu int
            .average() // Tính trung bình
            .orElse(0); // Nếu không có phần tử nào thì trả về 0
        System.out.println("Giá trị trung bình của danh sách: " + average);
 
    }
}
