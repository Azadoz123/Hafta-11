package dev.patika.ecommerce.dto.response.product;

import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;
}
