package com.desarrollo.application.rest;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping({"/customer","/"})
    public String listarCustomer(Model model){
        model.addAttribute("customer",customerService.getAll());
        return "customer";
    }

    @GetMapping({"/customer/new"})
    public String createCustomerForm(Model model){
        AddressDomain addressDomain = AddressDomain.builder().build();
        CustomerDomain customers= CustomerDomain.builder().build();
        customers.setAddress(addressDomain);
        model.addAttribute("customers",customers);
        return "create_customer";
    }

    @PostMapping("/customer")
    public String saveCustomer(@ModelAttribute("customers") CustomerDomain customers){
        AddressDomain addressDomain = AddressDomain.builder().build();
        customers.setAddress(addressDomain);
        customerService.save(customers);
        return "redirect:/customer";
    }
}
