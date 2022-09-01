package com.dompurrr.obshagahelper.service;

import com.dompurrr.obshagahelper.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransactionServiceImpl implements TransactionService{

    private static final Map<Integer, Transaction> TRANSACTION_REPOSITORY_MAP  = new HashMap<>();

    private static final AtomicInteger TRANSACTION_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Transaction transaction) {
        final Integer transactionId = TRANSACTION_ID_HOLDER.incrementAndGet();
        transaction.setId(transactionId);
        TRANSACTION_REPOSITORY_MAP.put(transactionId, transaction);
    }

    @Override
    public List<Transaction> readAll() {
        return new ArrayList<>(TRANSACTION_REPOSITORY_MAP.values());
    }

    @Override
    public Transaction read(int id) {
        return TRANSACTION_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Transaction transaction, Integer id) {
        if (TRANSACTION_REPOSITORY_MAP.containsKey(id)){
            transaction.setId(id);
            TRANSACTION_REPOSITORY_MAP.put(id, transaction);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return TRANSACTION_REPOSITORY_MAP.remove(id) != null;
    }
}
