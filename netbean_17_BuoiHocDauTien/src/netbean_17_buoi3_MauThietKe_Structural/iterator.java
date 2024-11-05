package netbean_17_buoi3_MauThietKe_Structural;

interface coursename{
    boolean hasNext();
    Object next();
}

interface semester{
    coursename getIterator();
}

class major implements semester{
    public String course[]={"Lap tring java", "LT C#", "Toan dai cuong"};
    @Override
    public coursename getIterator(){
        return new coursenameiterator();
    }
    private class coursenameiterator implements coursename{
        public int index = 0;
        public boolean hasNext(){
            return index < course.length;
        }
        public Object next(){
            if(this.hasNext() == true){
                return course[index++];
            }
            return null;
        }
    }
}

public class iterator {
    public static void main(String[] args) {
        major m = new major();
        // i là 1 biến iterator 
        // hasNext() kiểm tra xem iterator có còn phần tử tiếp theo không. 
        // Nếu còn phần tử, vòng lặp tiếp tục; nếu không, vòng lặp kết thúc
        for(coursename i = m.getIterator(); i.hasNext();){
            String coursename = (String) i.next();
            System.out.println("mon hoc: " + coursename);
        }

    }
}
