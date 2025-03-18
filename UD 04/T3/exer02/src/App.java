public class App {
    public static void main(String[] args) throws Exception {
 
        Circulo c1 = new Circulo(10, 25, 5);
        System.out.println("El perímetro del círculo es "+c1.getPerimetro());
        System.out.println("La área del círculo es "+c1.getArea());

        System.out.println(c1.esPuntoInterior(new Punto(12, 11)));

        c1.desplazamiento(5,-10);
        System.out.println(c1.esPuntoInterior(new Punto(12, 11)));
    }
}
