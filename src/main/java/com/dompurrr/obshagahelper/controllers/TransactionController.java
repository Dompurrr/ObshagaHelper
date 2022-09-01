package com.dompurrr.obshagahelper.controllers;

import com.dompurrr.obshagahelper.model.Transaction;
import com.dompurrr.obshagahelper.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class TransactionController {
//    private final TransactionService transactionService;
//
//    @Autowired
//    public TransactionController(TransactionService transactionService){
//        this.transactionService = transactionService;
//    }
//
//    @PostMapping(value = "/money")
//    public ResponseEntity<?> create(@RequestBody Transaction transaction){
//        transactionService.create(transaction);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/money")
//    public ResponseEntity<List<Transaction>> read(){
//        final List<Transaction> transactions = transactionService.readAll();
//        return transactions != null && !transactions.isEmpty()
//                ? new ResponseEntity<>(transactions, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/money/{id}")
//    public ResponseEntity<Transaction> read(@PathVariable(name = "id") int id){
//        final Transaction transaction = transactionService.read(id);
//        return transaction != null
//                ? new ResponseEntity<>(transaction, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/money/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Transaction transaction){
//        final boolean updated = transactionService.update(transaction, id);
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/money/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
//        final boolean deleted = transactionService.delete(id);
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}
