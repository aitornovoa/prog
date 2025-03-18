public class App {
    public static void main(String[] args) throws Exception {
       Empleado emp1 = new Empleado("55026812R", "Manuel", "Varela", "López", 1500);

       System.out.println("El dni del empleado es " + emp1.getDni());
       emp1.setDni("55026811R");

       System.out.println(emp1.getApellidos()+", "+emp1.getNombre()+" con DNI "+emp1.getDni()+" tiene un salario neto de "+emp1.getSalarioNeto()+"€");

    }
}
