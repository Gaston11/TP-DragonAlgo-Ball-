package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Consumible;
import fiuba.algo3.modelo.Componentes.Ubicable;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.PersonajeEstaMuertoException;

public abstract class Personaje implements Ubicable, UbicableV2 {
    protected int maxVida;
    protected int vida;
    protected int ki;
    protected int kiPorTurno = 5;
    protected Coordenada coordenada;
    protected int vidaCritica;
    protected VersorDireccion versorPersonaje;

    public void naceEn(Coordenada coordenada){

        this.coordenada = coordenada;
        this.versorPersonaje = new VersorDireccion(this.coordenada);
    }

    public boolean estaUbicadoEn(Coordenada coordenada){
        
    	return (this.coordenada.getCoordenadaX() == coordenada.getCoordenadaX()  &&
    			this.coordenada.getCoordenadaY() == coordenada.getCoordenadaY() );
    }

    public boolean poseeKi(int ki){
        return (this.ki==ki);
    }

    public boolean poseeVida(int vida){
        return (this.vida == vida);
    }

    public abstract void mover(Coordenada coordenada);

    public void consumir(Consumible consumible){
        this.aumentarVida(consumible.aumentarVida());
        this.obtenerConsumible(consumible);
    }

    protected abstract void obtenerConsumible(Consumible consumible);


    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
    }

    public void recibirDanio(int ataque){
        if(vida<=0){
            throw new PersonajeEstaMuertoException();
        }
        this.vida -= ataque;
    }

    public int getVida() {
        return this.vida;
    }

    public int getKi(){
        return this.ki;
    }

    public abstract void volverAlEstadoAnterior(Estado estado);


    public void aumentarVida(int cantidad){
        this.vida = (maxVida < this.vida + cantidad)? maxVida : this.vida + cantidad;
    }

    public abstract boolean ataqueBasico(PersonajeBueno enemigo);

    public abstract boolean ataqueBasico(PersonajeMalo enemigo);

    public abstract boolean ataqueEspecial(PersonajeMalo enemigo);

    public abstract boolean ataqueEspecial(PersonajeBueno enemigo);

    public abstract Coordenada moverArriba();

    public abstract Coordenada moverAbajo();

    public abstract Coordenada moverAIzquierda();

    public abstract Coordenada moverADerecha();

    public abstract Coordenada moverASuperiorIzquierda();

    public abstract Coordenada moverASuperiorDerecha();

    public abstract Coordenada moverAInferiorIzquierda();

    public abstract Coordenada moverAInferiorDerecha();

    public abstract int getPoderPelea();

    public boolean estaMuerto() {
        return this.vida<=0;
    }

    @Override
    public Coordenada getCoordenada(){
        return this.coordenada;
    }

    @Override
    public boolean esUnPersonaje(){
        return true;
    }
}