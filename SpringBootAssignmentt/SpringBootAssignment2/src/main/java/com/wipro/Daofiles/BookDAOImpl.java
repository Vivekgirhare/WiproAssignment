package com.wipro.Daofiles;

import com.wipro.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Book book) {
        String sql = "INSERT INTO books (bookname, author, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, book.getBookname(), book.getAuthor(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        String sql = "UPDATE books SET bookname=?, author=?, price=? WHERE bookid=?";
        return jdbcTemplate.update(sql, book.getBookname(), book.getAuthor(), book.getPrice(), book.getBookid());
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM books WHERE bookid=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE bookid=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
