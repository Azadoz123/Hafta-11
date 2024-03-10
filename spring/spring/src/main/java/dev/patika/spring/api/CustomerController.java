package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dto.CustomerResponseDto;
import dev.patika.spring.dto.CustomerSaveRequestDto;
import dev.patika.spring.dto.CustomerUpdateRequestDto;
import dev.patika.spring.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDto> findAll(){
        /*List<Customer> customerList = this.customerService.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(
                customer -> this.customerDtoConverter.convertDto(customer)
        ).collect(Collectors.toList());*/

        List<CustomerResponseDto> customerDtoList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponseDto.class)
        ).collect(Collectors.toList());
        return customerDtoList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){
        Customer newCustomer = this.modelMapper.map(customerSaveRequestDto, Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    @PutMapping("/customers")
    public Customer update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
        Customer updatedCustomer = this.customerService.getById(customerUpdateRequestDto.getId());
                updatedCustomer.setName(customerUpdateRequestDto.getName());
                updatedCustomer.setGender(customerUpdateRequestDto.getGender());
        return this.customerService.update(updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") int id){
         this.customerService.delete(id);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDto getById(@PathVariable("id") int id){
        Customer customer = this.customerService.getById(id);
        /*
       CustomerDto customerDto = this.customerDtoConverter.convertDto(customer) ;
       return customerDto;*/

        return this.modelMapper.map(customer, CustomerResponseDto.class);
    }
}
