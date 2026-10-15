package com.xitcode.expenseTracker.service.implementations;

import com.xitcode.expenseTracker.exception.exceptions.NoDataFoundException;
import com.xitcode.expenseTracker.repository.CategoryRepository;
import com.xitcode.expenseTracker.repository.TransactionRepository;
import com.xitcode.expenseTracker.repository.UserRepository;
import com.xitcode.expenseTracker.dto.DtoTransaction;
import com.xitcode.expenseTracker.dto.DtoTransactionResponse;
import com.xitcode.expenseTracker.dto.DtoUpdateTransaction;
import com.xitcode.expenseTracker.entity.Category;
import com.xitcode.expenseTracker.entity.Transaction;
import com.xitcode.expenseTracker.entity.Users;
import com.xitcode.expenseTracker.service.abstracts.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            UserRepository userRepository,
            CategoryRepository categoryRepository
    ){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DtoTransactionResponse save(DtoTransaction dtoTransaction) {

        Users user = userRepository.findById(dtoTransaction.userId())
                .orElseThrow(()-> new BadCredentialsException("User not found"));

        Category category = categoryRepository.findById(dtoTransaction.categoryId())
                .orElseThrow(()-> new NoDataFoundException("Category not found"));

        Transaction t = new Transaction();
        t.setTitle(dtoTransaction.title());
        t.setDate(dtoTransaction.date());
        t.setAmount(dtoTransaction.amount());
        t.setCategory(category);
        t.setUser(user);

        transactionRepository.save(t);

        return new DtoTransactionResponse(
                t.getId(),
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId(),
                t.getCategory().getName(),
                t.getCategory().getType()
        );
    }

    @Override
    public List<Transaction> findAllByUserId(long user_id) {
        Users res = userRepository.findById(user_id).orElseThrow(
                () -> new NoDataFoundException("User Not Found"));

        return transactionRepository.findAllByUser(res);
    }

    @Override
    public DtoTransactionResponse findById(long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id).orElseThrow(
                ()-> new NoDataFoundException("Transaction Not Found"));

        return new DtoTransactionResponse(
                t.getId(),
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId(),
                t.getCategory().getName(),
                t.getCategory().getType()
        );
    }

    @Override
    public DtoTransactionResponse update(DtoUpdateTransaction dtoUpdateTransaction, long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id)
                .orElseThrow(()-> new NoDataFoundException("Transaction NOT Found"));

        Category category = categoryRepository.findById(dtoUpdateTransaction.categoryId())
                .orElseThrow(()-> new NoDataFoundException("Category not Found"));

        t.setAmount(dtoUpdateTransaction.amount());
        t.setTitle(dtoUpdateTransaction.title());
        t.setDate(dtoUpdateTransaction.date());
        t.setCategory(category);

        transactionRepository.save(t);

        return new DtoTransactionResponse(
                t.getId(),
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId(),
                t.getCategory().getName(),
                t.getCategory().getType()
        );
    }

    @Override
    public void delete(long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id)
                .orElseThrow(()-> new NoDataFoundException("Transaction NOT Found"));

        transactionRepository.delete(t);
    }
}
