package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;

public class EsferaDelDragon extends Consumible implements Estado{

    private int turnos;
    private Estado estadoAnterior;

    public EsferaDelDragon(){
        turnos = 2;
    }

    @Override
    public Estado agregarEstado(Estado estado,Personaje personaje){

        estadoAnterior = estado;
        return this;
    }

    @Override
    public int aumentarVida() {
        return 0;
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
        turnos -= 1;
        if(turnos<0){
            estadoAnterior.ataqueBasico(enemigo, personaje);
            personaje.volverAlEstadoAnterior(estadoAnterior);
        }else {
            //ataque con el 25% mas de danio
            this.ataque(enemigo,personaje);
        }
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje) {
        turnos -= 1;
        if(turnos<0){
            estadoAnterior.ataqueBasico(enemigo, personaje);
            personaje.volverAlEstadoAnterior(estadoAnterior);
        }else {
            //ataque con el 25% mas de danio
            this.ataque(enemigo,personaje);
        }

    }

    private void ataque(PersonajeBueno enemigo, Personaje personaje) {
        estadoAnterior.ataqueBasico(enemigo,personaje);
        enemigo.recibirDanio(personaje.getPoderPelea()*25/100);
    }

    private void ataque(PersonajeMalo enemigo, Personaje personaje) {
        estadoAnterior.ataqueBasico(enemigo,personaje);
        enemigo.recibirDanio(personaje.getPoderPelea()*25/100);
    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje) {
        turnos -= 1;
        if(turnos<0){
            personaje.volverAlEstadoAnterior(estadoAnterior);
        }else {
            //ataque con el 25% mas de danio
            this.ataqueEsp(enemigo,personaje);
        }
    }

    private void ataqueEsp(PersonajeMalo enemigo, Personaje personaje) {
        estadoAnterior.ataqueEspecial(enemigo, personaje);
        enemigo.recibirDanio(estadoAnterior.getPoderPelea()*25/100);
    }

    private void ataqueEsp(PersonajeBueno enemigo, Personaje personaje) {
        estadoAnterior.ataqueEspecial(enemigo, personaje);
        enemigo.recibirDanio(estadoAnterior.getPoderPelea()*25/100);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo, Personaje personaje) {
        turnos -= 1;
        if(turnos<0){
            personaje.volverAlEstadoAnterior(estadoAnterior);
        }else {
            //ataque con el 25% mas de danio
            this.ataqueEsp(enemigo,personaje);
        }
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
        return estadoAnterior.moverPorEstado();
    }

    @Override
    public Coordenada moverArriba(VersorDireccion unVersor) {
        return estadoAnterior.moverArriba(unVersor);
    }

    @Override
    public Coordenada moverAbajo(VersorDireccion unVersor) {
        return estadoAnterior.moverAbajo(unVersor);
    }

    @Override
    public Coordenada moverAIzquierda(VersorDireccion unVersor) {
        return estadoAnterior.moverAIzquierda(unVersor);
    }

    @Override
    public Coordenada moverADerecha(VersorDireccion unVersor) {
        return estadoAnterior.moverADerecha(unVersor);
    }

    @Override
    public Coordenada moverASuperiorDerecha(VersorDireccion unVersor) {
        return estadoAnterior.moverASuperiorDerecha(unVersor);
    }

    @Override
    public Coordenada moverASuperiorIzquierda(VersorDireccion unVersor) {
        return estadoAnterior.moverASuperiorIzquierda(unVersor);
    }

    @Override
    public Coordenada moverAInferiorDerecha(VersorDireccion unVersor) {
        return estadoAnterior.moverAInferiorDerecha(unVersor);
    }

    @Override
    public Coordenada moverAInferiorIzquierda(VersorDireccion unVersor) {
        return estadoAnterior.moverAInferiorIzquierda(unVersor);
    }

    @Override
    public int getPoderPelea() {
        return estadoAnterior.getPoderPelea();
    }

    @Override
    public int getVelocidad() {
        return estadoAnterior.getVelocidad();
    }

    @Override
    public Coordenada obtenerCoordenadaValida(Coordenada coordenadaIni, Coordenada coordenadaFin) {
        return estadoAnterior.obtenerCoordenadaValida(coordenadaIni,coordenadaFin);
    }

    @Override
    public String getNombre() {
        return "Esfera de dragón";
    }
}