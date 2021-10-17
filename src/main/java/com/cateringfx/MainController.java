package com.cateringfx;

import com.cateringfx.model.Aliment;
import com.cateringfx.model.MenuElement;
import com.cateringfx.model.Dish;
import com.cateringfx.model.Menu;
import com.cateringfx.utils.FileUtils;
import com.cateringfx.utils.MessageUtils;
import com.cateringfx.utils.ScreenLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.cateringfx.NutritionalLimitsController.*;


/**
 * <p>Controller in charge of manage the main window of the application.</p>
 * @author Francisco David Manzanedo Valle
 * @version 1.0
 */
public class MainController implements Initializable {

    private final static String NEW_ALIMENT_XML_FILENAME="new-aliment-view.fxml";
    private final static String NEW_DISH_XML_FILENAME="new-dish-view.fxml";
    private final static String NEW_NUTRITIONAL_LIMITS_XML_FILENAME="nutritional-limits-view.fxml";

    @FXML private DatePicker datePickerMenu;

    @FXML private CheckBox checkMilk;
    @FXML private CheckBox checkNuts;
    @FXML private CheckBox checkEgg;
    @FXML private CheckBox checkGluten;

    @FXML private TableView<MenuElement> tableViewElements;
    @FXML private TableColumn<MenuElement, Aliment> columnName;
    @FXML private TableColumn<MenuElement, Aliment> columnCalories;
    @FXML private TableColumn<MenuElement, Aliment> columnCarbo;
    @FXML private TableColumn<MenuElement, Aliment> columnFat;

    @FXML private TableView<MenuElement> tableViewMenu;
    @FXML private TableColumn<MenuElement, String> columnMenuName;
    @FXML private TableColumn<MenuElement, String> columnMenuDesc;

    private List<MenuElement> alimentList;
    private List<MenuElement>menuList;
    private Menu menu;

    @FXML private Label lblCalories;
    @FXML private Label lblCarbo;
    @FXML private Label lblFat;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {  tearUp();  }


    /**
     * Load and initialize the resources needed when the program stars.
     */
    private void tearUp(){

        menu = new Menu(LocalDate.now());
        datePickerMenu.setValue(menu.getDate());

        alimentList = FXCollections.observableArrayList(FileUtils.loadElements());
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        columnCarbo.setCellValueFactory(new PropertyValueFactory<>("carbohydrates"));
        columnFat.setCellValueFactory(new PropertyValueFactory<>("fat"));
        tableViewElements.setItems(FXCollections.observableList(alimentList));

        columnMenuName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnMenuDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        menuList = new ArrayList<>();
    }


