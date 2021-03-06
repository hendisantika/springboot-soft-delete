package com.hendisantika.springbootsoftdelete.service;

import com.hendisantika.springbootsoftdelete.entity.Book;
import com.hendisantika.springbootsoftdelete.repository.BookRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/06/21
 * Time: 18.08
 */
@Service
public class BookService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book books) {
        return bookRepository.save(books);
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    public Iterable<Book> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Book> books = bookRepository.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    }

}
