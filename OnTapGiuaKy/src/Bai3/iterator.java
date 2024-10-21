package Bai3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class create<T> implements Iterable<T>{
    public List<T> list = new ArrayList<>();
    @Override
    public Iterator<T> iterator() {
        bookstoreiterator b = new bookstoreiterator();
        b.set_create(this);
        return b;
    }    
}
class bookstoreiterator<T> implements Iterator<T>{
    private create obj = new create();
    private int count = 0;
    public void set_create(create x){
        this.obj = x;
    }

    @Override
    public boolean hasNext() {
        return count < obj.list.size();
    }

    @Override
    public T next() {
        if(hasNext()){
            return (T)this.obj.list.get(count++);
        }
        return null;
    }
    
}

public class iterator {
    
}
