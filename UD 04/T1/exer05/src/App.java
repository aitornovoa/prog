public class App {
    public static void main(String[] args) throws Exception {     
        
        // Creamos os rectangulos (metemos todo en cm)
        Alumno al1 = new Alumno("Manuel", "Varela");
        Alumno al2 = new Alumno("Jhon", "Doe");

        // Metemos as notas medias de al1
        al1.setNota1Trimestre(7);
        al1.setNota2Trimestre(4);

        String mensaxe = "";

        // Imprimimos os datos de al1
        // mensaxe = al1.getApellidos() + ", " + al1.getNombre() + " con exp. " +
        //     al1.getNumExpediente() + " con nota " + al1.getMedia();
        System.out.println(al1);

        // Imprimimos se al1 está aprobado ou non
        if (al1.estaAprobado()) {
            System.out.println("Aprobado\n");
        }
        else {
            System.out.println("Suspenso\n");
        }

        // Poeñmos outra nota de al1 e imprimimos
        al1.setNota3Trimestre(9);
       
        System.out.println(al1);
        if (al1.estaAprobado()) {
            System.out.println("Aprobado\n");
        }
        else {
            System.out.println("Suspenso\n");
        }

        // Imprimimos os datos de manuel
        System.out.println(al2);
    }

}