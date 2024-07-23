package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
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
    void searchByTitle() {
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
    void searchByIsbn() {
        // given
        String isbn = "9791171240654";
        String target = "isbn";

        // when
        BookSearchDto bookDetails = bookService.getBookDetailsWithQueryByTarget(isbn, target);

        // then
        assertThat(bookDetails.getDocuments()).hasSize(1);
    }
}