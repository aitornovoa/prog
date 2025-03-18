public class Punto{
    
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void desplazamientoHorizontal(double desplazamiento){
        this.x += desplazamiento;
    }

    public void desplazamientoVertical(double desplazamiento){
        this.y += desplazamiento;
    }

    public double distancia(Punto p){
        double distanciaVertical = this.y-p.y;
        double distanciaHorizontal = this.x-p.x;

        double aux = Math.pow(distanciaVertical, 2)+Math.pow(distanciaHorizontal, 2);
        return Math.sqrt(aux);
    }

    public String getPosicion(){
        return "("+this.x+","+this.y+")";
    }




}