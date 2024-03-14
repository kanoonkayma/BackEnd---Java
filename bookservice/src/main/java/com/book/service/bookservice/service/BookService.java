package com.book.service.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.book.service.bookservice.model.Book;

@Service //indica ser um componente de serviço gerenciado pelo Spring
public class BookService {
    
    private AtomicLong counter = new AtomicLong();
    
    private final List<Book> books = new ArrayList<>();
   // private Long idCounter = 1L;

   //add 
    public BookService() {
        books.add(new Book(counter.incrementAndGet(),"Admiravel mundo novo","Aldous Huxley"));
        books.add(new Book(counter.incrementAndGet(),"Retrato de Dorian Gray","Oscar Wilde"));
    }

    //listar todos os books
    public List<Book> findAllBooks() {
        return books;
    }

    //add os livros
    public Book addBook(Book book){
        book.setId(counter.incrementAndGet());
        books.add(book);
        return book;
    }


}
