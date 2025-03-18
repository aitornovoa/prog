public class Empleado{
    private static double IRPF = 0.15;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double salarioBruto;
    private boolean dniAnhadido;

    /**
     * 
     * @param dni
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param salarioBruto
     */
    public Empleado(String dni, String nombre, String apellido1, String apellido2, double salarioBruto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.salarioBruto = salarioBruto;
    }

    /**
     * No tiene apellido1, se asigna ""
     * @param dni
     * @param nombre
     * @param apellido1
     * @param salarioBruto
     */
    public Empleado(String dni, String nombre, String apellido1, double salarioBruto){
        this(dni, nombre, apellido1, "", salarioBruto);
    }

    /**
     * No tiene dni ni apellido2, se les asigna ""
     * @param nombre
     * @param apellido1
     * @param salarioBruto
     */
    public Empleado(String nombre, String apellido1, double salarioBruto){
        this("", nombre, apellido1, "", salarioBruto);
    }

    /**
     * Valida el dni
     * @param dni
     * @return un booleano, true si es válido, sino false
     */
    private boolean validarDNI(String dni){
        //Comprobar longitud dni
        if (dni.length() != 9){
            return false;
        }

        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        //Comprobar que numeros son caracteres de números
        for (int i=0;i<numeros.length();i++){
            if (!((int)numeros.charAt(i)>= (int)'0' && (int)numeros.charAt(i)<= (int)'9')){
                return false;
            }
        }

        //Comprobar que la letra sea mayuscula
        if (!((int)letra >= (int)'A' && (int)letra<='Z')){
            return false;
        }

        //Comprobar que la letra sea correcta
        int numero = Integer.valueOf(numeros);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero%letras.length();
        char letraReal = letras.charAt(resto);

        if(letra != letraReal){
            return false;
        }

        return true;
    }

    public String getDni() {
        if(this.dniAnhadido){
            return this.dni;
        }
        return "Sin informacion";
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Encadenar apellidos
     * @return apellidos encadenados
     */
    public String getApellidos() {
        return this.apellido1 + " " + this.apellido2;
    }

    public double getSalarioNeto(){
        return this.salarioBruto*(1.0- Empleado.IRPF);
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    /**
     * Añade el dni si es válido
     * @param dni
     */
    public void setDni(String dni) {
        if(this.validarDNI(dni)){
            this.dni = dni;
            this.dniAnhadido = true;
        }
        else{
            this.dniAnhadido=false;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    
}