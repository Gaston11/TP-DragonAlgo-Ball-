package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;

import java.awt.image.DirectColorModel;

public class NubeVoladora extends Consumible implements Estado{

    private int turnos;
    private Estado estadoAnterior = null;
    private Personaje personaje;
    private int velocidad;

    public NubeVoladora(){
        turnos = 2;
    }


    @Override
    public int aumentarVida() {
        return 0;
    }

    @Override
    public Estado agregarEstado(Estado estado, Personaje personaje) {
        this.agregarPersonaje(personaje);
        estadoAnterior = estado;
        this.velocidad = estadoAnterior.getVelocidad()*2;
        return this;
    }

    @Override
    public String getDireccion() {
        String direccion;
        if(estadoAnterior==null){
            direccion = "file:src/fiuba/algo3/vista/imagenes/nube2.png";
        }else{
            direccion = estadoAnterior.getDireccion();
        }
        return direccion;
    }

    @Override
    public String getNombre() {
        return "Nube voladora";
    }

    public void agregarPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    @Override
    public void puedeMoverse(int pasos) {

    }

    @Override
    public void sumarVidaAbsorbida() {
        estadoAnterior.sumarVidaAbsorbida();
    }

    @Override
    public void aumentarVida(Personaje cell) {
        estadoAnterior.aumentarVida(cell);
    }

    @Override
    public boolean distanciaPermitida(int distancia) {

        return estadoAnterior.distanciaPermitida(distancia);
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea) {
        return estadoAnterior.poseeMayorPoderPelea(poderPelea);
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje) {
        estadoAnterior.ataqueBasico(enemigo, personaje);
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje) {
        estadoAnterior.ataqueBasico(enemigo, personaje);
    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje) {
        estadoAnterior.ataqueEspecial(enemigo, personaje);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo, Personaje personaje) {
        estadoAnterior.ataqueEspecial(enemigo, personaje);
    }

    @Override
    public Estado transformarse(int condicion) {
        return estadoAnterior.transformarse(condicion);
    }

    @Override
    public Estado transformarse(Personaje gohan, int kiActual) {
        return estadoAnterior.transformarse(gohan, kiActual);
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki) {
        return estadoAnterior.transformarse(personaje1, personaje2, ki);
    }

    @Override
    public int costoDeTransformacion() {
        return estadoAnterior.costoDeTransformacion();
    }

    @Override
    public int moverPorEstado() {
        return 0;
    }

    @Override
    public Coordenada moverArriba(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverArriba(unVersor);
        }else{
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < velocidad; contador++){
                unaCoordenada = unVersor.moverArriba();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }

    }

    @Override
    public Coordenada moverAbajo(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverAbajo(unVersor);
        }else{
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < velocidad; contador++){
                unaCoordenada = unVersor.moverAbajo();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverAIzquierda(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverAIzquierda(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverAIzquierda();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverADerecha(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverADerecha(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverADerecha();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverASuperiorDerecha(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverASuperiorDerecha(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverASuperiorDerecha();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverASuperiorIzquierda(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverASuperiorIzquierda(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverASuperiorIzquierda();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverAInferiorDerecha(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverAInferiorDerecha(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverAInferiorDerecha();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public Coordenada moverAInferiorIzquierda(VersorDireccion unVersor) {
        turnos -=1;
        if(turnos <0){
            this.personaje.volverAlEstadoAnterior(estadoAnterior);
            return estadoAnterior.moverAInferiorIzquierda(unVersor);
        }else {
            Coordenada unaCoordenada = new Coordenada(0,0);
            for (int contador =0; contador < this.velocidad; contador++){
                unaCoordenada = unVersor.moverAInferiorIzquierda();
                unVersor = new VersorDireccion(unaCoordenada);
            }
            return unaCoordenada;
        }
    }

    @Override
    public int getPoderPelea() {
        return estadoAnterior.getPoderPelea();
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
/*
    @Override
    public String getNombre() {
        return "Nube voladora";
    }
*/
    @Override
    public boolean esUnPersonaje() {
        return false;
    }

    @Override
    public Coordenada getCoordenada() {
        return this.coordenada;
    }
}