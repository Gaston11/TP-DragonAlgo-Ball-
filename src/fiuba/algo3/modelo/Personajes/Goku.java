package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosGoku.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import fiuba.algo3.modelo.excepciones.PersonajeEnEstadoChocolateExcepcion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ConcurrentModificationException;

public class Goku extends Personaje implements PersonajeBueno{
    private Estado estado;
    private int kiNecesario;
    private int porcentaje;

    public Goku(){
        maxVida = 500;
        vida = maxVida;
        ki = 0;
        kiNecesario = 20; //para realizar el Kamehameha
        porcentaje = 50; //causa un 50% mas que el ataque basico
        vidaCritica = 150;
        estado = new EstadoNormal();

    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

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
    public boolean ataqueBasico(PersonajeMalo enemigo){

        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        estado.ataqueBasico(enemigo,this);
        return true;
    }

    @Override
    public boolean ataqueEspecial(PersonajeMalo enemigo) {
        this.kamehameha(enemigo);
        return true;
    }

    @Override
    public void transformar(Personaje goku, Personaje gohan, Personaje piccolo) {
        this.transformarse();
    }

    @Override
    public boolean ataqueEspecial(PersonajeBueno enemigo) {
        this.kamehameha(enemigo);
        return true;
    }

    @Override
    public boolean ataqueBasico(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }


    public void kamehameha(PersonajeMalo enemigo){

        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){

            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        if(ki<kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        estado.ataqueEspecial(enemigo,this);
        this.ki -= kiNecesario;

    }

    public void kamehameha(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void mover(Coordenada coordenada) {

        Coordenada coordenada1 = this.estado.obtenerCoordenadaValida(this.coordenada,coordenada);
        this.coordenada = coordenada1;
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
    public void convertimeEnChocolate() {
        this.estado = new EstadoChocolate(estado,this);
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
    public String getDireccion(){
        return estado.getDireccion();
    }

    @Override
    public String getNombre() {
        return "Goku";
    }
}