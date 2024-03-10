package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.IBookCategoryService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategoryDeleteRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.response.bookCategory.BookCategoryResponseDto;
import patika.dev.libraryControlSystem.entitties.Book;
import patika.dev.libraryControlSystem.entitties.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookCategoryManager implements IBookCategoryService {

    private final BookManager bookManager;
    private final CategoryManager categoryManager;
    private final ModelMapperManager modelMapper;
    @Override
    public BookCategoryResponseDto save(BookCategorySaveRequestDto bookCategorySaveRequestDto) {
        BookCategoryResponseDto bookCategoryResponseDto = null;
        Book book = this.bookManager.get(bookCategorySaveRequestDto.getBookId());
        Category category = this.categoryManager.get(bookCategorySaveRequestDto.getCategoryId());

        List<Category> categoryList = book.getCategoryList();
        List<Category> categoryFilterList = categoryList.stream().filter(categoryFilter -> categoryFilter.getId() == bookCategorySaveRequestDto.getCategoryId())
                .collect(Collectors.toList());

        if (categoryFilterList.isEmpty()){
            categoryList.add(category);
            book.setCategoryList(categoryList);
            this.bookManager.update(book);
            bookCategoryResponseDto = this.modelMapper.forResponse().map(bookCategorySaveRequestDto, BookCategoryResponseDto.class);
        }

         return bookCategoryResponseDto;
    }

    @Override
    public List<BookCategoryResponseDto>  get(int categoryId) {
        Category category = this.categoryManager.get(categoryId);
        List<Book> bookList = category.getBookList();
        List<BookCategoryResponseDto> bookCategoryResponseDtoList = new ArrayList<>();
        for (Book book : bookList){
            bookCategoryResponseDtoList.add(new BookCategoryResponseDto(categoryId,book.getId()){});
        }

        return bookCategoryResponseDtoList;
    }

    @Override
    public boolean delete(BookCategoryDeleteRequestDto bookCategoryDeleteRequestDto) {
        Book book = this.bookManager.get(bookCategoryDeleteRequestDto.getBookId());
        List<Category> categoryList = book.getCategoryList();
        List<Category> categoryListFilter = categoryList.stream().filter(category -> category.getId() != bookCategoryDeleteRequestDto.getCategoryId())
                .collect(Collectors.toList());
        book.setCategoryList(categoryListFilter);
        this.bookManager.update(book);
        return true;
    }
}
