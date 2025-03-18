public class App {
    public static void main(String[] args) throws Exception {
        Cuadrado c1 = new Cuadrado(9.3, UnidadDistancia.KM);
        Cuadrado c2 = new Cuadrado(1.5);

        System.out.println("El area del primer cuadrado es " + c1.getArea(UnidadDistancia.DM));
        System.out.println("El area del segundo cuadrado es " + c2.getArea(UnidadDistancia.DM));

        System.out.println("El perimetro del primer cuadrado es " + c1.getPerimetro(UnidadDistancia.CM));
        System.out.println("El perimetro del segundo cuadrado es " + c2.getPerimetro(UnidadDistancia.CM));
    }
}
