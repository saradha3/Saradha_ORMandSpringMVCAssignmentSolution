package crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crm.model.Customer;

@Component
public class CustomerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create customer
	@Transactional
	public void createCustomer(Customer customer) {
		this.hibernateTemplate.saveOrUpdate(customer);
	}
	
	//get all customers
	public List<Customer> getCustomers(){
		List<Customer> customers = this.hibernateTemplate.loadAll(Customer.class);
		return customers;
	}
	
	//delete single customer
	@Transactional
	public void deleteCustomer(int cid) {
		Customer c = this.hibernateTemplate.load(Customer.class, cid);
		this.hibernateTemplate.delete(c);
	}
	
	//get single customer
	public Customer getCustomer(int cid) {
		return this.hibernateTemplate.get(Customer.class, cid);
	}

}
