package com.directoryxx.belajarspring.Repositories;

import com.directoryxx.belajarspring.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
