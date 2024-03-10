package dev.patika.spring.dto;

import dev.patika.spring.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private int id;
    private String name;
    private String mail;
    private Customer.GENDER gender;


}
