package com.xitcode.expenseTracker.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.xitcode.expenseTracker.service.TransactionServiceImpl;
import com.xitcode.expenseTracker.dto.DtoTransactionResponse;
import com.xitcode.expenseTracker.dto.DtoUpdateTransaction;
import com.xitcode.expenseTracker.dto.DtoTransaction;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionServiceImpl service;

	@Autowired
	public TransactionController(TransactionServiceImpl service) {
		this.service = service;
	}

	@PostMapping()
	public DtoTransactionResponse save(@Valid @RequestBody DtoTransaction dtoTransaction) {
		return service.save(dtoTransaction);
	}

	@GetMapping("/user/{id}")
	public List<DtoTransactionResponse> findAllById(@PathVariable Long id) {
		return service.findAllById(id);
	}

	@GetMapping("/{id}")
	public DtoTransactionResponse findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping("/{id}")
	public DtoTransactionResponse update(@PathVariable Long id, @RequestBody DtoUpdateTransaction body) {
		return service.update(body, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
