package com.xitcode.expenseTracker.service.abstracts;

import com.xitcode.expenseTracker.dto.DtoTransaction;
import com.xitcode.expenseTracker.dto.DtoTransactionResponse;
import com.xitcode.expenseTracker.dto.DtoUpdateTransaction;
import com.xitcode.expenseTracker.entity.Transaction;

import java.util.List;

public interface TransactionService {
    DtoTransactionResponse save(DtoTransaction dtoTransaction);

    List<Transaction> findAllByUserId(long user_id);

    DtoTransactionResponse findById(long user_id);

    DtoTransactionResponse update(DtoUpdateTransaction dtoUpdateTransaction, long transaction_id);

    void delete(long transaction_id);
}
