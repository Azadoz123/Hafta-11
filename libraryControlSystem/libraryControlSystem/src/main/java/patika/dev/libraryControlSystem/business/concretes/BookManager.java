package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.IBookService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dao.BookBorrowingRepo;
import patika.dev.libraryControlSystem.dao.BookRepo;
import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.Publisher;

@RequiredArgsConstructor
@Service
public class BookManager implements IBookService {

    private final BookRepo bookRepo;
    private final AuthorManager authorManager;
    private final PublisherManager publisherManager;
    private final ModelMapperManager modelMapper;
    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public BookResponseDto save(BookSaveRequestDto bookSaveRequestDto) {
        Book book = this.modelMapper.forRequest().map(bookSaveRequestDto, Book.class);
        Author author = this.authorManager.get(bookSaveRequestDto.getAuthorId());
        book.setAuthor(author);
        Publisher publisher = this.publisherManager.get(bookSaveRequestDto.getPublisherId());
        book.setPublisher(publisher);
        Book savedBook = this.save(book);
        return this.convertBookToBookDto(savedBook);
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow(()->new RuntimeException("BookId(" +id + ") mevcut değil."));
    }

    @Override
    public BookResponseDto convertBookToBookDto(Book book) {
        BookResponseDto bookResponseDto = this.modelMapper.forResponse().map(book,BookResponseDto.class);;
        return bookResponseDto;
    }

    @Override
    public BookResponseDto getAsBookResponseDto(int id) {
        Book book = this.get(id);
        return convertBookToBookDto(book);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public BookResponseDto update(BookUpdateRequestDto bookUpdateRequestDto) {
        Book book = this.modelMapper.forRequest().map(bookUpdateRequestDto, Book.class);
        Author author = this.authorManager.get(bookUpdateRequestDto.getAuthorId());
        book.setAuthor(author);
        Publisher publisher = this.publisherManager.get(bookUpdateRequestDto.getPublisherId());
        book.setPublisher(publisher);
        Book updateBook = this.update(book);
        BookResponseDto bookResponseDto = this.modelMapper.forResponse().map(updateBook,BookResponseDto.class);
        return bookResponseDto;
    }

    @Override
    public boolean delete(int id) {
        this.bookRepo.delete(this.get(id));
        return true;
    }
}
