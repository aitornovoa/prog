public class App {
    public static void main(String[] args) throws Exception {
        Coche ibiza = new Coche("Seat", "Ibiza", "Rojo");
        Coche leon = new Coche("Seat", "León", "Negro", 3);

        System.out.println(ibiza.getMarca()+" "+ibiza.getModelo()+": "+ ibiza.getColor());
        System.out.println(leon.getMarca()+" "+leon.getModelo()+": "+ leon.getColor());

        leon.setColor("Azul");

        System.out.println(ibiza.getMarca()+" "+ibiza.getModelo()+": "+ ibiza.getColor());
        System.out.println(leon.getMarca()+" "+leon.getModelo()+": "+ leon.getColor());
    }
}
