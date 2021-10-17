package com.cateringfx;

import com.cateringfx.model.Aliment;
import com.cateringfx.utils.FileUtils;
import com.cateringfx.utils.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>Controller in charge of manage a secondary window to add a new Aliment.</p>
 * @see Aliment
 *
 * @author Francisco David Manzanedo Valle.
 * @version 1.0
 */
public class NewAlimentController implements Initializable {

    public static Aliment aliment;
    @FXML private CheckBox checkGluten;
    @FXML private CheckBox checkEgg;
    @FXML private CheckBox checkNuts;
    @FXML private CheckBox checkMilk;
    @FXML private TextField txtFat;
    @FXML private TextField txtCarbo;
    @FXML private TextField txtCalories;
    @FXML private TextField txtFrequency;
    @FXML private TextField txtDescription;
    @FXML private TextField txtName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    /**
     *Button event to create and save a new Aliment.
     * @param actionEvent ActionEvent.
     * @see Aliment
     */
    @FXML
    private void saveNewAliment(ActionEvent actionEvent) {
        if(txtName.getText().isEmpty() || txtFrequency.getText().isEmpty() ||
                txtDescription.getText().isEmpty() || txtCalories.getText().isEmpty() ||
                txtCarbo.getText().isEmpty() || txtFat.getText().isEmpty()){
            MessageUtils.showError("Error", "All fields are required");
        }else{

            aliment = new Aliment(txtName.getText(), txtDescription.getText(), txtFrequency.getText(),
                    checkGluten.isSelected(),checkMilk.isSelected(),checkNuts.isSelected(),checkEgg.isSelected(),
                    Double.parseDouble(txtCalories.getText()),Double.parseDouble(txtCarbo.getText()),
                    Double.parseDouble(txtFat.getText()));

            boolean confirmation = MessageUtils.showConfirmation("Confirmation","Do yo want to save this Aliment?");

            if(confirmation)
                FileUtils.storeAliment(aliment);

            setUpFieldsByDefault();
        }
    }

    /**
     * Sets all the controls by default state,
     */
    private void setUpFieldsByDefault(){
        txtName.setText("");
        txtDescription.setText("");
        txtFrequency.setText("");
        txtCalories.setText("");
        txtCarbo.setText("");
        txtFat.setText("");
        checkEgg.setSelected(false);
        checkGluten.setSelected(false);
        checkMilk.setSelected(false);
        checkNuts.setSelected(false);
    }
}
