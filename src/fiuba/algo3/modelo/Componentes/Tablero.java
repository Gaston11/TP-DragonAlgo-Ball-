package fiuba.algo3.modelo.Componentes;

import java.util.*;
import java.util.Iterator;

import fiuba.algo3.modelo.Personajes.Equipo;
import fiuba.algo3.modelo.Personajes.EquipoEnemigos;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.CeldaConCoordenadaNegativaException;
import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class Tablero {

	private int dimension;
    private List<Celda> celdasOcupadas; 
	
    public Tablero (int unaDimension) {
        
    	this.dimension = unaDimension;
    	this.celdasOcupadas = new ArrayList<>();
    }
    
    
    private boolean celdaOcupada(Celda unaCelda){
    	Iterator<Celda> iterador =this.celdasOcupadas.iterator();
    	boolean encontrado = false;
    	Celda celda;
    	
    	while (iterador.hasNext() && !encontrado)
    	{
    		celda = iterador.next();
    		/*encontrado = ( (celda.getCoordenada().getCoordenadaX()) == (unaCelda.getCoordenada().getCoordenadaX())
    				&& (celda.getCoordenada().getCoordenadaY()) == (unaCelda.getCoordenada().getCoordenadaY()) );
    				*/
    		encontrado = celda.getCoordenada().esLaMismaCoordenada(unaCelda.getCoordenada());
    	}

    	return encontrado;
    }

    private boolean celdaTieneCoordenadaNegativa(Celda unaCelda){
    	return (unaCelda.getCoordenada().getCoordenadaX() < 0 ||
				unaCelda.getCoordenada().getCoordenadaY() < 0 );
	}
    
    public void colocarCeldaEnTablero(Celda celda){
    	if (this.celdaOcupada(celda)){
    		throw new CeldaOcupadaException();
    	}

    	if (this.celdaTieneCoordenadaNegativa( celda )){
    		throw new CeldaConCoordenadaNegativaException();
		}
    	
    	this.celdasOcupadas.add(celda);
    }

    //Cuando una celda se libera, se debe sacar de la lista de celdas ocupadas
    public void liberarCeldaEnTablero(Coordenada coordenada){
		Iterator<Celda> iterador = this.celdasOcupadas.iterator();
		boolean encontrado = false;
		Celda celda;

		while (!encontrado && iterador.hasNext()){
			celda = iterador.next();
			encontrado = coordenada.esLaMismaCoordenada(celda.getCoordenada());
		}
		try {
			iterador.remove();
		} catch (Exception ex){
			throw new CeldaNoOcupadaException();
		}
	}

    public void ubicarEquipos() {
    	// TABLERO DE 10X10
		EquipoGuerrerosZ equipo1 = new EquipoGuerrerosZ();
		EquipoEnemigos equipo2 = new EquipoEnemigos();

    	Coordenada esquinaSupIzq = new Coordenada(0,9);
    	Coordenada esquinaInfDer = new Coordenada(9,0);

    	//ubicar equipo 1
    	Celda celda1 = new Celda(esquinaSupIzq);
    	celda1.colocarPersonaje(equipo1.obtenerPersonaje(0));
    	Celda celda2 = new Celda(new Coordenada(esquinaSupIzq.getCoordenadaX()+1,esquinaSupIzq.getCoordenadaY()));
    	celda2.colocarPersonaje(equipo1.obtenerPersonaje(1));
    	Celda celda3 = new Celda(new Coordenada(esquinaSupIzq.getCoordenadaX(),esquinaSupIzq.getCoordenadaY()-1));
    	celda3.colocarPersonaje(equipo1.obtenerPersonaje(2));
		this.colocarCeldaEnTablero(celda1);
		this.colocarCeldaEnTablero(celda2);
		this.colocarCeldaEnTablero(celda3);

    	//ubicar equipo 2
		Celda celda4 = new Celda(esquinaInfDer);
		celda4.colocarPersonaje(equipo2.obtenerPersonaje(0));
		Celda celda5 = new Celda(new Coordenada(esquinaInfDer.getCoordenadaX()-1,esquinaInfDer.getCoordenadaY()));
		celda5.colocarPersonaje(equipo2.obtenerPersonaje(1));
		Celda celda6 = new Celda(new Coordenada(esquinaInfDer.getCoordenadaX(),esquinaInfDer.getCoordenadaY()+1));
		celda6.colocarPersonaje(equipo2.obtenerPersonaje(2));
		this.colocarCeldaEnTablero(celda4);
		this.colocarCeldaEnTablero(celda5);
		this.colocarCeldaEnTablero(celda6);

    }

	private Coordenada getCoordenadaDePersonaje(Personaje unPersonaje){
		Iterator<Celda> iterador =this.celdasOcupadas.iterator();
		boolean encontrado = false;
		Coordenada unaCoordenada = new Coordenada( 0,0 );
		Celda celda = new Celda( unaCoordenada );

		while (iterador.hasNext() && !encontrado)
		{
			celda = iterador.next();
			encontrado = (celda.getPersonaje() == unPersonaje);
		}

		return (celda.getCoordenada());

	}

	private void colocarPersonajeEnCoordenadaAnterior(Personaje unPersonaje){
		Coordenada unaCoordenada = this.getCoordenadaDePersonaje(unPersonaje);
		unPersonaje.mover(unaCoordenada);

	}

	public void moverPersonaje(Personaje unPersonaje, Coordenada unaCoordenada){
		Celda celdaNueva = new Celda(unaCoordenada);
		if (this.celdaOcupada(celdaNueva)) {
			this.colocarPersonajeEnCoordenadaAnterior(unPersonaje); // hay un metodo arriba q sirve
		}

		else
		{
			celdaNueva.colocarPersonaje(unPersonaje);
			this.liberarCeldaEnTablero(this.getCoordenadaDePersonaje(unPersonaje) );
			this.colocarCeldaEnTablero(celdaNueva);
		}

	}




}
