package com.wipro.Daofiles;

import com.wipro.model.Book;
import java.util.List;

public interface BookDAO {
    int save(Book book);
    int update(Book book);
    int deleteById(int id);
    Book findById(int id);
    List<Book> findAll();
}

