package com.utec.backend.dto;

import com.utec.backend.model.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequestDTO {
    private String title;
    private String author;

    public Book toBook() {
        return new Book(this.title, this.author);
    }
}
