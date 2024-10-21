/*
3. Strategy Pattern:
    Tạo các chiến lược khác nhau để tính điểm tổng kết cho mỗi học sinh:
        Chiến lược tính điểm trung bình.
        Chiến lược tính điểm cao nhất.
 */
package Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface quanly{
    void tinhdiem(int index);
}
class diemtrungbinh<T extends student> implements quanly{
    private List<T> list = new ArrayList<>();
    private List<Double> listdiemtrungbinh = new ArrayList<>();
    @Override
    public void tinhdiem(int index) {
        double TB = this.list.get(index).getDiem().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        listdiemtrungbinh.set(index, TB);
    }
}
class diemlonnhat<T extends student> implements quanly{
    private List<T> list = new ArrayList<>();
    private List<Double> listdiemlonnhat = new ArrayList<>();
    @Override
    public void tinhdiem(int index) {
        double TB = this.list.get(index).getDiem().stream().max(Double::compareTo).orElse(0.0);;
        listdiemlonnhat.set(index, TB);
    }    
}
class diemso implements quanly{
    quanly ql;
    public void set_quanly(quanly x){
        this.ql = x;
    }

    @Override
    public void tinhdiem(int index) {
        ql.tinhdiem(index);
    }
}
