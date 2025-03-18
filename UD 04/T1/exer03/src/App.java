public class App {
    public static void main(String[] args) throws Exception {
        Rectangulo r1 = new Rectangulo(7.5, 3);
        Rectangulo r2 = new Rectangulo(10, 5);

        System.out.println("El perímetro del primer rectángulo es " + r1.getPerimetro()+"cm");
        System.out.println("El perímetro del segundo rectángulo es " + r2.getPerimetro()+"cm");

        System.out.println("El área del primer rectángulo es " + r1.getArea()+"cm^2");
        System.out.println("El área del segundo rectángulo es " + r2.getArea()+"cm^2");
    }
}
