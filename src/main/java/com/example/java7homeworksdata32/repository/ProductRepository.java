package com.example.java7homeworksdata32.repository;

import com.example.java7homeworksdata32.entity.Customer;
import com.example.java7homeworksdata32.entity.Order;
import com.example.java7homeworksdata32.model.ProductOrder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    private static String read(String scriptFileName) {
//        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
//            return bufferedReader.lines().collect(Collectors.joining("\n"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Transactional
    public List<String> getProductName(String name) {

        var result = entityManager.createQuery(
                        "select O.productName from Order O join Customer C on C.id = O.customer where lower(C.name) = :name")
                .setParameter("name", name);
        return result.getResultList();
    }

    @Transactional
    public Order addProduct(ProductOrder productOrder) {
        var findCustomer = entityManager.createQuery(
                        "select C FROM Customer C where C.phoneNumber = :phoneNumber")
                .setParameter("phoneNumber", productOrder.getCustomerPhoneNumber()).getSingleResult();

        var order = Order.builder()
                .productName(productOrder.getProductName())
                .amount(productOrder.getAmount())
                .customer((Customer) findCustomer)
                .date(Instant.now())
                .build();

       entityManager.persist(order);
       return order;
    }
}
