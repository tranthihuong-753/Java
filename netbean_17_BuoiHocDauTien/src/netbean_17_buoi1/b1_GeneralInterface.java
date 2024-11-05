/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbean_17_buoi1;

interface meme1<a>{
    public void set_pr(a x);  
    public void print();
}

class huong<a> implements meme1<a>{
    private a bien;
    public void set_pr(a x){
        this.bien = x;
    }
    public void print(){
        System.out.println(bien);
    }
}

public class b1_GeneralInterface {
    public static void main(String[] args) {
        meme1<String> m = new huong<>();
        m.set_pr("ha ha");
        m.print();
    }
}
