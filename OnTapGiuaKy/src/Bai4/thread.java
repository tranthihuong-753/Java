package Bai4;

import java.util.ArrayList;
import java.util.List;

class ES_thread<T> extends Thread{
    private List<T> list_in = new ArrayList<>();
    private List<T> list_out = new ArrayList<>();
    public ES_thread(List<T> in, List<T> out){
        this.list_in = in;
        this.list_out = out;
    }

    @Override
    public void run() {
        list_out.addAll(list_in);
    }
} 
