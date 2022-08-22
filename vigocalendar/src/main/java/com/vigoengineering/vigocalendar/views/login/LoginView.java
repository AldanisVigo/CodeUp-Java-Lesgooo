package com.vigoengineering.vigocalendar.views.login;

import com.vigoengineering.vigocalendar.views.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Login")
@Route(value = "login", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class LoginView extends VerticalLayout {
    TextField email;
    PasswordField password;
    Button loginBtn;
    public LoginView() {
        //Email Field
        email = new TextField("Email");
        email.setPlaceholder("Email Address");
        email.isRequired();
        email.setMinLength(5);
        email.setMaxLength(30);

        password = new PasswordField("Password");
        password.setPlaceholder("Password");
        password.isRequired();
        password.setMinLength(6);
        password.setMaxLength(30);

        loginBtn = new Button("Login");
        loginBtn.addClickListener(e->{
            //Do some stuff to log in.
        });

        setSizeFull(); //Expand to the entire available area
        add(email,password,loginBtn);
    }

}