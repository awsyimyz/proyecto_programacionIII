package com.desarrollo.application.rest;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        customerService.save(customers);
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{id}")
    public String updateFormEdit(@PathVariable int id, Model model){
       model.addAttribute("customers",customerService.getById(id));
       return "edit_customer";
    }

    @PostMapping("/customer/{id}")
    public String updateCustomer(@PathVariable int id,@ModelAttribute("customers")CustomerDomain newCustomer,Model model){
        CustomerDomain oldCustomer = customerService.getById(id);
        getCustomerUpdate(oldCustomer,newCustomer);
        customerService.save(oldCustomer);
        //customerService.save(oldCustomer.getAddress());
        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.delete(id);
        return "redirect:/customer";
    }

    private void getCustomerUpdate(CustomerDomain oldCustomer, CustomerDomain newCustomer){
        oldCustomer.setId(newCustomer.getId());
        oldCustomer.setName(oldCustomer.getName());
        oldCustomer.setSurname(oldCustomer.getSurname());
        oldCustomer.setMobile(newCustomer.getMobile());
        oldCustomer.setDni(oldCustomer.getDni());
        oldCustomer.setAddress(getAddressUpdate(oldCustomer.getAddress(),newCustomer.getAddress()));
    }

    private AddressDomain getAddressUpdate(AddressDomain oldAddress,AddressDomain newAddress){
        oldAddress.setId(newAddress.getId());
        oldAddress.setDescription(newAddress.getDescription());
        oldAddress.setStreet(newAddress.getStreet());
        oldAddress.setCity(newAddress.getCity());
        oldAddress.setProvince(newAddress.getProvince());
        oldAddress.setCodePostal(newAddress.getCodePostal());
        return oldAddress;
    }
}
