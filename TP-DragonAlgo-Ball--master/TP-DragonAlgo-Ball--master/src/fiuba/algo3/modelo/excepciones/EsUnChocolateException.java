package fiuba.algo3.modelo.excepciones;

/**
 * Created by nico-ubuntu on 19/06/17.
 */
public class EsUnChocolateException extends RuntimeException {

    public EsUnChocolateException(){};

    public String mensaje(){
        return "Imposible realizar la acción, el personaje es un Chocolate.";
    }
}
