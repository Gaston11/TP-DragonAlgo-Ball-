package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosPiccolo.*;

public class Piccolo extends Personaje implements PersonajeBueno {

    private Estado estado;
    private int kiNecesario;

    public Piccolo(){
        maxVida = 500;
        vida = maxVida;
        ki =0;
        kiNecesario = 10; // para realizar el ataque especial
        vidaCritica = 150; //30% de la vida inicial
        estado = new EstadoNormal();
    }

    public void transformarse(Personaje gohan){
        estado = estado.transformarse(gohan,this.ki);
        this.ki-= estado.costoDeTransformacion();
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea){
        return estado.poseeMayorPoderPelea(poderPelea);
    }

    @Override
    public int calcularDistanciaDesde(Coordenada otraCoordenada){
        return this.coordenada.obtenerDistancia(otraCoordenada);
    }


    @Override
    public void ataqueBasico(PersonajeMalo enemigo){
        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        estado.ataqueBasico(enemigo,this);
    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo) {
        this.makankosappo(enemigo);
    }

    @Override
    public void transformar(Personaje goku, Personaje gohan, Personaje piccolo) {
        this.transformarse(gohan);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo) {
        this.makankosappo(enemigo);
    }

    @Override
    public void ataqueBasico(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    public void makankosappo(PersonajeMalo enemigo){

        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
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
    public void mover(Coordenada coordenada) {
        this.coordenada = this.estado.obtenerCoordenadaValida(this.coordenada,coordenada);
        this.versorPersonaje = new VersorDireccion(coordenada);
        this.ki += this.kiPorTurno;
    }

    @Override
    public void obtenerConsumible(Consumible consumible) {
        Estado estadoNuevo = consumible.agregarEstado(estado,this);
        estado = estadoNuevo;
    }

    @Override
    public void volverAlEstadoAnterior(Estado estado){

    }

    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAbajo(){
        Coordenada unaCoordenada = this.estado.moverAbajo(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAIzquierda(){
        Coordenada unaCoordenada = this.estado.moverAIzquierda(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverADerecha(){
        Coordenada unaCoordenada = this.estado.moverADerecha(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorIzquierda(){
        Coordenada unaCoordenada = this.estado.moverASuperiorIzquierda(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorDerecha(){
        Coordenada unaCoordenada = this.estado.moverASuperiorDerecha(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAInferiorIzquierda(){
        Coordenada unaCoordenada = this.estado.moverAInferiorIzquierda(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAInferiorDerecha(){
        Coordenada unaCoordenada = this.estado.moverAInferiorDerecha(this.versorPersonaje);
        this.mover(unaCoordenada);
        return unaCoordenada;
    }

    @Override
    public int getPoderPelea() {
        return estado.getPoderPelea();
    }
}