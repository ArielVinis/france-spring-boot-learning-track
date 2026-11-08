package com.catalog.application;

import com.catalog.domain.Book;
import com.catalog.domain.BookRepository;
import com.catalog.domain.Isbn;
import org.springframework.stereotype.Service;

@Service
public class AddBookToCatalogUseCase {
    private final BookSearchGateway bookSearchGateway;
    private final BookRepository bookRepository;

    public AddBookToCatalogUseCase(BookSearchGateway bookSearchGateway,
                                   BookRepository bookRepository) {
        this.bookSearchGateway = bookSearchGateway;
        this.bookRepository = bookRepository;
    }

    public Book execute(Isbn isbn) {
        var bookInformation = bookSearchGateway.search(isbn);
        var book = new Book(bookInformation.title(), isbn);
        return bookRepository.save(book);
    }
}
