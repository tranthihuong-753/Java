/*
2. Iterator Pattern
    Hệ thống phải cho phép duyệt qua các loại sách trong thư viện một cách tuần tự 
    mà không cần quan tâm đến cách lưu trữ nội bộ của chúng.
 */
package Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class create<T extends book> implements Iterable<T>{
    List<T> list_book = new ArrayList<>();

    @Override
    public Iterator<T> iterator() {
        hienthi ht = new hienthi();
        ht.set_create(this);
        return ht;
    }
}
class hienthi<T extends book> implements Iterator<T>{
    private create obj;
    public void set_create(create x){
        this.obj = x;
    }
    private int count = 0;
    @Override
    public boolean hasNext() {
        return count < obj.list_book.size();
    }

    @Override
    public T next() {
        while(hasNext()){
            return (T) obj.list_book.get(count++);
        }
        return null;
    }
}


