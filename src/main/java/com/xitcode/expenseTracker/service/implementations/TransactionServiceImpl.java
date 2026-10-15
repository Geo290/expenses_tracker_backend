package com.xitcode.expenseTracker.service.implementations;

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

    private TransactionRepository transactionRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository, CategoryRepository categoryRepository){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DtoTransactionResponse save(DtoTransaction dtoTransaction) {

        Users user = userRepository.findById(dtoTransaction.userId()).orElseThrow(()-> new BadCredentialsException("User not found"));
        Category category = categoryRepository.findById(dtoTransaction.categoryId()).orElseThrow(()-> new IndexOutOfBoundsException("Category not found"));

        Transaction t = new Transaction();
        t.setTitle(dtoTransaction.title());
        t.setDate(dtoTransaction.date());
        t.setAmount(dtoTransaction.amount());
        t.setCategory(category);
        t.setUser(user);

        transactionRepository.save(t);

        return new DtoTransactionResponse(
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId()
        );
    }

    @Override
    public List<DtoTransactionResponse> findAllById(long user_id) {
        return List.of();
    }

    @Override
    public DtoTransactionResponse findById(long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id).orElseThrow(()-> new RuntimeException("Transaction Not Found"));

        return new DtoTransactionResponse(
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId()
        );
    }

    @Override
    public DtoTransactionResponse update(DtoUpdateTransaction dtoUpdateTransaction, long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id).orElseThrow(()-> new RuntimeException("Transaction NOT Found"));
        Category category = categoryRepository.findById(dtoUpdateTransaction.categoryId()).orElseThrow(()-> new RuntimeException("Category not Found"));

        t.setAmount(dtoUpdateTransaction.amount());
        t.setTitle(dtoUpdateTransaction.title());
        t.setDate(dtoUpdateTransaction.date());
        t.setCategory(category);

        transactionRepository.save(t);

        return new DtoTransactionResponse(
                t.getAmount(),
                t.getTitle(),
                t.getDate(),
                t.getCategory().getId()
        );
    }

    @Override
    public void delete(long transaction_id) {
        Transaction t = transactionRepository.findById(transaction_id).orElseThrow(()-> new RuntimeException("Transaction NOT Found"));
        transactionRepository.delete(t);
    }
}
