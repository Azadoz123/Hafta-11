package patika.dev.libraryControlSystem.business.abstracts;

import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategoryDeleteRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookCategory.BookCategoryResponseDto;
import patika.dev.libraryControlSystem.entitties.Book;

import java.util.List;

public interface IBookCategoryService {
    BookCategoryResponseDto save(BookCategorySaveRequestDto bookCategorySaveRequestDto);
    List<BookCategoryResponseDto>  get(int categoryId);
    boolean delete(BookCategoryDeleteRequestDto bookCategoryDeleteRequestDto);
}
