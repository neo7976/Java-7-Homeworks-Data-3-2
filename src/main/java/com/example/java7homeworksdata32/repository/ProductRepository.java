package com.example.java7homeworksdata32.repository;

import com.example.java7homeworksdata32.entity.Customer;
import com.example.java7homeworksdata32.entity.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final String myScriptName = "myScript.sql";
    //        private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @PersistenceContext
    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void productForOrders() {
//        var dateOrder = dtf.format(LocalDate.now());
        var customer = entityManager.find(Customer.class, 2);
        System.out.println(customer);
        var order = Order.builder()
                .amount(10)
                .productName("Молоко")
                .date(Date.valueOf(LocalDate.now()))
//                .date(Date.valueOf(dateOrder))
                .customer(customer)
                .build();

        entityManager.persist(order);
    }

    @Transactional
    public List<String> getProductName(String name) {

        var result = entityManager.createQuery(
                "select O.productName from Order O join Customer C on C.id = O.customer where lower(C.name) = :name")
                .setParameter("name", name);
        return result.getResultList();
    }

}
