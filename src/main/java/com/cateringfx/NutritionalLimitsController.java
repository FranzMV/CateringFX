package com.cateringfx;

import com.cateringfx.utils.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NutritionalLimitsController implements Initializable {

    public static double limitCalories = 0;
    public static double limitCarbohydrates = 0;
    public static double limitFats = 0;

    @FXML private TextField txtFat;
    @FXML private TextField txtCarbo;
    @FXML private TextField txtCalories;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        txtCalories.setText(String.valueOf(limitCalories));
        txtCarbo.setText(String.valueOf(limitCarbohydrates));
        txtFat.setText(String.valueOf(limitFats));
    }

    public void saveLimits(ActionEvent actionEvent) {
        if(txtFat.getText().isEmpty() || txtCarbo.getText().isEmpty() || txtCalories.getText().isEmpty()){
            MessageUtils.showError("Error", "The fields cannot be left empty.");
        }else {
            limitCalories = Double.parseDouble(txtCalories.getText());
            limitCarbohydrates = Double.parseDouble(txtCarbo.getText());
            limitFats = Double.parseDouble(txtFat.getText());
        }
    }
}
