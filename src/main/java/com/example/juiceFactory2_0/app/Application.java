package com.example.juiceFactory2_0.app;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(new Date()));
        System.out.println(LocalDate.now());
        int min = 2000; // Minimum value of range
        int max = 9999; // Maximum value of range
        // Print the min and max
        System.out.println("Random value in int from "+ min + " to " + max + ":");
        // Generate random int value from min to max
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        // Printing the generated random numbers
        System.out.println(random_int);
//        JPAConfiguration.getEntityManager();
//        CustomerDAO customerDAO = new CustomerDAO(JPAConfiguration.getEntityManager());
//        OrderDAO orderDAO = new OrderDAO(JPAConfiguration.getEntityManager());
//        OrderStatusDAO orderStatusDAO = new OrderStatusDAO(JPAConfiguration.getEntityManager());
//        ProductDAO productDAO = new ProductDAO(JPAConfiguration.getEntityManager());
//        InvoiceDAO invoiceDAO = new InvoiceDAO(JPAConfiguration.getEntityManager());
//        PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO(JPAConfiguration.getEntityManager());
//        OrderProductDAO orderProductDAO = new OrderProductDAO(JPAConfiguration.getEntityManager());


        /*Customer customer1 = new Customer();
        customer1.setCustomerNumber(6001L);
        customer1.setName("Henk Fitz");
        customer1.setAddress("Jacobkondrestraat 23");
        customer1.setDistrict("Paramaribo");
        customer1.setPhoneNumber("+597 8906054");
        customer1.setDateRegistered(LocalDate.now());

        Customer insert1 = customerDAO.insert(customer1);
        System.out.println(insert1);

        OrderStatus processingStatus = new OrderStatus();
        processingStatus.setOrderState("Processing");

        OrderStatus insert2 = orderStatusDAO.insert(processingStatus);
        System.out.println(insert2);

        Product orangeJuice = new Product();
        orangeJuice.setProductCode("J31101");
        orangeJuice.setProductName("Orange");
        orangeJuice.setProductDescription("Freshly squeezed orange!");
        orangeJuice.setTypeOfProduct("Juice");
        orangeJuice.setExpireDate(LocalDate.of(2022, 6, 3));
        orangeJuice.setProductionDate(LocalDate.of(2022, 3, 3));

        Product appleJuice = new Product();
        appleJuice.setProductCode("J31102");
        appleJuice.setProductName("Apple");
        appleJuice.setProductDescription("Freshly squeezed apple!");
        appleJuice.setTypeOfProduct("Juice");
        appleJuice.setExpireDate(LocalDate.of(2022, 6, 3));
        appleJuice.setProductionDate(LocalDate.of(2022, 3, 3));

        Product insert3 = productDAO.insert(orangeJuice);
        Product insert4 = productDAO.insert(appleJuice);
        System.out.println(insert3);
        System.out.println(insert4);


        Order order1 = new Order();
        order1.setOrderNumber("TS001");
        order1.setCustomer(customer1);
//        order1.setProductsBought(Set.of(orangeJuice, appleJuice));
//        order1.setQuantity(1L);
//        order1.setTotalPrice(25.50);
        order1.setInvoice(invoice1);
        order1.setOrderDate(LocalDate.now());
        order1.setDeliveryDate(LocalDate.of(2022, 3, 15));
        order1.setOrderStatus(processingStatus);

        Order insert5 = orderDAO.insert(order1);


        System.out.println(insert5);*/

//        Customer customer1 = new Customer();
//        customer1.setCustomerNumber(6010L);
//        customer1.setName("Earl Tjon");
//        customer1.setAddress("Ringweg 462");
//        customer1.setDistrict("Paramaribo");
//        customer1.setPhoneNumber("+597 8692460");
//        customer1.setDateRegistered(LocalDate.now());
//        Customer insert1 = customerDAO.insert(customer1);
//        System.out.println(insert1);

       // customerDAO.updateCustomer(customer1);
//        customerDAO.delete(6010L);



//        System.out.println(customerDAO.retrieveCustomerList());
//        System.out.println(productDAO.findProductByProductCode("J31102"));

//        PaymentMethod paymentMethod1 = new PaymentMethod();
//        paymentMethod1.setPaymentMethodName("Mobile Banking");
//
//        Invoice invoice1 = new Invoice();
//        invoice1.setInvoice_method(Set.of(paymentMethod1));
//        invoice1.setTotalPrice(350.00);


//        PriceAdapter priceAdapter1 = new PriceAdapter("TS002", 20.75);
//        priceAdapter1.convertToUSD();
//
//        System.out.println();
//
//        System.out.println(invoiceDAO.findByOrderNumber("TS002"));


        /*TransportFactory tpf = new TransportFactory();

        Transport tp = tpf.getInstance(customerDAO.findByCustomerNumber(6001L));
        System.out.println(tp.deliver());

        CashStrategy cs = new CashStrategy();
        cs.pay(invoiceDAO.findByOrderNumber("TS002"));
        System.out.println(cs);*/

//        System.out.println(orderDAO.retrieveOrderList());
//        System.out.println(orderDAO.findByOrderNumber("TS002"));
//        System.out.println(orderDAO.findOrderDateByQuarter(LocalDate.of(2022, 10, 1)));
//        System.out.println(orderDAO.findOrderDateByMonth(2022));
//        System.out.println(orderDAO.mostFrequentCustomer());
//        System.out.println(orderProductDAO.mostFrequentBoughtProduct());

//        orderDAO.findOrderDateByMonth(2021);

        JPAConfiguration.shutdown();

//        Graph graph = new Graph();
//        graph.addVertex(customer1);
//        graph.displayVertexName(0);
    }

}
