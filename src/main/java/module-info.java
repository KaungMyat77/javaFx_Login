module com.example.login_signup_fxui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.login_signup_fxui to javafx.fxml;
    exports com.example.login_signup_fxui;
}