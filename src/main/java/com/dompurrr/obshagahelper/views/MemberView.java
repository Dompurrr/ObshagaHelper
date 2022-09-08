package com.dompurrr.obshagahelper.views;

import com.dompurrr.obshagahelper.model.Member;
import com.dompurrr.obshagahelper.model.Transaction;
import com.dompurrr.obshagahelper.service.MemberServiceImpl;
import com.dompurrr.obshagahelper.service.TransactionServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "member", layout = MainView.class)
@PageTitle("Встаем в планочку и думаем, что мы сделали не так")
public class MemberView extends VerticalLayout {
    final Grid<Member> grid;
    private final MemberServiceImpl repo;

    public MemberView(MemberServiceImpl repo){
        this.repo = repo;
        //Input fields
        TextField room = new TextField("Room");
        TextField name = new TextField("Name");
        Button addbutton = new Button("Add");
        addbutton.addClickListener(clickEvent -> {
            Member newMember = new Member();
            newMember.setRoom(room.getValue());
            newMember.setName(name.getValue());
            repo.create(newMember);
        });

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                room, name,
                addbutton
        );
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1)
        );
        add(formLayout);

        //Output field
        this.grid = new Grid<>(Member.class);
        add(grid);
        listMembers();
    }

    private void listMembers() {
        grid.setItems(repo.readAll());
    }
}
