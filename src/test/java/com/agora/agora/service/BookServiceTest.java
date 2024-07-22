package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BookServiceTest.class);
    @Autowired
    private BookService bookService;

    @DisplayName("키워드로 책 제목을 검색하면 10권의 책이 검색된다.")
    @Test
    void searchByTitle() throws JsonProcessingException {
        // given
        String query = "인생";
        String target = "title";

        // when
        BookSearchDto data = bookService.getBookDetailsWithQueryByTarget(query, target);

        // then
        assertThat(data.getDocuments()).hasSize(10)
                .extracting("title")
                .allMatch(title -> ((String) title).toLowerCase().contains(query.toLowerCase()));
    }

    @DisplayName("고유한 isbn으로 특정 책 하나를 검색한다.")
    @Test
    void searchByIsbn() throws JsonProcessingException {
        // given
        String isbn = "1171240651 9791171240654";
        String target = "isbn";

        // when
        BookSearchDto bookDetails = bookService.getBookDetailsWithQueryByTarget(isbn, target);

        // then
        System.out.println("bookDetails = " + bookDetails.getDocuments());
        assertThat(bookDetails.getDocuments()).hasSize(1);
    }
}