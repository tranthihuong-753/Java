package netbean_17_buoi3_MauThietKe_Structural;

interface product{
    boolean hasnext();
    Object next();
}

interface container{
    product getiterator();
}

class productrepository implements container{
    String sp[]={"but", "giay", "muc", "thuoc"};
    public product getiterator(){
        return new productitperator();
    }
    private class productitperator implements product{
        public int index = 0;
        public boolean hasnext(){
            return index < sp.length;
        }
        public Object next(){
            if(this.hasnext() == true){
                return sp[index ++];
            }
            return null;
        }
    }
}

public class iterator_bai1 {
    public static void main(String[] args) {
        productrepository p = new productrepository();
        for(product i = p.getiterator(); i.hasnext();){
            String x = (String)i.next();
            System.out.println(x);
        }
    }
}
