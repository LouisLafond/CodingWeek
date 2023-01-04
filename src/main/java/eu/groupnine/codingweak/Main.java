package eu.groupnine.codingweak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.gson.Gson;

import eu.groupnine.codingweak.stockage.*;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("Hello.fxml"));
        // Scene scene = new Scene(root);

        // primaryStage.setTitle("CodingWeak");
        // primaryStage.setScene(scene);
        // primaryStage.show();
        Model model = new Model();

        SceneController sc = new SceneController();
        model.sc = sc;
        Parent root = sc.addScene("Page", "accueil-view.fxml", new VueAccueilController(model));

        Scene scene = new Scene(root);
        sc.setMain(scene);

        primaryStage.setTitle("CodingWeak");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stockage stockage = new Stockage();
        stockage.init();

        stockage.save();
        
    }
}
