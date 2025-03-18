import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Wallet {
    
    private HashMap<String, ArrayList<Tarjeta>> tarjetas;

    public Wallet(){
        this.tarjetas = new HashMap<String, ArrayList<Tarjeta>>();
    }

    public void crearCategoria(String categoria){
        if(!this.tarjetas.containsKey(categoria)){
            this.tarjetas.put(categoria, new ArrayList<Tarjeta>());
        }
    }

    public ArrayList<String> getCategorias(){
        return new ArrayList<>(this.tarjetas.keySet());
    }

    public void anhadirTarjeta(String categoria, Tarjeta tarjeta){
        if(!tarjeta.esValida()){
            return;
        }
        else{
            if(this.tarjetas.containsKey(categoria)){
                this.tarjetas.get(categoria).add(tarjeta);
            }
        }
    }

    public ArrayList<Tarjeta> getTarjetaBanco(Banco banco){
        ArrayList<Tarjeta> tarjetasBanco = new ArrayList<Tarjeta>();

        ArrayList<String> categorias = getCategorias();
        for(String categoria : categorias){
            for(Tarjeta tarjeta : this.tarjetas.get(categoria)){
                if(tarjeta.getNombreBanco().equals(banco)){
                    tarjetasBanco.add(tarjeta);
                }
            }
        }
        return tarjetasBanco;
    }

    public ArrayList<Tarjeta> getTarjetaCategoria(String categoria){
        if (!this.tarjetas.containsKey(categoria)) {
            return new ArrayList<Tarjeta>();
        }
        return this.tarjetas.get(categoria);
    }
}
