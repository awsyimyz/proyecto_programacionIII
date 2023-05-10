package com.desarrollo.application.rest;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.model.CustomerDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        CustomerDomain customers= CustomerDomain.builder().build();
        model.addAttribute("customers",customers);
        return "create_customer";
    }
}
