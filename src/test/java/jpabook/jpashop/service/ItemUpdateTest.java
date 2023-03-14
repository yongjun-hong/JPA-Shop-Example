package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
@ExtendWith(Extension.class)
public class ItemUpdateTest {
    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);
        book.setName("kevin");

    }

}




