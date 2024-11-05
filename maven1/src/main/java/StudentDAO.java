import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    private SessionFactory sessionFactory;
    public StudentDAO(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public void createStudent(String name, int age){
        try{
            Session session = sessionFactory.openSession(); // mo phien giao dich 
            Transaction transaction = session.beginTransaction();
            Student student = new Student(name, age);
            session.save(student);
            transaction.commit();
            session.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public Student readStudent(Long id){
        Session session = sessionFactory.openSession(); // mo phien giao dich 
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }    
    public void updateStudent(Long id, String newname, int newage){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if(student != null){
            student.setName(newname);
            student.setYear(newage);
            session.update(student);
        }
        transaction.commit();
        session.close();
    }
    public void deleteStudent(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if(student != null){
            session.delete(student);
        }
        transaction.commit();
        session.close();        
    }
    public void closeSessionFactory(){
        sessionFactory.close();
    }
}
