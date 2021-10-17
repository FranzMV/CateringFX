package com.cateringfx;

import com.cateringfx.utils.MessageUtils;
import com.cateringfx.model.MenuElement;
import com.cateringfx.model.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>Controller in charge of manege a new window and set the calories, carbohydrates and fat limits of a Menu. </p>
 * @see MenuElement
 * @see Menu
 *
 * @author Francisco David Manzanedo Valle.
 * @version 1.0
 */
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

    /**
     * Button event to save the calories, carbohydrates and fat limits.
     * @param actionEvent ActionEvent.
     */
    @FXML
    private void saveLimits(ActionEvent actionEvent) {
        if(txtFat.getText().isEmpty() || txtCarbo.getText().isEmpty() || txtCalories.getText().isEmpty()){
            MessageUtils.showError("Error", "The fields cannot be left empty.");
        }else {
            limitCalories = Double.parseDouble(txtCalories.getText());
            limitCarbohydrates = Double.parseDouble(txtCarbo.getText());
            limitFats = Double.parseDouble(txtFat.getText());
            closeThisWindow(actionEvent);
        }
    }

    /**
     * Method to close the actual view.
     * @param actionEvent ActionEvent.
     */
    private void closeThisWindow(ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

}
