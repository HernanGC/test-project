package com.utec.backend.service;

import com.utec.backend.dto.BookRequestDTO;
import com.utec.backend.dto.BookResponseDTO;
import com.utec.backend.model.Book;
import com.utec.backend.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequest) {
        log.info("Creating book with title {} and author {}", bookRequest.getTitle(), bookRequest.getAuthor());
        Book book = this.bookRepository.save(bookRequest.toBook());
        return book.toBookResponseDTO();
    }

    @Override
    public BookResponseDTO getBookById(Integer id) {
        return this.bookRepository.getReferenceById(id).toBookResponseDTO();
    }
}
