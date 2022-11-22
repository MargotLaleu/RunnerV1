import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {

    private Camera camera ;
    private StaticThing rightBackground;
    private StaticThing leftBackground;
    private Hero hero;

    private long timeTampon=0;


    public GameScene(double x, double y, Group p){
        super(p, 800, 300);
        this.camera = new Camera(x,y);  //position initiale de la camera
        leftBackground = new StaticThing("desert.png", 0);  //on crée un découpage de desert que l'on affichera à gauche en tant que background de notre runner, qui s'affiche en x=0
        rightBackground = new StaticThing("desert.png", 800); //on crée un découpage de desert que l'on affichera à droite en tant que background de notre runner, qui s'affiche en x=800
        p.getChildren().add(rightBackground.getDesert()); // on ajoute les 2 morceaux de notre background au Group
        p.getChildren().add(leftBackground.getDesert());

        hero = new Hero("heros.png", 1); //on crée notre héro dans sa position initiale
        p.getChildren().add(hero.getSpriteSheet()); // on ajoute le héro au Group

        timer.start();  // démarrage du timer


        this.setOnMouseClicked( (event)->{     // execute les lignes de code suivante à chaque clique de la souris
            System.out.println("Jump");
            hero.jump();
        });



    }

    public void render(double xCamNew, double yCamNew){

        camera.setCoordinateX(xCamNew); //change les coordonnées de notre camera
        camera.setCoordinateY(yCamNew);

        leftBackground.getDesert().setX(camera.getCoordinateX()); //modification de l'affichage en fonction des coordonées de la camera
        rightBackground.getDesert().setX(-(800-camera.getCoordinateX()));

    }


    public void update(long time){

        //if(time-timeTampon > 100000000) {
            //camera.setCoordinateX((camera.getCoordinateX() + 10)%800) ;


            leftBackground.getDesert().setX(-(camera.getCoordinateX() % 800));  // positionement du paysage suivant les
            rightBackground.getDesert().setX(800 - (camera.getCoordinateX() % 800)); // mouvements de la camera


            //leftBackground.getDesert().setX((-camera.getCoordinateX())%800);
            //rightBackground.getDesert().setX((800 - camera.getCoordinateX())%800);

           // timeTampon = time;

        //}

        hero.getSpriteSheet().setX(150 + (hero.getX()-camera.getCoordinateX())); //affichage du héro à l'écran, suivant les modifications

        hero.getSpriteSheet().setY(hero.getY()); // de sa position en x et en y

        System.out.println("xh-xc = "+ 150+(hero.getX()-camera.getCoordinateX()));


    }



    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {      // appelle les fonctions suivante périodiquement à intervalle de temps très court
            hero.update(time);
            camera.update(time, hero);
            update(time);
        }
    };






    @Override
    public String toString(){
        return "Ma gameScene possède une caméra de coordonées ("+camera.getCoordinateX()+" , "+camera.getCoordinateY()+" )";
    }

}
