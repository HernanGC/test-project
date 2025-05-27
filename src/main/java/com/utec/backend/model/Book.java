package com.utec.backend.model;

import com.utec.backend.dto.BookResponseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {}

    public BookResponseDTO toBookResponseDTO() {
        return new BookResponseDTO(this.id, this.title, this.author);
    }
}
