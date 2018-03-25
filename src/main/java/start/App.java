package start;

import context.HibernateUtil;
import data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        /*Select*/
        List<User> list = session.createSQLQuery("select * from user").list();
        /*Insert*/
        session.beginTransaction();
        User user = new User();
        user.setAge(20);
        user.setName("TestName - V2");
        session.save(user);
        session.getTransaction().commit();
        /*Update*/
        session.beginTransaction();
        User userUpdate = new User();
        userUpdate.setId(2l);
        userUpdate.setAge(20);
        userUpdate.setName("TestName - V3 - Update");
        session.update(userUpdate);
        session.getTransaction().commit();
        /*Delete*/


    }
}
