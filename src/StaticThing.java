import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StaticThing {

    private double sizeX;
    private double sizeY;
    private ImageView desert;

    public ImageView getDesert() {
        return desert;
    }

    public StaticThing(String fileName, double x){
        Image fichierDesert = new Image(fileName);  //ouverture du fichier png
        desert = new ImageView(fichierDesert);      //chargement de l'image
        desert.setViewport(new Rectangle2D(0, 50,800,300)); //découpage de l'image aux dimensions souhaitées
        desert.setX(x); // établie l'abscisse auquel va démarrer la portion d'image séléctionnée
    }


    public StaticThing(String fileName, double x, double y){
        this.sizeX = x;
        this.sizeY = y;

        Image fichierDesert = new Image(fileName);
        desert = new ImageView(fichierDesert);
    }
}
