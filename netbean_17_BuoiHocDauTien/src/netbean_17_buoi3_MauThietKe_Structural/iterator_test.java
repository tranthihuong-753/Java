/*
Bài tập: Quản lý Danh Sách Nhân Viên
Yêu cầu: Hãy xây dựng một chương trình Java để quản lý danh sách nhân viên. 
Mỗi nhân viên có các thông tin như: tên, tuổi và chức vụ. 
Cần triển khai Iterator Design Pattern để duyệt qua danh sách các nhân viên.

Hướng dẫn:
Tạo một class Employee đại diện cho nhân viên, có các thuộc tính:
    name (tên nhân viên)
    age (tuổi của nhân viên)
    position (chức vụ của nhân viên)
Tạo một interface Iterator với các phương thức:
    boolean hasNext(): Kiểm tra xem còn nhân viên nào trong danh sách không.
    Employee next(): Trả về nhân viên tiếp theo.
Tạo một interface Container với phương thức:
    Iterator getIterator(): Trả về một iterator để duyệt qua các nhân viên.
Tạo một class EmployeeRepository chứa danh sách các nhân viên và triển khai interface Container.
Tạo một lớp EmployeeIterator bên trong EmployeeRepository, triển khai interface Iterator để duyệt qua danh sách nhân viên.
Cuối cùng, tạo lớp IteratorPatternDemo với phương thức main() , 
để sử dụng iterator duyệt qua danh sách nhân viên và in ra thông tin của từng nhân viên.
*/

package netbean_17_buoi3_MauThietKe_Structural;

public class iterator_test {
    
}
