package com.utec.backend.controller;

import com.utec.backend.dto.BookRequestDTO;
import com.utec.backend.dto.BookResponseDTO;
import com.utec.backend.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookResponseDTO createBook(@RequestBody BookRequestDTO book) {
        return this.bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Integer id) {
        return this.bookService.getBookById(id);
    }
}
