/*
package test;

interface bear{
    void color(String color_bear);
}
class bear_action implements bear{
    public bear_action() {
        
    }
    @Override
    public void color(String color_bear) {
        System.out.println("Gấu có màu lông " + color_bear);
    }
}

public class a_LopVoDanh {
    public static void main(String[] args) {
        bear b = new bear_action();
        b.color("đỏ"); // Gấu có màu lông đỏ
    }
}
*/

package test;

interface bear{
    void color(String color_bear);
}

public class a_LopVoDanh {
    public static void main(String[] args) {
        bear b = new bear() {
            String color_bear = "đỏ";
            
            @Override
            public void color(String color_bear) {
                System.out.println("Gấu có màu lông " + color_bear);
            }
        };
        b.color("trắng"); //Gấu có màu lông trắng
    }
}