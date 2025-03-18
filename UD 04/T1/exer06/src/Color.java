public enum Color {
    NEGRO("Negro"),
    BLANCO("Blanco"),
    AZUL("Azul"),
    ROJO("Rojo"),
    VERDE("Verder");

    private String nombreColor;

    Color(String nombreColor){
        this.nombreColor= nombreColor; 
    }

    public String getNombreColor(){
        return nombreColor;
    }
}
