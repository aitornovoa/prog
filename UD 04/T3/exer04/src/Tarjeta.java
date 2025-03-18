import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarjeta {
    private String numTarjeta;
    private String fechaCaducidad;
    private String nombreBanco;
    private String descripcion;
    private boolean valida;

    public Tarjeta(String numTarjeta, String fechaCaducidad, String nombreBanco, String descripcion){
        this.numTarjeta = numTarjeta;
        this.fechaCaducidad = fechaCaducidad;
        this.nombreBanco = nombreBanco;
        this.setDescripcion(descripcion);

        if(!Tarjeta.comprobarNumero(numTarjeta)){
            this.valida = false;
        }
        else{
            LocalDate actual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaVencimiento = "01/"+fechaCaducidad;
            LocalDate fechaCaducidadLocal = LocalDate.parse(fechaVencimiento, formato);
            if(actual.isAfter(fechaCaducidadLocal)){
                this.valida = false;
            }
        }
    }

    public String getNumTarjeta() {
        if(this.valida){
            int bloques = this.numTarjeta.length()/4;
            String numeroFinal = "";
            for(int i=0;i<bloques;i++){
                numeroFinal = numeroFinal+this.numTarjeta.substring(i*4,(i+1)*4)+" ";
            }
            return numeroFinal.substring(0, numeroFinal.length()-1);
        }
        return "Invalida";
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static boolean comprobarNumero(String numero){
        //Comprobar longitud
        if(numero.length()!=16){
            return false;
        }

        //Comprobar que los dígitos sean números
        for(char digito: numero.toCharArray()){
            if(!(digito<=57 && digito>=48)){
                return false;
            }
        }

        //Algoritmo de Lunh
        int suma = 0;
        boolean duplicar = false;
        //Sumar cifras
        for(int i=numero.length()-1;i>=0;i--){
            int digito = Integer.valueOf(numero.charAt(i))-48;
            //Numero que se duplica
            if(duplicar){
                int duplicado = 2*digito;
                //Si duplicado es  >9, tiene dos dígitos
                if(duplicado>9){
                    //La primerca cifra sería 1 y la segunda el resto de dividir entre 10
                    int sumaCifras = 1+(duplicado%10);
                    suma += sumaCifras;
                }
                else{
                    suma += duplicado;
                }
                duplicar = false;
            }
            else{
                suma += digito;
                duplicar = true;
            }
            
        }
        //Comprobar suma
        int resto = suma%10;
        if(resto==0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean esValida(){
        return valida;
    }
}
