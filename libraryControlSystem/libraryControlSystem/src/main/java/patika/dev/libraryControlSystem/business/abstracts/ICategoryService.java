package patika.dev.libraryControlSystem.business.abstracts;

import patika.dev.libraryControlSystem.dto.request.category.CategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.category.CategoryUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.category.CategoryResponseDto;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.Category;

public interface ICategoryService {
    Category save(Category category);
    CategoryResponseDto save(CategorySaveRequestDto categorySaveRequestDto);
    Category get(int id);
    public CategoryResponseDto convertCategoryToCategoryDto(Category category);
    CategoryResponseDto getAsCategoryResponseDto(int id);
    Category update(Category category);
    CategoryResponseDto update(CategoryUpdateRequestDto categoryUpdateRequestDto);
    String delete(int id);
}
