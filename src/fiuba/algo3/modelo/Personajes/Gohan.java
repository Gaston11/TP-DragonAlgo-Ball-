package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Consumible;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.EstadosGohan.EstadoNormal;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gohan extends Personaje implements PersonajeBueno{

    private int vidaCritica;
    private int kiNecesario;

    public Gohan(){
        maxVida = 300;
        vida = maxVida;
        vidaCritica = 60;//20% de la vida inicial
        ki = 0;
        kiNecesario = 10;//para poder realizar el ataque especial
        estado = new EstadoNormal();
    }

    @Override
    public int calcularDistanciaDesde(Coordenada otraCoordenada){
        return this.coordenada.obtenerDistancia(otraCoordenada);
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea){
        return estado.poseeMayorPoderPelea(poderPelea);
    }

    @Override
    public void mover(Coordenada coordenada) {
        this.coordenada = this.estado.obtenerCoordenadaValida(this.coordenada,coordenada);
        this.versorPersonaje = new VersorDireccion(coordenada);
    }

    @Override
    public void obtenerConsumible(Consumible consumible) {
        Estado estadoNuevo = consumible.agregarEstado(estado,this);
        estado = estadoNuevo;
    }

    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
    }

    public void transformarse(Personaje personaje1, Personaje personaje2){
        estado = estado.transformarse(personaje1,personaje2,this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    @Override
    public boolean ataqueBasico(PersonajeMalo unPersonaje) {
        int distancia = unPersonaje.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        estado.ataqueBasico(unPersonaje,this);
        return true;
    }

    @Override
    public boolean ataqueEspecial(PersonajeMalo enemigo) {
        this.masenko(enemigo);
        return true;
    }

    @Override
    public void transformar(Personaje goku, Personaje gohan ,Personaje piccolo) {
        this.transformarse(goku,piccolo);
    }

    @Override
    public boolean ataqueEspecial(PersonajeBueno enemigo) {
        this.masenko(enemigo);
        return true;
    }

    @Override
    public boolean ataqueBasico(PersonajeBueno unPersonaje) {
        throw new FuegoAmigoException();
    }

    @Override
    public void volverAlEstadoAnterior(Estado estado){
        this.estado = estado;
    }

    @Override
    public void convertimeEnChocolate() {
        this.estado = new EstadoChocolate(estado,this);
    }

    public void masenko(PersonajeMalo enemigo){
        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        if(ki < kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        this.ki -= kiNecesario;
        estado.ataqueEspecial(enemigo,this);
    }

    public void masenko(PersonajeBueno amigo){
        throw new FuegoAmigoException();
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
    public String getDireccion() {
        return estado.getDireccion();
    }

    @Override
    public String getNombre() {
        return "Gohan";
    }
}