package com.hendisantika.springbootsoftdelete.repository;

import com.hendisantika.springbootsoftdelete.entity.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/06/21
 * Time: 18.07
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
