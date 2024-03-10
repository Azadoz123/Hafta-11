package dev.patika.spring.dto;

import dev.patika.spring.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSaveRequestDto {
    private String name;
    private String mail;
    private Customer.GENDER gender;
}
