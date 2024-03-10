package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.IPublisherService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dao.CategoryRepo;
import patika.dev.libraryControlSystem.dao.PublisherRepo;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.category.CategoryResponseDto;
import patika.dev.libraryControlSystem.dto.response.publisher.PublisherResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Category;
import patika.dev.libraryControlSystem.entitties.Publisher;

@RequiredArgsConstructor
@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepo publisherRepo;
    private final ModelMapperManager modelMapper;
    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public PublisherResponseDto save(PublisherSaveRequestDto publisherSaveRequestDto) {
        Publisher publisher = this.modelMapper.forRequest().map(publisherSaveRequestDto, Publisher.class);
        Publisher savedPublisher = this.save(publisher);
        return this.convertPublisherToPublisherDto(savedPublisher);
    }

    @Override
    public Publisher get(int id) {
        return this.publisherRepo.findById(id).orElseThrow(()->new RuntimeException("PublisherId(" +id + ") mevcut değil."));
    }

    @Override
    public PublisherResponseDto convertPublisherToPublisherDto(Publisher publisher) {
        PublisherResponseDto publisherResponseDto = this.modelMapper.forResponse().map(publisher,PublisherResponseDto.class);;
        return publisherResponseDto;
    }

    @Override
    public PublisherResponseDto getAsPublisherResponseDto(int id) {
        return this.convertPublisherToPublisherDto(this.get(id));
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public PublisherResponseDto update(PublisherUpdateRequestDto publisherUpdateRequestDto) {
        Publisher publisher = this.modelMapper.forRequest().map(publisherUpdateRequestDto, Publisher.class);
        Publisher savedPublisher = this.update(publisher);
        return this.convertPublisherToPublisherDto(savedPublisher);
    }

    @Override
    public boolean delete(int id) {
        this.publisherRepo.delete(this.get(id));
        return true;
    }
}
