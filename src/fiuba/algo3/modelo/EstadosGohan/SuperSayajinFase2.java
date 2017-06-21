package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class SuperSayajinFase2 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int costo;

    public SuperSayajinFase2(){
        poderPelea = 100;
        distanciaAtaque = 4;
        velocidad = 3;
        costo = 30;
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje){
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public  Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new EstadoDeTransformacionMaxima();
    }

    @Override
    public Estado transformarse(int kiActual){
        //aca tambien tendría que lanzar una excepcion
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new EstadoDeTransformacionMaxima();
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
    public void ataqueEspecial(PersonajeBueno amigo, Personaje personaje){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje){
        enemigo.recibirDanio((poderPelea*125)/100);
    }

    public Coordenada moverArriba(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverArriba();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }

}

