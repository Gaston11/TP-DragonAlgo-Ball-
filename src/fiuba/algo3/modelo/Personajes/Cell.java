package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAbsorberPersonajeException;

public class Cell extends Personaje implements PersonajeMalo{

    private Estado estado;
    private int kiNecesario;

    public Cell(){
        maxVida = 500;
        vida = maxVida;
        ki = 0;
        estado = new EstadoNormal();
        kiNecesario = 5;
    }

    @Override
    public int calcularDistanciaDesde(Coordenada otraCoordenada){
        return this.coordenada.obtenerDistancia(otraCoordenada);
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea){
        return estado.poseeMayorPoderPelea(poderPelea);
    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
    }

    @Override
    public void  ataqueBasico(PersonajeBueno enemigo){
        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        estado.ataqueBasico(enemigo,this);
    }

    public void absorber(PersonajeBueno enemigo){
        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        if (kiNecesario>this.ki){
            throw new NoSePuedeAbsorberPersonajeException();
        }
        this.ki -= 5;
        estado.ataqueBasico(enemigo,this);
        estado.aumentarVida(this);

    }

    public void absorber(PersonajeMalo amigo){
        throw new FuegoAmigoException();
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
        this.estado = estado;
    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo) {
        this.absorber(enemigo);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo) {
        this.absorber(enemigo);
    }

    @Override
    public void transformar() {
        this.transformarse();
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

    @Override
    public String getNombre() {
        return "Cell";
    }
}