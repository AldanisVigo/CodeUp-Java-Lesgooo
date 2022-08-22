package com.vigoengineering.vigocalendar.views.signout;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vigoengineering.vigocalendar.views.MainView;

@PageTitle("Sign Out")
@Route(value = "signout", layout = MainView.class)
public class SignOutView extends VerticalLayout {
    Button yesButton;
    Button noButton;

    HorizontalLayout actions;
    Paragraph question;
    public SignOutView() {
        //question
        question = new Paragraph("Would you like to sign out?");

        //yes button
        yesButton = new Button("Yes");
        yesButton.addClickListener(e->{
            //Exit the app.
            Notification notification = new Notification();

            Div text = new Div(new Text("Logging off"));

            Button closeButton = new Button(new Icon("lumo", "cross"));
            closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            closeButton.getElement().setAttribute("aria-label", "Close");
            closeButton.addClickListener(event -> {
                notification.close();
            });

            HorizontalLayout layout = new HorizontalLayout(text, closeButton);
            layout.setAlignItems(Alignment.CENTER);
            notification.add(layout);
            notification.open();

            yesButton.getUI().ifPresent(ui->{
                ui.navigate("");
            });
        });

        //no button
        noButton = new Button("No");
        noButton.addClickListener((e->{
            //Return to previous route.
//            noButton.getUI().ifPresent(ui->{
//                ui.navigate();
//            });
//            Page.getJavaScript().execute("alert('window.history.back()')");

        }));

        actions = new HorizontalLayout();
        actions.add(yesButton);
        actions.add(noButton);

        add(question);
        add(actions);

    }
}
