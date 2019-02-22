package io.alphadevs.services;

import io.alphadevs.data.dao.Page;
import io.alphadevs.data.dao.StudentDao;
import io.alphadevs.data.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MainService {
    @PostConstruct
    void init(){
        System.out.println("initialised");
    }


    @Autowired
    StudentDao studentDao;

    @Autowired
    private SessionFactory sessionFactory;


    public Student createStudent(String name, Integer age){
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentDao.persist(student);
        transaction.commit();
        return student;
    }

    public List<Student> fetchStudents() {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        List<Student> students = studentDao.fetchAll("from Student", new Page(0, 100));
        transaction.commit();
        return students;
    }

    @Cacheable(value = "defaultCache", key = "#key")
    public String cachedValue(String key) {
        System.out.println("I'm inside here");
        return "Hello World";
    }
}
