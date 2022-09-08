package com.dompurrr.obshagahelper.views;

import com.dompurrr.obshagahelper.model.Transaction;
import com.dompurrr.obshagahelper.service.TransactionServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "money", layout = MainView.class)
@PageTitle("Считаем деньги")
public class MoneyView extends VerticalLayout {
    final Grid<Transaction> grid;
    private final TransactionServiceImpl repo;

    public MoneyView(TransactionServiceImpl repo) {
        this.repo = repo;
        //Input fields
        TextField room = new TextField("Room");
        TextField name = new TextField("Name");
        TextField amount = new TextField("Amount");
        TextField comment = new TextField("Comment");
        Button addbutton = new Button("Add");
        addbutton.addClickListener(clickEvent -> {
            Transaction newTransaction = new Transaction();
            newTransaction.setAmount(amount.getValue());
            newTransaction.setRoom(room.getValue());
            newTransaction.setName(name.getValue());
            newTransaction.setComment(comment.getValue());
            repo.create(newTransaction);
        });

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                room, name,
                amount,
                comment, addbutton
        );
        formLayout.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1)
        );
        add(formLayout);

        //Output field
        this.grid = new Grid<>(Transaction.class);
        add(grid);
        listTransactions();
    }

    private void listTransactions() {
        grid.setItems(repo.readAll());
    }
}
