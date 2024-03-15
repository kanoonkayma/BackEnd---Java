package com.book.service.bookservice.controller;
import com.book.service.bookservice.model.Book;
import com.book.service.bookservice.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController //indica que ele responde a solicitações HTTP e automaticamente serializa os objetos de retorno para JSON
@RequestMapping("/books") //mapeia os endpoints dentro desta classe para o caminho /books.
public class BookController {
    
    @Autowired
    private BookService bookService; //controller precisa conversar com a service
    
    //métodos do controlador

    @GetMapping //essa anotação tem referencia HTTP get
    public List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping //essa anotação tem referencia HTTP post
    public Book addBook(@RequestBody Book book) {
        
        return bookService.addBook(book);
    }


}
