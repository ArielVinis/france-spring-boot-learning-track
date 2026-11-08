package com.budgeting.infrastructure.http.request;

import com.budgeting.application.input.PersistTransactionInput;
import com.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
