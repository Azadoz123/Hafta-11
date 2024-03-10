package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.business.abstracts.IProductService;
import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.product.ProductSaveRequestDto;
import dev.patika.ecommerce.dto.request.supplier.SupplierSaveRequestDto;
import dev.patika.ecommerce.dto.response.category.CategoryResponseDto;
import dev.patika.ecommerce.dto.response.product.ProductResponseDto;
import dev.patika.ecommerce.dto.response.supplier.SupplierResponseDto;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final IProductService productService;
    private final IModelMapperService modelMapper;
    private final ICategoryService categoryService;
    private final ISupplierService supplierService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponseDto> save(@Valid @RequestBody ProductSaveRequestDto productSaveRequestDto){
        Product saveProduct = this.modelMapper.forRequest().map(productSaveRequestDto, Product.class);

        Category category = this.categoryService.get(productSaveRequestDto.getCategoryId());
        saveProduct.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequestDto.getSupplierId());
        saveProduct.setSupplier(supplier);

        this.productService.save(saveProduct);
        return  ResultHelper.created( this.modelMapper.forResponse().map(saveProduct,ProductResponseDto.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponseDto> get(@PathVariable("id") int id){
        Product product = this.productService.get(id);
        ProductResponseDto productResponseDto = this.modelMapper.forResponse().map(product,ProductResponseDto.class);
        return ResultHelper.suceess(productResponseDto);
    }

    @GetMapping("/{id}/supplier")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponseDto> getSupplier(@PathVariable("id") int id){
        Product product = this.productService.get(id);
        SupplierResponseDto supplierResponseDto = this.modelMapper.forResponse().map(product.getSupplier(),SupplierResponseDto.class);
        return ResultHelper.suceess(supplierResponseDto);
    }
}
