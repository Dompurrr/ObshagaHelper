package com.dompurrr.obshagahelper.service;

import com.dompurrr.obshagahelper.model.Transaction;

import java.util.List;

public interface TransactionService {
    /**
     * Запись новой транзакции
     * @param
     */
    void create(Transaction transaction);

    /**
     * Вывод списка всех транзакций
     * @return ArrayList всех транзакций
     */
    List<Transaction> readAll();

    /**
     * Вывод транзакции по её id
     * @param id - ID конкретной транзакции
     * @return Транзакция с заданным ID
     */
    Transaction read(int id);

    /**
     * Обновляет транзакцию с заданным ID,
     * на транзакцию transaction
     * @param transaction транзакция заместо старой
     * @param id - ID транзакции которую необходимо заменить
     * @return true в случае успеха, иначе - false
     */
    boolean update(Transaction transaction, Integer id);

    /**
     * Удаление клиента с заданным ID
     * @param id - id транзакции для удаления
     * @return true в случае успеха, иначе - false
     */
    boolean delete(Integer id);
}
