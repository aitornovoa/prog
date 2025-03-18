public class Rectangulo{
    private double base;
    private double altura;

    /**
     * 
     * @param base la base del rectangulo
     * @param altura la altura del rectangulo
     */
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    /**
     * Calcula el perimetro de un rectangulo
     * @return el perimetro en cm
     */
    public double getPerimetro(){
        return  (2 * (this.base + this.altura));
    }

    /**
     * Calcula el area de un rectangulo
     * @return la area en cm^2
     */
    public double getArea(){
        return (this.base * this.altura);
    }
}