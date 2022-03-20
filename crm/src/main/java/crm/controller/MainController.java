package crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crm.dao.CustomerDao;
import crm.model.Customer;

@Controller
public class MainController {
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Customer> customers = customerDao.getCustomers();
		m.addAttribute("customers", customers);
		return "index";
	}
	
	//show add customer form
	@RequestMapping("/add-customer")
	public String addCustomer(Model m) {
		m.addAttribute("title", "Add Customer");
		return "add_customer_form";
	}

	//handle add customer form
	@RequestMapping(value="/handle-customer",method = RequestMethod.POST)
	public RedirectView handleCustomer(@ModelAttribute Customer customer,HttpServletRequest request) {
		System.out.println(customer);
		this.customerDao.createCustomer(customer);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//delete handler
	@RequestMapping("/delete/{cid}")
	public RedirectView deleteCustomer(@PathVariable("cid") int cid,HttpServletRequest request) {
		this.customerDao.deleteCustomer(cid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//update handler
	@RequestMapping("/update/{cid}")
	public String updateForm(@PathVariable("cid") int cid,Model model) {
		Customer customer = this.customerDao.getCustomer(cid);
		model.addAttribute("customer", customer);
		return "update_form";
	}
}
