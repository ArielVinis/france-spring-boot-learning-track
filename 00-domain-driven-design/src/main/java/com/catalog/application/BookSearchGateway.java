package com.catalog.application;

import com.catalog.domain.Isbn;

public interface BookSearchGateway {
    BookInformation search(Isbn isbn);
}
