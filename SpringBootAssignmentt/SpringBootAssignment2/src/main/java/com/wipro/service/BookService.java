package com.wipro.service;

import com.wipro.Daofiles.BookDAO;
import com.wipro.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public int save(Book book) { return bookDAO.save(book); }
    public int update(Book book) { return bookDAO.update(book); }
    public int deleteById(int id) { return bookDAO.deleteById(id); }
    public Book findById(int id) { return bookDAO.findById(id); }
    public List<Book> findAll() { return bookDAO.findAll(); }
}
