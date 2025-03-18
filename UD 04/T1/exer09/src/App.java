import concesionario.Vehiculo;
import utils.TipoCombustible;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 0
        
        Vehiculo leon = new Vehiculo("1234CGF", "SEAT", "León");
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 1
        //Modifiqué la matrúcla para que diera el resultado de 0000XXX al mostrar por pantalla, ya que 6894DEF como matrícula está bien
        Vehiculo c3 = new Vehiculo("6894DEF", "Citroen", "C3", TipoCombustible.ELECTRICO);
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 2

        System.out.println(leon.getMatricula() + " " + leon.getCombustible()); // 1234CGF GASOLINA
        System.out.println(c3.getMatricula() + " " + c3.getCombustible()); // 0000XXX ELECTRICO

        leon.acelerar(20);
        leon.acelerar();
        System.out.println(leon.getVelocidad()); // 30.0

        leon.acelerar(100);
        System.out.println(leon.getVelocidad()); // 120.0

        leon.decelerar();
        leon.decelerar(200);
        System.out.println(leon.getVelocidad()); // 0.0

        Vehiculo.setVelocidadMaxima(130);

        leon.acelerar(125);
        System.out.println(leon.getVelocidad()); // 125.0

    }

}