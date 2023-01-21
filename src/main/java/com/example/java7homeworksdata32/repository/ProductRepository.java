package com.example.java7homeworksdata32.repository;

import com.example.java7homeworksdata32.entity.Customer;
import com.example.java7homeworksdata32.entity.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final String myScriptName = "myScript.sql";
    //        private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @PersistenceContext
    private EntityManager entityManager;
//    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public ProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }


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

//    public String getProductName(String name) {
//        var arguments = new HashMap<String, String>();
//        arguments.put("name", name);
//        var result = namedParameterJdbcTemplate.queryForObject(
//                read(myScriptName),
//                arguments, (rs, rowNum) -> rs.getString("product_name"));
//        return result;
//    }

    //    public List<String> getProductName1(String name) {
//        return namedParameterJdbcTemplate.queryForList(
//                read(myScriptName), Map.of("name", name), String.class);
//
//    }
    @Transactional
    public String getProductName(String name) {
//        var result = ;
        return null;
    }

}
