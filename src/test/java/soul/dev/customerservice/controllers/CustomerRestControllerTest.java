package soul.dev.customerservice.controllers;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import soul.dev.customerservice.Dtos.CustomerDto;
import soul.dev.customerservice.exceptions.EmailExistedException;
import soul.dev.customerservice.service.CustomerService;
import soul.dev.customerservice.service.CustomerServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerRestControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerRestController underTest;


    @Test
    void createCustomerPostReq() throws EmailExistedException {
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("soulaiman").lastName("ghailan").email("soulaiman@gmail.com").build() ;
        CustomerDto expectedCustomerDto = CustomerDto.builder()
                .firstName("soulaiman").lastName("ghailan").email("soulaiman@gmail.com").build() ;

        Mockito.when(customerService.createCustomer(customerDto)).thenReturn(customerDto) ;

        CustomerDto result = underTest.createCustomer(customerDto) ;
        AssertionsForClassTypes.assertThat(result).isNotNull() ;
        AssertionsForClassTypes.assertThat(result.getId() != null) ;
        AssertionsForClassTypes.assertThat(expectedCustomerDto).isEqualTo(result) ;


    }

}