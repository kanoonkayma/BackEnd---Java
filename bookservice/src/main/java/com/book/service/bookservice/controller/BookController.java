package com.book.service.bookservice.controller;
import com.book.service.bookservice.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController //indica que ele responde a solicitações HTTP e automaticamente serializa os objetos de retorno para JSON
@RequestMapping("/api/books") //mapeia os endpoints dentro desta classe para o caminho /api/books.
public class BookController {
    
    private final List<Book> books = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    //métodos do controlador

    @GetMapping("/{id}") //essa anotação tem referencia HTTP get
    //PathVariable: mapear uma variável na URL (como {id}) para um parâmetro de método Java (postman).
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping //essa anotação tem referencia HTTP post
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


}
