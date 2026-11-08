package com.catalog.infrastructure.persistence.repository;

import com.catalog.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookEntityRepository extends CrudRepository<BookEntity, UUID> {
}
