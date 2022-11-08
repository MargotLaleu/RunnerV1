import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// L'axe des y est positif vers le bas et l'origine du repère se trouve dans le coin supérieur gauche de l'écran

// Cette classe est abstraite pour ensuite permettre aux hero et ennemi d'hériter d'une autre classe
abstract public class AnimatedThing {

    private double x;
    private double y;  //coordonées de la position du personnage
    private Integer attitude; //attitude du personnage
    private ImageView spriteSheet;

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }

    public double getX(){
        return x;
    }


    public double getY() {
        return y;
    }


    private Integer index=1;  //Index de l'image de la spritesheet que l'on veut afficher
    private long betweenDuration = 50000000; // temps entre 2 frames
    private long timeTampon; // mémoire tampon pour évaluer le temps avant de passer à la frame suivante
    private Integer maxIndex = 6; //Index maximum sur la spriteSheet
    private Integer xFenetre, yFenetre;
    private Integer offset = 200; //offset du héros sur l'écran pour qu'il ne soit pas collé au bord gauche


    public AnimatedThing(String fileName, Integer index ){
        Image fichierHeros = new Image(fileName);
        spriteSheet = new ImageView(fichierHeros);
        spriteSheet.setViewport(new Rectangle2D(85*index, 0, 85, 100));

        spriteSheet.setX(offset);  //position initiale du personnage
        spriteSheet.setY(y+193); //+193 afin que le héro ait les pieds au sol mais ne soit pas collé au bas de l'écran


    }


    public void update(long time){  //time est le temps actuellement écoulé depuis le démarrage du timer
        if(time-timeTampon > betweenDuration){  //time-timeTampon est le temps écoulé depuis le dernier cha,gement de frame
            index++;  // index de la sprite suivante
            index = index%maxIndex; //en restant sur l'une des 6 sprites possibles

            spriteSheet.setViewport(new Rectangle2D(85*index, 0, 85, 100)); //on passe à la sprite suivante
            timeTampon = time; // on actualise la mémoire tampon (on néglige le temps d'exécution de cette boucle if)

        }
    }


}
