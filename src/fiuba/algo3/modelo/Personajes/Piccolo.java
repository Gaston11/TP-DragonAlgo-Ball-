package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosPiccolo.*;

public class Piccolo extends Personaje implements PersonajeBueno {

    private Estado estado;
    private int kiNecesario;

    public Piccolo(){

        vida = 500;
        ki =0;
        kiNecesario = 10; // para realizar el ataque especial
        vidaCritica = 150; //30% de la vida inicial
        estado = new EstadoNormal();
    }

    public void transformarse(Gohan gohan){
        estado = estado.transformarse(gohan,this.ki);
        this.ki-= estado.costoDeTransformacion();
    }


    @Override
    public void ataqueBasico(PersonajeMalo enemigo){
        estado.ataqueBasico(enemigo,this);
    }

    @Override
    public void ataqueBasico(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    public void makankosappo(PersonajeMalo enemigo){

        if (ki < kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        this.ki -= kiNecesario;
        estado.ataqueEspecial(enemigo,this);
    }

    public void makankosappo(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void convertimeEnChocolate(){
        this.estado = new EstadoChocolate(estado);
    }

    @Override
    public void volverAlEstadoAnterior(Estado estado){

    }

    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAbajo(){
        Coordenada unaCoordenada = this.estado.moverAbajo(this.versorPersonaje);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAIzquierda(){
        Coordenada unaCoordenada = this.estado.moverAIzquierda(this.versorPersonaje);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverADerecha(){
        Coordenada unaCoordenada = this.estado.moverADerecha(this.versorPersonaje);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorIzquierda(){
        Coordenada unaCoordenada = this.estado.moverASuperiorIzquierda(this.versorPersonaje);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorDerecha(){
        Coordenada unaCoordenada = this.estado.moverASuperiorDerecha(this.versorPersonaje);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAInferiorIzquierda(){
        Coordenada unaCoordenada = this.estado.moverAInferiorIzquierda(this.versorPersonaje);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAInferiorDerecha(){
        Coordenada unaCoordenada = this.estado.moverAInferiorDerecha(this.versorPersonaje);
        return unaCoordenada;
    }
}