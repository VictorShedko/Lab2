package sample.Veiv;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Control.Controller;


public class View extends Application {
    private Controller myController;
    private final static String RANDOM_REQUEST = "random";
    private final static String ADDER_REQUEST = "add";
    private final static String SUBTRACTOR_REQUEST = "sub";
    AnchorPane forum= new AnchorPane();
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();


            Button createMessageButton = new Button("Write");
            Button loginButton = new Button("Sig in");



            TextField inputMessage = new TextField();
            TextField loginTextFild = new TextField();


            AnchorPane.setBottomAnchor(createMessageButton, 70.0);
            AnchorPane.setTopAnchor(createMessageButton, 400.0);
            AnchorPane.setRightAnchor(createMessageButton, 30.0);
            AnchorPane.setLeftAnchor(createMessageButton, 600.0);

            AnchorPane.setBottomAnchor(loginTextFild, 540.0);
            AnchorPane.setTopAnchor(loginTextFild, 30.0);
            AnchorPane.setRightAnchor(loginTextFild, 100.0);
            AnchorPane.setLeftAnchor(loginTextFild, 600.0);


            AnchorPane.setBottomAnchor(loginButton, 540.0);
            AnchorPane.setTopAnchor(loginButton, 30.0);
            AnchorPane.setRightAnchor(loginButton, 30.0);
            AnchorPane.setLeftAnchor(loginButton, 700.0);


            AnchorPane.setBottomAnchor(forum, 250.0);
            AnchorPane.setTopAnchor(forum, 100.0);
            AnchorPane.setRightAnchor(forum, 30.0);
            AnchorPane.setLeftAnchor(forum, 30.0);
//////////////////////
            AnchorPane.setBottomAnchor(inputMessage, 30.0);
            AnchorPane.setTopAnchor(inputMessage, 400.0);
            AnchorPane.setRightAnchor(inputMessage, 250.0);
            AnchorPane.setLeftAnchor(inputMessage, 40.0);













            root.getChildren().add(inputMessage);
            root.getChildren().add(loginTextFild);
            root.getChildren().add(createMessageButton);

            root.getChildren().add(forum);
            root.getChildren().add(loginButton);



            //TextField Message = new TextField();
          //  AnchorPane.setBottomAnchor(Message, 0.0);
            //AnchorPane.setTopAnchor(Message, 0.0);
          //  AnchorPane.setRightAnchor(Message, 0.0);
           // AnchorPane.setLeftAnchor(Message, 0.0);
           // forum.getChildren().add(Message);

            createMessageButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {


                myController.addMessage(inputMessage.getText());

                    View.this.rebuildForum();
                }
            });
            loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {


                    myController.sigIn(loginTextFild.getText());
                    View.this.rebuildForum();

                }
            });






            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Random Wandering");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public View() {
        this.myController= new Controller();

    }


    private void rebuildForum(){
        if(this.myController.getMode()==0) {
            ArrayList<String> MessageList = this.myController.getMessages(3);
            forum.getChildren().clear();
            for (int i = 0; i < MessageList.size(); i++) {
                Label tempMessage = new Label(MessageList.get(i));

                AnchorPane.setBottomAnchor(tempMessage, 25.0 + 50 * i);
                AnchorPane.setTopAnchor(tempMessage, 250 - 25.0 - 50 * i - 50);
                AnchorPane.setRightAnchor(tempMessage, 20.0);
                AnchorPane.setLeftAnchor(tempMessage, 20.0);


                forum.getChildren().add(tempMessage);
            }
        }
        if(this.myController.getMode()==1) {
            ArrayList<String> MessageList = this.myController.getMessages(3);


            forum.getChildren().clear();
            TextField delNumber = new TextField();
            Button delButton = new Button("del");

            AnchorPane.setBottomAnchor(delNumber, 200.0);
            AnchorPane.setTopAnchor(delNumber, 0.0);
            AnchorPane.setRightAnchor(delNumber, 20.0);
            AnchorPane.setLeftAnchor(delNumber, 600.0);

            AnchorPane.setBottomAnchor(delButton, 200.0);
            AnchorPane.setTopAnchor(delButton, 0.0);
            AnchorPane.setRightAnchor(delButton, 80.0);
            AnchorPane.setLeftAnchor(delButton, 500.0);


            delButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {


                    myController.dellMessage(Integer.parseInt(delNumber.getText()));

                    View.this.rebuildForum();


                }
            });


            forum.getChildren().add(delButton);

            forum.getChildren().add(delNumber);


            for (int i = 0; i < MessageList.size(); i++) {
                Label tempMessage = new Label(MessageList.get(i));



                AnchorPane.setBottomAnchor(delButton, 25.0 + 50 * i);
                AnchorPane.setTopAnchor(delButton, 250 - 25.0 - 50 * i - 50);
                AnchorPane.setRightAnchor(delButton, 20.0);
                AnchorPane.setLeftAnchor(delButton, 600.0);

                AnchorPane.setBottomAnchor(tempMessage, 25.0 + 50 * i);
                AnchorPane.setTopAnchor(tempMessage, 250 - 25.0 - 50 * i - 50);
                AnchorPane.setRightAnchor(tempMessage, 80.0);
                AnchorPane.setLeftAnchor(tempMessage, 20.0);


                forum.getChildren().add(tempMessage);


            }
        }
    }




}