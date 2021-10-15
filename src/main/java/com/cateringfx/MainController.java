package com.cateringfx;

import com.cateringfx.model.Aliment;
import com.cateringfx.model.MenuElement;
import com.cateringfx.model.Menu;
import com.cateringfx.utils.FileUtils;
import com.cateringfx.utils.MessageUtils;
import com.cateringfx.utils.ScreenLoader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


/**
 *
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


    public void tearUp(){

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
    @FXML
    public void openAddNewAlimentStage(ActionEvent actionEvent) throws Exception {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_ALIMENT_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> setOnCloseListener(newStage));
        newStage.show();
    }


    @FXML
    public void openAddNewDishStage(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_DISH_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> setOnCloseListener(newStage));
        newStage.show();
    }


    @FXML
    public void openSaveLimitsStage(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newStage = ScreenLoader.loadScreen(NEW_NUTRITIONAL_LIMITS_XML_FILENAME, stage);
        newStage.setOnCloseRequest(e-> setOnCloseListener(newStage));
        newStage.show();
    }


    public void setOnCloseListener(Stage stage){

        stage.setOnCloseRequest(e ->
        {
            e.consume(); // This way we can prevent window from closing!

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Closing program..");
            alert.setContentText("Do you want to Exit?");
            Optional<ButtonType> result = alert.showAndWait();
            //If the user choice is OK, we save the data changes and close the application
            if (result.isPresent() && result.get() == ButtonType.OK) {
               // FileUtils.saveApps(studentsList);//We save the data
                Platform.exit();
            }else alert.close(); //We close de alert dialog and the app continue running
        });
    }


    @FXML
    public void addAlimentToTheMenu(ActionEvent actionEvent) {
        if(tableViewElements.getSelectionModel().getSelectedItem() !=null){
            menuList.add(tableViewElements.getItems().get(tableViewElements.getSelectionModel().getSelectedIndex()));
            tableViewMenu.setItems(FXCollections.observableArrayList(menuList));
            setUpLimits();

        }else MessageUtils.showMessage("Information", "You must select an item to add to the menu.");
    }


    @FXML
    public void deleteAlimentFromTheMenu(ActionEvent actionEvent) {
        if(tableViewMenu.getSelectionModel().getSelectedItem() != null){
            menuList.remove(tableViewMenu.getItems().get(tableViewMenu.getSelectionModel().getSelectedIndex()));
            tableViewMenu.setItems(FXCollections.observableArrayList(menuList));

        }else MessageUtils.showMessage("Information", "You must select a menu to delete from de list.");
    }


    @FXML
    public void checkMilkSelected(ActionEvent actionEvent) {
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


    @FXML
    public void checkNutsSelected(ActionEvent actionEvent) {
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


    @FXML
    public void checkEggSelected(ActionEvent actionEvent) {
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


    @FXML
    public void checkGlutenSelected(ActionEvent actionEvent) {
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

    public void setUpLimits(){

        double calories, carbo, fat;

        if(tableViewElements.getSelectionModel().getSelectedItem() != null){
            calories = tableViewElements.getSelectionModel().getSelectedItem().getCalories();
            carbo = tableViewElements.getSelectionModel().getSelectedItem().getCarbohydrates();
            fat = tableViewElements.getSelectionModel().getSelectedItem().getFat();
        }
    }
}