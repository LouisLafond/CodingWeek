package eu.groupnine.codingweak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import com.google.gson.Gson;

import eu.groupnine.codingweak.stockage.*;
import eu.groupnine.codingweak.MenuViewController;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Model model = new Model();
        MenuViewController.setModel(model);
        MenuViewController.stage = primaryStage;
        SceneController sc = new SceneController();
        model.sc = sc;
        Parent root = sc.addScene("Page", "accueil-view.fxml", new VueAccueilController(model));
        sc.addScene("Jeu", "VueQuestionReponse.fxml", new VueQuestionController(model));
        sc.addScene("Reglage", "VueReglage.fxml", new VueReglageController(model));
        sc.addScene("Jouer", "VueJouer.fxml", new VueJouerController(model));
        sc.addScene("StatPartie", "VueStatPartie.fxml", new VueStatPartieController(model));
        sc.addScene("StatGlobal", "VueStatGlobal.fxml", new VueStatGlobalController(model));
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        sc.setMain(scene, "Page");

        primaryStage.setTitle("CodingWeak");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
}
