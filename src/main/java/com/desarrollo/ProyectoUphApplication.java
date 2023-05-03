package com.desarrollo;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoUphApplication {

	private static CustomerService customerService;

	public ProyectoUphApplication(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {



		SpringApplication.run(ProyectoUphApplication.class, args);
		AddressDomain addressDomain = new AddressDomain();
		CustomerDomain customerDomain = new CustomerDomain();

		addressDomain.setCity("Madrid");
		addressDomain.setProvince("Madrid");
		addressDomain.setStreet("Pablo");
		addressDomain.setCodePostal("28947");
		addressDomain.setNumberStreet("4 piso Bj");
		addressDomain.setDescription("Frente a edificio");

		customerDomain.setName("Yimy");
		customerDomain.setSurname("Zepeda");
		customerDomain.setDni("Y6936130C");
		customerDomain.setMobile("632877608");
		customerDomain.setAddressDomain(addressDomain);

		customerService.save(customerDomain);

	}


}
