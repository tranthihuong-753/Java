package Bai3;

import java.util.List;

// Them key "synchronized" vao method addbook trong class bookstore 
class AddBookTask<T extends book> extends Thread{
    private List<T> list;
    private bookstore bs;

    public AddBookTask(bookstore bs, List<T> list) {
        this.list = list;
        this.bs = bs;
    }

    @Override
    public void run() {
        for(T x: list){
            bs.addbook(x);
        }
    }
}
