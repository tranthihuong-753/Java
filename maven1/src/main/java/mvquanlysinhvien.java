
public class mvquanlysinhvien {
    public static void main(String[] args) {
        StudentDAO stdao = new StudentDAO();
        
        // Tao 1 sinh vien 
        stdao.createStudent("Ngo Tat To", 99);
        
        // connect 
        stdao.closeSessionFactory();
        System.out.println("Insert thanh cong");
    }
}

/*
HibernateUtil.java
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
        
public class HibernateUtil {
    private static SessionFactory sesstionFactory;
    static{
        try{
            sesstionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
                System.out.println(ex.toString());
                throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSesstionFactory() {
        return sesstionFactory;
    }

    public static void setSesstionFactory(SessionFactory sesstionFactory) {
        HibernateUtil.sesstionFactory = sesstionFactory;
    }   
}

*/