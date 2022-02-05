package com.example.login_signup_fxui;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controller{
    public AnchorPane vb;
    public AnchorPane root;
    public Pane p1;
    public AnchorPane a1;
    public AnchorPane a2;
    public Button Swbtn;
    private boolean sw=false;
    @FXML
    void left(ActionEvent e1) {
        if (sw == false) {
            TranslateTransition t1 = new TranslateTransition(Duration.seconds(1.2), vb);
            TranslateTransition t2 = new TranslateTransition(Duration.seconds(1.2), p1);
            t1.setToX(vb.getLayoutX() + (root.getPrefWidth() - vb.getPrefWidth()) + 30);
            t2.setToX(-p1.getPrefWidth() + 100);
            t1.play();
            t2.play();
            t2.setOnFinished((e) -> {
                try {
                    FXMLLoader fxml = new FXMLLoader(main.class.getResource("signUp.fxml"));
                    FXMLLoader fxml1 = new FXMLLoader(main.class.getResource("wLogin.fxml"));
                    a1 = fxml.load();
                    a2 = fxml1.load();
                    p1.getChildren().removeAll();
                    p1.getChildren().setAll(a1);
                    Swbtn.setText("Sign In");
                    sw=true;
                    vb.getChildren().set(0, a2);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });
        }else{
            TranslateTransition t1 = new TranslateTransition(Duration.seconds(1.2), vb);
            TranslateTransition t2 = new TranslateTransition(Duration.seconds(1.2), p1);
            t1.setToX(0);
            t2.setToX(0);
            t1.play();
            t2.play();
            t2.setOnFinished((e2) -> {
                try {
                    FXMLLoader fxml = new FXMLLoader(main.class.getResource("signIn.fxml"));
                    FXMLLoader fxml1 = new FXMLLoader(main.class.getResource("wSignUp.fxml"));
                    a1 = fxml.load();
                    a2 = fxml1.load();
                    p1.getChildren().removeAll();
                    p1.getChildren().setAll(a1);
                    Swbtn.setText("Sign Up");
                    sw=false;
                    vb.getChildren().set(0, a2);

                } catch (IOException ex) {
                    System.out.println(ex);
                }
            });
        }
    }

}