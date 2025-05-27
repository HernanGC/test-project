package com.utec.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;

}
