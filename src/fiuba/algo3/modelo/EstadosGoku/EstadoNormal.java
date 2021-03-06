package fiuba.algo3.modelo.EstadosGoku;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonajeException;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;

    public EstadoNormal(){
        poderPelea = 20;
        distanciaAtaque = 2;
        velocidad = 2;
        kiNecesario = 20;
    }

    @Override
    public boolean distanciaPermitida(int distancia){
        return (distanciaAtaque >= distancia);
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea){
        return (this.poderPelea > poderPelea);
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje goku){
        if(enemigo.poseeMayorPoderPelea(poderPelea)){
            enemigo.recibirDanio(poderPelea*80/100);
        }else{
            enemigo.recibirDanio(poderPelea);
        }
        if(goku.estadoVidaCritica()){
            enemigo.recibirDanio((poderPelea*20)/100);
        }

    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonajeException();
        }
    }

    @Override
    public Estado transformarse(int kiActual){
        if (kiNecesario > kiActual){
            throw new NoSePuedeTransformarPersonajeException();
        }
        return new EstadoKaioKen();
    }

    @Override
    public int costoDeTransformacion(){
        return 0;
    }

    @Override
    public Estado transformarse(Personaje gohan, int ki){
        throw new NoSePuedeTransformarPersonajeException();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new NoSePuedeTransformarPersonajeException();
    }

    @Override
    public void sumarVidaAbsorbida(){

    }

    public int moverPorEstado(){
	return this.velocidad;	
    }


    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo, Personaje Goku){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje goku) {
        if(enemigo.poseeMayorPoderPelea(poderPelea)){
            enemigo.recibirDanio(poderPelea*130/100);
        }else{
            enemigo.recibirDanio((poderPelea * 150) / 100);
        }

        if (goku.estadoVidaCritica()) {
            enemigo.recibirDanio((poderPelea * 20) / 100);
        }
    }

    @Override
    public Coordenada moverArriba(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverArriba();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }

    @Override
    public Coordenada moverAbajo(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAbajo();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }

    @Override
    public Coordenada moverAIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverADerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverADerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverASuperiorDerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverASuperiorDerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverASuperiorIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverASuperiorIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAInferiorDerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAInferiorDerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAInferiorIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAInferiorIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public int kiPorTurno() {
        return 5;
    }

    @Override
    public int getPoderPelea() {
        return poderPelea;
    }

    @Override
    public int getVelocidad() {
        return this.velocidad;
    }

    @Override
    public Coordenada obtenerCoordenadaValida(Coordenada coordenadaIni, Coordenada coordenadaFin) {
        int pasos = coordenadaIni.obtenerDistancia(coordenadaFin);
        if (this.velocidad<pasos){
            throw new NoSePuedeMoverPersonajeException();
        }
        return coordenadaFin;
    }

    @Override
    public String getDireccion() {
        return "file:src/fiuba/algo3/vista/imagenes/goku.png";
    }

}

