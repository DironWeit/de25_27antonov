package com.example.de25_27antonov;

import com.example.de25_27antonov.model.UserForm;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ModelController {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "0000";

    @FXML
    public TextField fpasport;
    @FXML
    public TextField sinn;
    @FXML
    public TextField fphone;
    @FXML
    public TextField femail;
    @FXML
    public TextField fbusday;
    @FXML
    public TextField fname;
    @FXML
    private Label infoText;
    @FXML
    protected void osSaveButClick() {

        System.out.println("Отправляем форму:");
        System.out.println("fname      " + fname.getText());
        System.out.println("fbusday    " + fbusday.getText());
        System.out.println("fphone     " + fphone.getText());
        System.out.println("fpasport   " + fpasport.getText());
        System.out.println("sinn       " + sinn.getText());
        System.out.println("femail     " + femail.getText());

        UserForm  user = new UserForm();
        user.setName(fname.getText());
        user.setBusday(fbusday.getText());
        user.setPhone(fphone.getText());
        user.setEmail(femail.getText());
        user.setInn(sinn.getText());
        user.setPasport(fpasport.getText());

        infoText.setText("");
        try {
            user.saveToDatabase(DB_URL, DB_USER, DB_PASS);
            osCloseButClick();
        } catch (SQLException e) {
            infoText.setText("Ошибка связи с бд");
            System.out.println("Что случилось в СУБД:");
            System.out.println(e);
        }

        // Store to DataBase



        // Закрываем модальное окно с формоей если успешные данные
    }

    @FXML
    protected void osCloseButClick(){
        Stage stage = (Stage) infoText.getScene().getWindow();
        stage.close();
    }
}
