public class App {
    public static void main(String[] args) throws Exception {
        Portatil portatil1 = new Portatil("iMac", "176134A", Color.VERDE);

        System.out.println(portatil1.getModelo()+", "+portatil1.getNumSerie()+", "+portatil1.getColor());

        portatil1.setColor(Color.NEGRO);

        System.out.println(portatil1.getModelo()+", "+portatil1.getNumSerie()+", "+portatil1.getColor());

    }
}
    