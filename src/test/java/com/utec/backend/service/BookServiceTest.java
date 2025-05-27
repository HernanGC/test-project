package com.utec.backend.service;

import com.utec.backend.dto.BookResponseDTO;
import com.utec.backend.model.Book;
import com.utec.backend.repository.BookRepository;
import com.utec.backend.dto.BookRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;
    
    @Test
    public void testCreateBook() {
        // Arrange
        BookRequestDTO bookRequest = this.provideBookRequestDTO();
        BookResponseDTO expectedBookResponse = this.provideBookResponseDTO();
        Book book = this.provideBookResponseDTOWithNullId();
        when(this.bookRepository.save(any(Book.class))).thenReturn(book);
        
        // Act
        BookResponseDTO bookResponse = this.bookService.createBook(bookRequest);
        
        // Assert
        assertEquals(expectedBookResponse.getId(), bookResponse.getId());
        assertEquals(expectedBookResponse.getTitle(), bookResponse.getTitle());
        assertEquals(expectedBookResponse.getAuthor(), bookResponse.getAuthor());
        verify(this.bookRepository, times(1)).save(any(Book.class));
    } 
    
    private BookRequestDTO provideBookRequestDTO() {
        return BookRequestDTO.builder()
                .title("Sample Book")
                .author("John Doe")
                .build();
    }

    private BookResponseDTO provideBookResponseDTO() {
        return BookResponseDTO.builder()
                .id(1L)
                .title("Sample Book")
                .author("John Doe")
                .build();
    }

    private Book provideBookResponseDTOWithNullId() {
        return Book.builder()
                .id(1L)
                .title("Sample Book")
                .author("John Doe")
                .build();
    }
}
