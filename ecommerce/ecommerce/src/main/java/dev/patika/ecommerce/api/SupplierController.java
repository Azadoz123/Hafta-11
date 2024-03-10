package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequestDto;
import dev.patika.ecommerce.dto.request.supplier.SupplierSaveRequestDto;
import dev.patika.ecommerce.dto.request.supplier.SupplierUpdateRequestDto;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponseDto;
import dev.patika.ecommerce.dto.response.supplier.SupplierResponseDto;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponseDto> get(@PathVariable("id") int id){
        Supplier supplier = this.supplierService.get(id);
        SupplierResponseDto supplierResponseDto = this.modelMapper.forResponse().map(supplier,SupplierResponseDto.class);
        return ResultHelper.suceess(supplierResponseDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<SupplierResponseDto>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize
    ){
        Page<Supplier> categoryPage = this.supplierService.cursor(page,pageSize);
        Page<SupplierResponseDto> supplierResponseDtoPage = categoryPage
                .map(supplier -> this.modelMapper.forResponse().map(supplier,SupplierResponseDto.class));

        return ResultHelper.cursor(supplierResponseDtoPage);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponseDto> save(@Valid @RequestBody SupplierSaveRequestDto supplierSaveRequestDto){
        Supplier saveSupplier = this.modelMapper.forRequest().map(supplierSaveRequestDto, Supplier.class);
        this.supplierService.save(saveSupplier);
        return  ResultHelper.created( this.modelMapper.forResponse().map(saveSupplier,SupplierResponseDto.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponseDto> update(@Valid @RequestBody SupplierUpdateRequestDto supplierUpdateRequestDto){
        Supplier updateSupplier = this.modelMapper.forRequest().map(supplierUpdateRequestDto, Supplier.class);
        this.supplierService.update(updateSupplier);
        return  ResultHelper.created( this.modelMapper.forResponse().map(updateSupplier,SupplierResponseDto.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.supplierService.delete(id);
        return ResultHelper.ok();
    }
}
