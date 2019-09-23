package com.airhacks.repository;

import com.airhacks.models.Book;
import com.airhacks.util.TextUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class BookRepository {

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager em;

    @Inject
    private  TextUtil textUtil;

    public Book findBook(int id){
        return em.find(Book.class,id);
    }

    @Transactional(REQUIRED)
    public Book createBook(Book book){
        book.setPublicationDate(LocalDateTime.now().minusDays(10));
        book.setTitle(textUtil.removeSpaces(book.getTitle()));
        em.persist(book);
        em.flush();
        return book;
    }

    @Transactional(REQUIRED)
    public void deleteBook(Long id){
        em.remove(em.getReference(Book.class,id));
    }

    public List<Book> findAllBooks(){
        TypedQuery<Book> query = em.createQuery("Select b from Book b", Book.class);
        return query.getResultList();
    }

    public Long countAllBooks(){
        TypedQuery<Long> query = em.createQuery("SELECT count(b) from Book b",Long.class);
        return query.getSingleResult();
    }
}
