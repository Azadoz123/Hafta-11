package dev.patika.spring.dto;

import dev.patika.spring.entities.Customer;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequestDto {
    private int id;
    private String name;
    private Customer.GENDER gender;
}
