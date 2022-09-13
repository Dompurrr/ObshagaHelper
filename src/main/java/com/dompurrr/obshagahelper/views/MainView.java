package com.dompurrr.obshagahelper.views;

import com.dompurrr.obshagahelper.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@PermitAll
@Route("")
@PageTitle("Встаем в планочку и угадываем, что мы сделали не так")
public class MainView extends AppLayout {
    private final SecurityService securityService;

    public MainView(SecurityService securityService){
        this.securityService = securityService;

        H1 title = new H1("Общага");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)")
                .set("margin", "0")
                .set("position", "absolute");

        Tabs tabs = getTabs();
        tabs.getStyle().set("margin", "auto");

        Button logout = new Button("Выход", e -> securityService.logout());

        addToNavbar(title, tabs, logout);
    }

    private Tabs getTabs() {
        RouterLink memberLink = new RouterLink("Жители", MemberView.class);
        Tab members = new Tab(memberLink);

        RouterLink moneyLink = new RouterLink("Деньги", MoneyView.class);
        Tab moneys = new Tab(moneyLink);

        Tab duties = new Tab("Дежурства");
        duties.setEnabled(false);
        Tabs tabs = new Tabs(members, moneys, duties);
        tabs.setSelectedTab(members);
        return tabs;
    }
}
