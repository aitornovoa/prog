package concesionario;

import utils.TipoCombustible;

public class Vehiculo {
    
    private static int numVehiculos = 0;
    private static double velocidadMaxima = 120.0;

    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible combustible;
    private double velocidad;

    /**
     * Constructor, se inicializa la velocidad a 0.0 y se incrementa el número de vehículos cada vez que se crea imo
     * @param matricula
     * @param marca
     * @param modelo
     * @param tipo
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipo){
        this.setMatricula(matricula);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCombustible(tipo);
        this.velocidad = 0.0;
        numVehiculos++;
    }

    /**
     * Constructor, se inicializa el combustible a Gasolina
     * @param matricula 
     * @param marca
     * @param modelo
     */
    public Vehiculo(String matricula, String marca, String modelo){
        this(matricula, marca, modelo, TipoCombustible.GASOLINA);
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de la matrícula, donde se llama al método compobar matrícula
     * @param matricula
     */
    public void setMatricula(String matricula){
        if(!comprobarMatricula(matricula)){
            this.matricula="0000XXX";
        }
        else{
            this.matricula = matricula;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible tipo){
        this.combustible = tipo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    /**
     * Setter de la velocidad máxima
     * @param velocidadMaxima
     */
    public static void setVelocidadMaxima(double velocidadMaxima){
        Vehiculo.velocidadMaxima=velocidadMaxima;
    }

    /**
     * Método para conseguir el número total de vehículos
     * @return el número de vehículos
     */
    public static int getNumeroTotalVehiculos() {
        return Vehiculo.numVehiculos;
    }

    /**
     * Método para comprobar que la matrícula sea correcta
     * @param matricula
     * @return true si es correcta, sino es false
     */
    private static boolean comprobarMatricula(String matricula){
        String letras ="BCDFGHJKLMNÑPQRSTWXYZ";
        if(matricula.length()!=7){
            return false;
        }
        //Divido la matrícula en 2, una parte para los números y otra para las letras
        String numerosMatricula = matricula.substring(0, 4);
        String letrasMatricula = matricula.substring(4, 7);

        //Recorro la parte de números, y compruebo que son caracteres numéricos
        for(int i=0;i<numerosMatricula.length();i++){
            if(!((int)numerosMatricula.charAt(i)>=(int)'0' && (int)numerosMatricula.charAt(i)<=(int)'9')){
                return false;
            }
        }

        //Recorro la primero parte de letras, y luego el string de consonantes, y los comparo para ver que no haya vocales
        for(int i=0;i<letrasMatricula.length();i++){
            for(int j=0;i<letras.length();i++){
                if(letrasMatricula.charAt(i)!=letras.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Método para modificar la velocidad, comoprobando que no sea mayor que 120 o menor que 0
     * @param cambio
     */
    private void modificarVelocidad(double cambio){
        if (this.velocidad+cambio>velocidadMaxima){
            this.velocidad=velocidadMaxima;
        }
        else if(this.velocidad+cambio<0){
            this.velocidad=0;
        }
        else{
            this.velocidad+=cambio;
        }
        //Línea que puse para comprobar que la velocidad iba bien cuando llamaba a los métodos de acelerar y deceñ
        // System.out.println("La velocidad es "+velocidad); 
    }

    /**
     * Método para aumentar la velocidad en 10, llamando al método privado modificarVelocidad
     */
    public void acelerar(){
        modificarVelocidad(10);
    }

    /**
     * /**
     * Método para aumentar la velocidad en el parametro introducido, llamando al método privado modificarVelocidad
     * @param velocidadIntroducida
     */
    public void acelerar(double velocidadIntroducida){
        modificarVelocidad(velocidadIntroducida);
    }

    /**
     * Método para reducir la velocidad en 10, llamando al método privado modificarVelocidad
     */
    public void decelerar(){
        modificarVelocidad(-10);
    }

    /**
     * /**
     * Método para aumentar la velocidad en el parametro introducido, llamando al método privado modificarVelocidad
     * @param velocidadIntroducida
     */
    public void decelerar(double velocidadIntroducida){
        modificarVelocidad(-velocidadIntroducida);
    }
}
