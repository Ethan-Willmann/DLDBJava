package Willmann;

import java.util.ArrayList;

/**
 * FirstFX.java
 * CS252
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;

public class WE57FirstFX extends Application {

  /* =======ELEMENT DECLARATION FOR WINDOW========= */

  public void start(Stage stage) {
    stage.setTitle("WE57JavaFX Test - first appp");

    // Labels for state and licences
    Label state = new Label("State:");
    Label license = new Label("License:");
    state.setFont(new Font(20));
    license.setFont(new Font(20));

    // text boxes for state and license
    TextField stateText = new TextField();
    TextField licenseText = new TextField();
    TextArea textBox = new TextArea();
    textBox.setPrefWidth(400);
    textBox.setPrefHeight(400);

    // lists for registers
    ArrayList<WE57License> registers = new ArrayList<WE57License>();

    /* =========REGISTER BUTTON========== */

    // button for register
    Button buttonRegister = new Button("Register");

    // logic for button
    buttonRegister.setOnAction(e -> {

      // get input from text boxes and set to null on click after
      final String NEWSTATE = stateText.getText().toUpperCase();
      final String NEWLICENSE = licenseText.getText().toUpperCase();
      stateText.setText(null);
      licenseText.setText(null);

      // create new license object with new data
      WE57License licenseInfo = new WE57License();

      // logic determining valid entries for state and license format
      if (NEWSTATE.equals("MO") || NEWSTATE.equals("MISSOURI")) {

        if (NEWLICENSE.length() > 3) {
          String first3 = NEWLICENSE.substring(0, 3);
          String last3 = NEWLICENSE.substring(NEWLICENSE.length() - 3, NEWLICENSE.length());

          if (Character.isLetter(first3.charAt(0)) && Character.isLetter(first3.charAt(1))
              && Character.isDigit(first3.charAt(2)) &&
              Character.isLetter(last3.charAt(0)) && Character.isDigit(last3.charAt(1))
              && Character.isLetter(last3.charAt(2)) &&
              (NEWLICENSE.length() == 6 || (NEWLICENSE.length() == 7 && NEWLICENSE.charAt(3) == ' '))) {

            // if valid, add licenseInfo object to registers list and sumbits success
            // message
            String formattedLicense = first3 + " " + last3;
            int i;
            boolean isDuplicate = false;

            for (i = 0; i < registers.size(); ++i) {
              if (formattedLicense.equals(registers.get(i).getLicense())) {
                textBox.setText("This license is already used. Please enter another.");
                isDuplicate = true;

                break;
              }
            }
            if (!isDuplicate) {
              licenseInfo.setState(NEWSTATE);
              licenseInfo.setLicense(NEWLICENSE);
              registers.add(licenseInfo);
              textBox.setText("Data has been added.");
            }

          } else {
            textBox.setText("Error: The format for Missouri license plates is LLD LDL.");
          }

        } else {
          textBox.setText("Error: The format for Missouri license plates is LLD LDL.");
        }

      } else if (NEWSTATE.equals("KANSAS") || NEWSTATE.equals("KS")) {

        if (NEWLICENSE.length() > 3) {

          String first3 = NEWLICENSE.substring(0, 3);
          String last3 = NEWLICENSE.substring(NEWLICENSE.length() - 3, NEWLICENSE.length());

          if (Character.isDigit(first3.charAt(0)) && Character.isDigit(first3.charAt(1))
              && Character.isDigit(first3.charAt(2)) &&
              Character.isLetter(last3.charAt(0)) && Character.isLetter(last3.charAt(1))
              && Character.isLetter(last3.charAt(2))) {

            // if valid, add licenseInfo object to registers list and sumbits success
            // message
            String formattedLicense = first3 + " " + last3;
            int i;
            boolean isDuplicate = false;

            for (i = 0; i < registers.size(); ++i) {
              if (formattedLicense.equals(registers.get(i).getLicense())) {
                textBox.setText("This license is already used. Please enter another");
                isDuplicate = true;

                break;
              }
            }
            if (!isDuplicate) {
              licenseInfo.setState(NEWSTATE);
              licenseInfo.setLicense(NEWLICENSE);
              registers.add(licenseInfo);
              textBox.setText("Data has been added.");
            }

          } else {
            textBox.setText("Error: The format for Kansas license plates is DDD LLL.");
          }

        }

      } else {
        textBox.setText("Not a valid state, please enter MO, KA, Missouri, or Kansas.");
      }

    });

    /* =======PRINT LIST BUTTON========= */

    // button for printing list
    Button buttonPrintList = new Button("Print List");
    buttonPrintList.setOnAction(e -> {
      // get the array list contents of registers and turn them into a string for the
      // textBox
      String registerListString = "";
      int i;

      for (i = 0; i < registers.size(); ++i) {
        registerListString += registers.get(i).getState() + " " + registers.get(i).getLicense() + "\n";
      }
      textBox.setText(registerListString);

    });

    buttonRegister.setFont(new Font(10));

    buttonPrintList.setFont(new Font(10));

    /* =======WINDOW SETUP========= */

    // header box containing labels and fields for state and license
    HBox header = new HBox();
    header.getChildren().addAll(state, stateText, license, licenseText, buttonRegister, buttonPrintList);
    Insets itemPadding = new Insets(10);
    header.setPadding(itemPadding);

    // setting padding for header elements
    state.setPadding(itemPadding);
    stateText.setPadding(itemPadding);
    license.setPadding(itemPadding);
    licenseText.setPadding(itemPadding);
    buttonRegister.setPadding(itemPadding);
    buttonPrintList.setPadding(itemPadding);

    // adding new borderpane to contain the header and text box
    BorderPane miPane = new BorderPane();
    miPane.setTop(header);
    miPane.setCenter(textBox);

    Scene scene = new Scene(miPane, 640, 480);
    stage.setScene(scene);

    stage.show();
  } // end start()

  public static void main(String[] args) {
    launch(args);
  }

} // end class FirstFX
