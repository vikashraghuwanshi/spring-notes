package com.vikash.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@CrossOrigin
@RestController
@RequestMapping("api/v1/customers/")
public class NotesApplication {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/sorted")
	public List<Customer> getCustomerDetailsSortedByName() {
		return customerRepository.findCustomerSortedByName();
	}

	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	) {}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest newCustomerRequest) {
		Customer customer = new Customer();
		customer.setName(newCustomerRequest.name);
		customer.setEmail(newCustomerRequest.email);
		customer.setAge(newCustomerRequest.age);
		customerRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		customerRepository.deleteById(id);
	}

	@PutMapping("{customerId}")
	public void updateCustomer(@PathVariable("customerId") Integer id,
							   @RequestBody NewCustomerRequest updateCustomerRequest) {
		Optional<Customer> customerFromDb = customerRepository.findById(id);

		if(customerFromDb.isPresent()) {
			customerFromDb.get().setNew(false);
			customerFromDb.get().setName(updateCustomerRequest.name);
			customerFromDb.get().setEmail(updateCustomerRequest.email);
			customerFromDb.get().setAge(updateCustomerRequest.age);
			customerRepository.save(customerFromDb.get());
		}

	}
}