    /**
     * Button event to open a {@link NewAlimentController} stage.
     * @param actionEvent ActionEvent.
     * @throws IOException IOException.
     */
    @FXML
    private void openAddNewAlimentStage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_ALIMENT_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> tearUp());
        newStage.show();
    }

    /**
     * Button event to open a {@link NewDishController} stage.
     * @param actionEvent ActionEvent.
     * @throws IOException IOException.
     */
    @FXML
    private void openAddNewDishStage(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_DISH_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> tearUp());
        newStage.show();
    }


    /**
     * Button event to open a {@link NutritionalLimitsController} stage.
     * @param actionEvent ActionEvent.
     * @throws IOException IOException.
     */
    @FXML
    private void openSaveLimitsStage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_NUTRITIONAL_LIMITS_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> tearUp());
        newStage.show();
    }


    /**
     * Button event add a new {@link Aliment} or {@link Dish} to the {@link #tableViewMenu}.
     * @param actionEvent ActionEvent.
     * @see Aliment
     * @see Dish
     */
    @FXML
    private void addAlimentToTheMenu(ActionEvent actionEvent) {
        if(tableViewElements.getSelectionModel().getSelectedItem() !=null){
            menuList.add(tableViewElements.getItems().get(tableViewElements.getSelectionModel().getSelectedIndex()));
            tableViewMenu.setItems(FXCollections.observableArrayList(menuList));

            menu.addNewElement(tableViewElements.getSelectionModel().getSelectedItem());
            setUpNutritionalLimits();

        }else MessageUtils.showMessage("Information", "You must select an item to add to the menu.");
    }


    /**
     * Button event to delete an Aliment or Dish from the  #tableViewMenu.
     * @param actionEvent ActionEvent.
     * @see Aliment
     * @see Dish
     */
    @FXML
    private void deleteAlimentFromTheMenu(ActionEvent actionEvent) {
        if(tableViewMenu.getSelectionModel().getSelectedItem() != null){
            menuList.remove(tableViewMenu.getItems().get(tableViewMenu.getSelectionModel().getSelectedIndex()));
            tableViewMenu.setItems(FXCollections.observableArrayList(menuList));

            menu.getElements().remove(tableViewMenu.getSelectionModel().getSelectedItem());
            setUpNutritionalLimits();

        }else
            MessageUtils.showMessage("Information", "You must select a menu to delete from de list.");
    }

    /**
     * CheckBox event to select if the Aliment contains milk.
     * @param actionEvent ActionEvent.
     * @see Aliment
     */
    @FXML
    private void checkMilkSelected(ActionEvent actionEvent) {
        if(checkMilk.isSelected()){
            checkEgg.setSelected(false);
            checkNuts.setSelected(false);
            checkGluten.setSelected(false);
            tableViewElements.setItems(
                    FXCollections.observableArrayList(
                            alimentList
                                    .stream()
                                    .filter(MenuElement::isMilk)
                                    .collect(Collectors.toList()))
            );

        }else{
            checkMilk.setSelected(false);
            tableViewElements.setItems(FXCollections.observableArrayList(alimentList));
        }
    }

    /**
     * CheckBox event to select if the Aliment contains nuts.
     * @param actionEvent ActionEvent.
     * @see Aliment
     */
    @FXML
    private void checkNutsSelected(ActionEvent actionEvent) {
        if(checkNuts.isSelected()){
            checkMilk.setSelected(false);
            checkGluten.setSelected(false);
            checkEgg.setSelected(false);
            tableViewElements.setItems(
                    FXCollections.observableArrayList(
                            alimentList.stream()
                                    .filter(MenuElement:: isNuts)
                                    .collect(Collectors.toList()))
            );

        }else {
            checkNuts.setSelected(false);
            tableViewElements.setItems(FXCollections.observableArrayList(alimentList));
        }
    }

    /**
     * CheckBox event to select if the Aliment contains egg.
     * @param actionEvent ActionEvent.
     * @see Aliment
     */
    @FXML
    private void checkEggSelected(ActionEvent actionEvent) {
        if(checkEgg.isSelected()){
            checkMilk.setSelected(false);
            checkNuts.setSelected(false);
            checkGluten.setSelected(false);
            tableViewElements.setItems(
                    FXCollections.observableArrayList(
                            alimentList.stream()
                                    .filter(MenuElement:: isEgg)
                                    .collect(Collectors.toList()))
            );

        }else{
            checkEgg.setSelected(false);
            tableViewElements.setItems(FXCollections.observableArrayList(alimentList));
        }
    }

    /**
     * CheckBox event to select if the Aliment contains gluten.
     * @param actionEvent ActionEvent.
     * @see Aliment
     */
    @FXML
    private void checkGlutenSelected(ActionEvent actionEvent) {
        if(checkGluten.isSelected()){
            checkMilk.setSelected(false);
            checkNuts.setSelected(false);
            checkEgg.setSelected(false);
            tableViewElements.setItems(
                    FXCollections.observableArrayList(
                            alimentList.stream()
                                    .filter(MenuElement:: isGluten)
                                    .collect(Collectors.toList()))
            );

        }else{
            checkGluten.setSelected(false);
            tableViewElements.setItems(FXCollections.observableArrayList(alimentList));
        }
    }


    /**
     * Button event to save the menu selected by the user in a text file.
     * @param actionEvent ActionEvent
     */
    @FXML
    private void saveNewMenu(ActionEvent actionEvent) {

        if(menuList.size() > 0 && menu != null){
            boolean result = MessageUtils.showConfirmation("Confirmation", "Do you want to save this menu?");
            if(result)
                FileUtils.storeMenu(menu);

        }else  MessageUtils.showError("Error", "No item has been selected for the menu");
    }

    /**
     *Sets the calories, carbohydrates and fats of the Aliment selected by the user.
     * @see Aliment
     */
    private void setUpNutritionalLimits(){

        if(tableViewElements.getSelectionModel().getSelectedItem() != null){
            double calories = menuList.stream().mapToDouble(MenuElement::getCalories).sum();
            lblCalories.setText(String.valueOf(calories));
            setUpLimitColours(lblCalories, calories, limitCalories);

            double carbohydrates = menuList.stream().mapToDouble(MenuElement::getCarbohydrates).sum();
            lblCarbo.setText(String.valueOf(carbohydrates));
            setUpLimitColours(lblCarbo, carbohydrates, limitCarbohydrates);

            double fat = menuList.stream().mapToDouble(MenuElement::getFat).sum();
            lblFat.setText(String.valueOf(fat));
            setUpLimitColours(lblFat, fat, limitFats);

        }else
            MessageUtils.showError("Error", "You must select an item to add to the menu.");
    }

    /**
     * Sets the color of the label depending on the limit of nutritional value at {@link #setUpNutritionalLimits()}.
     * @param label The Label corresponding to the nutritional value name.
     * @param itemValue Double corresponding to Aliment nutritional value.
     * @param limit Double corresponding to the limit sets by the user.
     * @see Aliment
     */
    private void setUpLimitColours(Label label, double itemValue, double limit){
        if(itemValue> limit)
            label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }

}