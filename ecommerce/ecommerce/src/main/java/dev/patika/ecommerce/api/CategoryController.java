package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequestDto;
import dev.patika.ecommerce.dto.request.category.CategoryUpdateRequestDto;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponseDto;
import dev.patika.ecommerce.entities.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponseDto> save(@Valid @RequestBody CategorySaveRequestDto categorySaveRequestDto){
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequestDto, Category.class);
        this.categoryService.save(saveCategory);

        CategoryResponseDto categoryResponseDto = this.modelMapper.forResponse().map(saveCategory,CategoryResponseDto.class);
       return  ResultHelper.created(categoryResponseDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponseDto> get(@PathVariable("id") int id){
        Category category = this.categoryService.get(id);
        CategoryResponseDto categoryResponseDto = this.modelMapper.forResponse().map(category,CategoryResponseDto.class);
        return ResultHelper.suceess(categoryResponseDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponseDto>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize
    ){
        Page<Category> categoryPage = this.categoryService.cursor(page,pageSize);
        Page<CategoryResponseDto> categoryResponseDtoPage = categoryPage
                .map(category -> this.modelMapper.forResponse().map(category,CategoryResponseDto.class));

        return ResultHelper.cursor(categoryResponseDtoPage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponseDto> update(@Valid @RequestBody CategoryUpdateRequestDto categoryUpdateRequest){

        Category updateCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);

        CategoryResponseDto categoryResponseDto = this.modelMapper.forResponse().map(updateCategory,CategoryResponseDto.class);
        return  ResultHelper.suceess(categoryResponseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }
}
