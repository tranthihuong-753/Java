package thiGK;

import java.util.ArrayList;
import java.util.List;

class sach_thread<T extends sach> extends Thread{
    private List<T> list_in = new ArrayList<>();
    private List<T> list_out = new ArrayList<>();
    public sach_thread(List<T> in, List<T> out){
        this.list_in = in;
        this.list_out = out;
    }
    @Override
    public void run() {
        list_out.addAll(list_in);
    }
}
