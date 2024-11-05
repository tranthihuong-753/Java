public class FullBasic{
    public static void main(String[] args) {
        run_class_generic();
        run_print_generic_method();
        rn_generic_interface();
    }
    // Generic <1> 
    static class class_generic<t>{
        private t bien1;
        public void set_bien1(t a){
            this.bien1 = a;
        }
        public t get_bien1(){
            return bien1;
        }
        public void print_bien1(){
            System.out.println("-> " + bien1);
        }
    }
    static void run_class_generic(){
        // KDL generic la string 
        class_generic<String> cs = new class_generic<>();
        cs.set_bien1("hello my love");
        cs.print_bien1();

        // KDL generic la double 
        class_generic<Double> csd = new class_generic<>();
        csd.set_bien1(19.20);
        csd.print_bien1();       
    }
    // generic method <2> 
    static <t> void print_generic_method(t bien){
        System.out.println(bien);
    }
    static void run_print_generic_method(){
        print_generic_method("hello my love");
        print_generic_method(12.09);
    }
    // Generic interface <3> 
    static interface inter_generic<t>{
        void print(t bien);
    }
    static class huong<t> implements inter_generic<t>{    
        @Override
        public void print(t bien){
            System.out.println(bien);
        }
    }
    static void rn_generic_interface(){
        inter_generic<String> ig = new huong<>();
        ig.print("hello babiiii");
    }
    // Collection array 
    
}