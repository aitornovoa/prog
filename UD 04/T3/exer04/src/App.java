public class App {
    public static void main(String[] args) throws Exception {
      
        Banco banco1 = new Banco("Gringotts Wizarding Bank", Pais.ATLANTIDA);
        Banco banco2 = new Banco("Banco de Hierro de Braavos", Pais.UTOPIA);

        Tarjeta tarjetaInvalida1 = new Tarjeta("4539 1488 1343 6467", "06/2030", "Gringotts Wizarding Bank", "Tarjeta Inválida 1");
        Tarjeta tarjetaInvalida2 = new Tarjeta("4539 1488 0343 6467", "", null, null)
    }
}
