package patika.dev.libraryControlSystem.business.abstracts;

import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.category.CategoryResponseDto;
import patika.dev.libraryControlSystem.dto.response.publisher.PublisherResponseDto;
import patika.dev.libraryControlSystem.entitties.Category;
import patika.dev.libraryControlSystem.entitties.Publisher;

public interface IPublisherService {
    Publisher save(Publisher publisher);
    PublisherResponseDto save(PublisherSaveRequestDto publisherSaveRequestDto);
    Publisher get(int id);
    public PublisherResponseDto convertPublisherToPublisherDto(Publisher publisher);
    PublisherResponseDto getAsPublisherResponseDto(int id);
    Publisher update(Publisher publisher);
    PublisherResponseDto update(PublisherUpdateRequestDto publisherUpdateRequestDto);
    boolean delete(int id);
}
