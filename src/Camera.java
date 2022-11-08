public class Camera {

    private Integer coordinateX, coordinateY ; //position de la caméra

    private double vitesse; // vitesse de la caméra
    private double acceleration; // accélération de la camera
    private double k; // raideur du ressort de la camera
    private double m; // masse de la caméra
    private double f; // constante en kg.s-1 -> taux d'accrétion ou émission

    public Camera(Integer x, Integer y){
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public int getCoordinateX(){
        return coordinateX;
    }

    public int getCoordinateY(){
        return coordinateY;
    }


    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }


    public void update(long time, Hero hero){
        //acceleration = k/m*(hero.getX() - coordinateX) + f/m*vitesse;
        //vitesse+= acceleration*0.1;
        //coordinateX+= (int)(vitesse*0.1);


    }

    @Override
    public String toString(){
        return "La camera est localisée en ( "+coordinateX+","+coordinateY+" )";
    }


}

/*

Integer coordinateX
Integer coordinateY

Camera(integer, integer)
getCoordinateX();
getCoordinateY();

 */