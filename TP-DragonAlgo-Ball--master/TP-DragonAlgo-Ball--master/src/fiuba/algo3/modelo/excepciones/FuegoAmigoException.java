package fiuba.algo3.modelo.excepciones;

/**
 * Created by nico on 18/06/17.
 */
public class FuegoAmigoException extends RuntimeException{

    public FuegoAmigoException(){}

    public String mensaje(){
        return "Ataque fallido, no puede atacar a un amigo.";
    }
}
