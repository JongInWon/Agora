package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @DisplayName("키워드로 책 제목을 검색하면 10권의 책이 검색된다.")
    @Test
    void searchByTitle() throws JsonProcessingException {
        // given
        String query = "인생";
        String target = "title";

        // when
        BookSearchDto data = bookService.getBooksDataByTarget(query, target);

        // then
        assertThat(data.getDocuments()).hasSize(10)
                .extracting("title")
                .allMatch(title -> ((String) title).toLowerCase().contains(query.toLowerCase()));
    }

    @DisplayName("고유햔 isbn으로 특정 책 하나를 검색한다.")
    @Test
    void searchByIsbn() throws JsonProcessingException {
        // given
        String isbn10 = "1171240651";
        String isbn13 = "9791171240654";
        String target = "isbn";

        // when
        BookSearchDto data1 = bookService.getBooksDataByTarget(isbn10, target);
        BookSearchDto data2 = bookService.getBooksDataByTarget(isbn13, target);

        // then
        assertThat(data1.getDocuments()).hasSize(1);
        assertThat(data2.getDocuments()).hasSize(1);
        assertThat(data1.getDocuments().get(0).getIsbn()).isEqualTo(data2.getDocuments().get(0).getIsbn());

    }
}