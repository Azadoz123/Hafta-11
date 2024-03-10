package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.IBookBorrowingService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dao.AuthorRepo;
import patika.dev.libraryControlSystem.dao.BookBorrowingRepo;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookBorrowing.BookBorrowingResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.BookBorrowing;

@RequiredArgsConstructor
@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepo bookBorrowingRepo;
    private final BookManager bookManager;
    private final ModelMapperManager modelMapper;
    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public String save(BookBorrowingSaveRequestDto bookBorrowingSaveRequestDto) {
        Book book = this.bookManager.get(bookBorrowingSaveRequestDto.getBookId());
        if (book.getStock() > 0){
            BookBorrowing bookBorrowing = this.modelMapper.forRequest().map(bookBorrowingSaveRequestDto, BookBorrowing.class);
            bookBorrowing.setBook(book);
            book.setStock(book.getStock() - 1);
            this.bookManager.update(book);
            BookBorrowing savedBookBorrowing = this.save(bookBorrowing);
            return "Kitap ödünç alındı";
        }
        return "Stok bulunmadığı için kitap ödünç alınmadı.";
    }

    @Override
    public BookBorrowing get(int id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow(()->new RuntimeException("BookBorrowingId(" +id + ") mevcut değil."));
    }

    @Override
    public BookBorrowingResponseDto convertBookBorrowingToBookBorrowingDto(BookBorrowing bookBorrowing) {
        BookBorrowingResponseDto bookBorrowingResponseDto = this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponseDto.class);;
        return bookBorrowingResponseDto;
    }

    @Override
    public BookBorrowingResponseDto getAsBookBorrowingResponseDto(int id) {
        BookBorrowing bookBorrowing = this.get(id);
        return convertBookBorrowingToBookBorrowingDto(bookBorrowing);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowingResponseDto update(BookBorrowingUpdateRequestDto borrowingUpdateRequestDto) {
        BookBorrowing updateBookBorrwing = this.modelMapper.forRequest().map(borrowingUpdateRequestDto, BookBorrowing.class);
        Book book = this.bookManager.get(borrowingUpdateRequestDto.getBookId());
        updateBookBorrwing.setBook(book);
        this.update(updateBookBorrwing);
        BookBorrowingResponseDto bookBorrowingResponseDto = this.modelMapper.forResponse().map(updateBookBorrwing,BookBorrowingResponseDto.class);
        return bookBorrowingResponseDto;
    }

    @Override
    public boolean delete(int id) {
        this.bookBorrowingRepo.delete(this.get(id));
        return true;
    }
}
