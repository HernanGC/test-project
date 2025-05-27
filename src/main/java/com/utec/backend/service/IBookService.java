package com.utec.backend.service;

import com.utec.backend.dto.BookRequestDTO;
import com.utec.backend.dto.BookResponseDTO;


public interface IBookService {
    BookResponseDTO createBook(BookRequestDTO bookRequest);
    BookResponseDTO getBookById(Integer id);
}
