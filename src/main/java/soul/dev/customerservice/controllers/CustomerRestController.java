package soul.dev.customerservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soul.dev.customerservice.Dtos.CustomerDto;
import soul.dev.customerservice.entities.Customer;
import soul.dev.customerservice.exceptions.EmailExistedException;
import soul.dev.customerservice.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        try {
            return customerService.createCustomer(customerDto);
        } catch (EmailExistedException e) {
            throw new RuntimeException(e);
        }
    }
}
