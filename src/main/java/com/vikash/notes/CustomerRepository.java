//package com.vikash.notes;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CustomerRepository
//        extends JpaRepository<Customer, Integer> {
//
//    @Query(nativeQuery = true, value = "SELECT * FROM customer order by name")
//    public List<Customer> findCustomerSortedByName();
//
//}
