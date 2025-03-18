public class Circulo {
    private Punto punto;
    private double radio;


    public Circulo(double puntoX, double puntoY, double radio){
        this.setPunto(new Punto(puntoX, puntoY));
        this.setRadio(radio);
    }

    public Punto getPunto() {
        return punto;
    }
    public void setPunto(Punto punto) {
        this.punto = punto;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getPerimetro(){
        return 2 * Math.PI * this.getRadio();
    }

    public double getArea(){
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

    public void desplazamiento(int x, int y){
        this.punto.desplazamientoHorizontal(x);
        this.punto.desplazamientoVertical(y);
    }

    public boolean esPuntoInterior(Punto punto){
        double distancia = punto.distancia(punto);
        if(distancia>this.radio){
            return false;
        }
        else{
            return true;
        }
    }
}
