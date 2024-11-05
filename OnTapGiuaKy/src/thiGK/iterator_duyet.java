package thiGK;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class create<T extends sach> implements Iterable<T>{
    private List<T> list = new ArrayList<>();
    public void set_list(List<T> l){
        this.list = l;
    }

    public List<T> get_list() {
        return list;
    }
    @Override
    public Iterator<T> iterator() {
        libreryiterator obj = new libreryiterator();
        obj.set_create(this);
        return obj;
    }
}
class libreryiterator<T extends sach> implements Iterator<T>{
    private create obj;
    private int count = 0;
    public void set_create(create x){
        this.obj = x;
    }

    @Override
    public boolean hasNext() {
        return count < this.obj.get_list().size();
    }

    @Override
    public T next() {
        if(hasNext()){
            return (T)this.obj.get_list().get(count++);
        }
        return null;
    }
    
}
