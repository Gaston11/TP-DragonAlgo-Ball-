package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosMajinBoo.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException;
import fiuba.algo3.modelo.excepciones.NoSePuedeConvertirAlPersonajeEnEstadoChocolateException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MajinBoo extends Personaje implements PersonajeMalo{

    private int kiNecesario;

    public MajinBoo() {
        this.maxVida = 300;
        this.vida = maxVida;
        this.ki = 0;
        this.kiNecesario = 30; //para convertir en chocolate
        this.estado = new EstadoNormal();
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
        this.ki -= estado.costoDeTransformacion();

    }

    public void convertirEnChocolate(PersonajeBueno enemigo) {
        int distancia = enemigo.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        if (this.ki<kiNecesario) {
            throw new NoSePuedeConvertirAlPersonajeEnEstadoChocolateException();
        }
        this.ki-=kiNecesario;
        enemigo.convertimeEnChocolate();
    }

    public void convertirEnChocolate(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void transformar() {
        this.transformarse();
    }

    @Override
    public boolean ataqueEspecial(PersonajeBueno enemigo){
        this.convertirEnChocolate(enemigo);
        return true;
    }

    @Override
    public boolean ataqueEspecial(PersonajeMalo amigo){
        this.convertirEnChocolate(amigo);
        return true;
    }

    @Override
    public boolean ataqueBasico(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public boolean ataqueBasico(PersonajeBueno unPersonaje) {
        int distancia = unPersonaje.calcularDistanciaDesde(this.coordenada);
        if (!estado.distanciaPermitida(distancia)){
            throw new NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException();
        }
        estado.ataqueBasico(unPersonaje,this);
        return true;
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

    @Override
    public void volverAlEstadoAnterior(Estado estado){
        this.estado = estado;
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
        return "MajinBoo";
    }
}