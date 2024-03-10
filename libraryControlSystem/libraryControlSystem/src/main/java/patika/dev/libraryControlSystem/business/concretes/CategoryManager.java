package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.ICategoryService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dao.BookRepo;
import patika.dev.libraryControlSystem.dao.CategoryRepo;
import patika.dev.libraryControlSystem.dto.request.category.CategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.category.CategoryUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.category.CategoryResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.Category;
import patika.dev.libraryControlSystem.entitties.Publisher;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;
    private final BookManager bookManager;
    private final ModelMapperManager modelMapper;
    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public CategoryResponseDto save(CategorySaveRequestDto categorySaveRequestDto) {
        Category category = this.modelMapper.forRequest().map(categorySaveRequestDto, Category.class);
        Category savedCategory = this.save(category);
        return this.convertCategoryToCategoryDto(savedCategory);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(()->new RuntimeException("CategoryId(" +id + ") mevcut değil."));
    }

    @Override
    public CategoryResponseDto getAsCategoryResponseDto(int id) {

        return convertCategoryToCategoryDto(this.get(id));
    }
    public CategoryResponseDto convertCategoryToCategoryDto(Category category) {
        CategoryResponseDto categoryResponseDto = this.modelMapper.forResponse().map(category,CategoryResponseDto.class);;
        return categoryResponseDto;
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public CategoryResponseDto update(CategoryUpdateRequestDto categoryUpdateRequestDto) {
        Category category = this.modelMapper.forRequest().map(categoryUpdateRequestDto, Category.class);
        Category savedCategory = this.update(category);
        return this.convertCategoryToCategoryDto(savedCategory);
    }

    @Override
    public String delete(int id) {
        Category category = this.get(id);
        List<Book> bookList =  category.getBookList();
        if(bookList.isEmpty()){
            this.categoryRepo.delete(this.get(id));
        }else {
            return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
        }

        return "Kategoeri silindi.";
    }
}
