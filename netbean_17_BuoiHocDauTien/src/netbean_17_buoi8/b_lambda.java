package netbean_17_buoi8;

import java.util.Arrays;
import java.util.List;

public class b_lambda {
    public static void main(String[] args) {
        // Khởi tạo danh sách các số nguyên
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sử dụng biểu thức lambda để in ra từng số trong danh sách
        numbers.forEach(num -> System.out.println(num));
/*
        for (Integer num : numbers) {
            System.out.println(num);
        }        
*/
        // Lọc ra các số chẵn và lưu vào danh sách mới
        List<Integer> evenNumbers = numbers.stream()
            .filter(num -> num % 2 == 0) // Lọc số chẵn bằng lambda
            .toList(); // Chuyển đổi kết quả thành danh sách
/*
        List<Integer> evenNumbers = numbers.stream()
            .filter(new java.util.function.Predicate<Integer>() {
                @Override
                public boolean test(Integer num) {
                    return num % 2 == 0; // Kiểm tra xem số có phải là chẵn không
                }
            })
            .collect(Collectors.toList()); // Chuyển đổi kết quả thành danh sách

*/
        // In danh sách số chẵn
        System.out.println("Số chẵn trong danh sách: " + evenNumbers);

    }
}
