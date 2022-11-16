import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

@Override
    public void start(Stage primaryStage) throws Exception{

    primaryStage.setTitle("Hello World");
    Group root = new Group();
    //Pane pane = new Pane(root);


    GameScene gameScene = new GameScene(100, 50, root );
    primaryStage.setScene(gameScene);


    System.out.println(gameScene);
    //gameScene.render(300, 50);

    primaryStage.show();
}

    public static void main(String[] args){
        launch(args);

    }

}
