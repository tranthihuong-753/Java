package Bai4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class create<T> implements Iterable<T>{
    public List<T> list = new ArrayList<>();

    @Override
    public Iterator<T> iterator() {
        EST est = new EST();
        est.set_create(this);
        return est;
    }
}
class EST<T> implements Iterator<T>{
    private create obj;
    private int count = 0;
    public void set_create(create x){
        this.obj = x;
    }

    @Override
    public boolean hasNext() {
        return count < this.obj.list.size();
    }

    @Override
    public T next() {
        if(hasNext()){
            return (T)this.obj.list.get(count++);
        }
        return null;
    }
    
}    
