package patika.dev.libraryControlSystem.business.abstracts;

import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookBorrowing.BookBorrowingResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookCategory.BookCategoryResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.BookBorrowing;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    String save(BookBorrowingSaveRequestDto bookBorrowingSaveRequestDto);
    BookBorrowing get(int id);
    BookBorrowingResponseDto convertBookBorrowingToBookBorrowingDto(BookBorrowing bookBorrowing);
    BookBorrowingResponseDto getAsBookBorrowingResponseDto(int id);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowingResponseDto update(BookBorrowingUpdateRequestDto bookBorrowingUpdateRequestDto);
    boolean delete(int id);
}
