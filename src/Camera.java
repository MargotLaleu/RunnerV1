public class Camera {

    private double coordinateX, coordinateY ; //position de la caméra

    private double vitesse=5; // vitesse de la caméra
    private double acceleration; // accélération de la camera
    private double timeTampon =0;
    private double k = 5; // raideur du ressort de la camera
    private double m = 5; // masse de la caméra
    private double f = 6; // constante en kg.s-1 -> taux d'accrétion ou émission

    public Camera(double x, double y){
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public double getCoordinateX(){
        return coordinateX;
    }

    public double getCoordinateY(){
        return coordinateY;
    }


    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }


    public void update(long time, Hero hero) {
        double deltaT = (time - timeTampon)/(1000000000); // la division sert à mettre deltaT en s (nécessaire pour les equations ci-dessous)

        if(timeTampon != 0 ){
        acceleration = k/m*(hero.getX() - this.coordinateX) - f/m*vitesse;
        vitesse+= acceleration*deltaT;
        this.coordinateX =  (this.coordinateX + vitesse*deltaT);

        }
        timeTampon = time;



        System.out.println(toString());

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