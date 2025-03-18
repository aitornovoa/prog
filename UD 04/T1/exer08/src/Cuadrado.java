public class Cuadrado {
    private double lado;

    /**
     * 
     * @param lado en metros
     */
    public Cuadrado(double lado){
        this.setLado(lado, UnidadDistancia.M);
    }

    /**
     * 
     * @param lado
     * @param unidad
     */
    public Cuadrado(double lado, UnidadDistancia unidad){
        this.setLado(lado, unidad);
    }

    public double getLado(){
        return lado;
    }

    public void setLado(double lado, UnidadDistancia unidad){
        if (unidad == UnidadDistancia.CM){
            this.lado = lado/100;
        }
        else if(unidad == UnidadDistancia.DM){
            this.lado = lado/10;
        }
        else if(unidad == UnidadDistancia.KM){
            this.lado = lado*1000;
        }
        else{
            this.lado = lado;
        }
    }

    /**
     * Metodo para calcular el perimetro
     * @param unidad en que se devuelve
     * @return
     */
    public double getPerimetro(UnidadDistancia unidad){
        if (unidad==UnidadDistancia.CM){
            return this.lado*100*4;
        }
        else if (unidad==UnidadDistancia.DM){
            return this.lado*10*4;
        }
        else if(unidad==UnidadDistancia.KM){
            return this.lado/1000*4;
        }
        else{
            return this.lado*4;
        }
    }

    /**
     * Metodo para calcular el area
     * @param unidad
     * @return
     */
    public double getArea(UnidadDistancia unidad){
        if (unidad==UnidadDistancia.CM){
            return (this.lado*100)*(this.lado*100);
        }
        else if (unidad==UnidadDistancia.DM){
            return (this.lado*10)*(this.lado*10);
        }
        else if(unidad==UnidadDistancia.KM){
            return (this.lado/1000)*(this.lado/1000);
        }
        else{
            return this.lado * this.lado;
        }
    }
}
