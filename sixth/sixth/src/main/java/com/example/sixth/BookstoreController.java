package com.example.sixth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {
    @Autowired
    private BookstoreRepository bookstoreRepository;
    
    @GetMapping
    public List<Bookstore> getAllBooks() {
        return bookstoreRepository.findAll();
    }
    
    @PostMapping
    public Bookstore createBook(@RequestBody Bookstore book) {
        return bookstoreRepository.save(book);
    }
    
    @PutMapping("/{bookId}")
    public ResponseEntity<Bookstore> updateBook(@PathVariable Long bookId, @RequestBody Bookstore updatedBook) {
        Optional<Bookstore> existingBook = bookstoreRepository.findById(bookId);
        if (existingBook.isPresent()) {
            updatedBook.setBookId(bookId);
            return ResponseEntity.ok(bookstoreRepository.save(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookstoreRepository.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }
}
