package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction ;
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users" +
                    "(id mediumint not null auto_increment," +
                    " name VARCHAR(45), " +
                    "lastname VARCHAR(45), " +
                    "age tinyint, " +
                    "PRIMARY KEY (id))").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        Session session = Util.getSessionFactory().openSession();
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("Drop table if exists users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction ;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user=new User();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction ;
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users where id").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = new ArrayList<>();
        return allUser;
    }

    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction ;
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}