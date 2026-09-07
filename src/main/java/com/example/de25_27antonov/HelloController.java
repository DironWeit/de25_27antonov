package com.example.de25_27antonov;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Открыто модальное окно!");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modal-view.fxml"));

        try {
            VBox modalContent = fxmlLoader.load();

            Dialog<Void> dialog = new Dialog<>();

            dialog.setTitle("Добавить пользователя");
            dialog.getDialogPane().setContent(modalContent);

            Stage stageModalDlg = (Stage) dialog.getDialogPane().getScene().getWindow();

            stageModalDlg.setOnCloseRequest(evt -> {
                // ???
                dialog.close();
            });

            dialog.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }







    }
}
