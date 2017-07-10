package fiuba.algo3.modelo.Componentes;

import java.util.*;
import java.util.Iterator;

import fiuba.algo3.modelo.Personajes.Equipo;
import fiuba.algo3.modelo.Personajes.EquipoEnemigos;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.*;

public class Tablero {

	private int dimension;
    private List<Celda> celdasOcupadas; 
	
    public Tablero (int unaDimension) {
        
    	this.dimension = unaDimension;
    	this.celdasOcupadas = new ArrayList<>();
    }
    
    
    public boolean celdaOcupada(Celda unaCelda){
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

    public void ubicarEquipos( List<Personaje> equipo1, List<Personaje> equipo2 ) {
    	// TABLERO DE 10X10

    	Coordenada esquinaSupIzq = new Coordenada(0,9);
    	Coordenada esquinaInfDer = new Coordenada(9,0);
    	Coordenada esquinaSupIzq2 = new Coordenada(esquinaSupIzq.getCoordenadaX()+1,esquinaSupIzq.getCoordenadaY());
		Coordenada esquinaSupIzq3 = new Coordenada(esquinaSupIzq.getCoordenadaX(),esquinaSupIzq.getCoordenadaY()-1);
		Coordenada esquinaInfDer2 = new Coordenada(esquinaInfDer.getCoordenadaX()-1,esquinaInfDer.getCoordenadaY());
		Coordenada esquinaInfDer3 = new Coordenada(esquinaInfDer.getCoordenadaX(),esquinaInfDer.getCoordenadaY()+1);

		equipo1.get(0).naceEn(esquinaSupIzq);
		equipo1.get(1).naceEn(esquinaSupIzq2);
		equipo1.get(2).naceEn(esquinaSupIzq3);

		equipo2.get(0).naceEn(esquinaInfDer);
		equipo2.get(1).naceEn(esquinaInfDer2);
		equipo2.get(2).naceEn(esquinaInfDer3);

    	//ubicar equipo 1
    	Celda celda1 = new Celda(esquinaSupIzq);
    	celda1.colocarPersonaje(equipo1.get( 0 ));

    	Celda celda2 = new Celda(esquinaSupIzq2);
    	celda2.colocarPersonaje(equipo1.get( 1 ));

    	Celda celda3 = new Celda(esquinaSupIzq3);
    	celda3.colocarPersonaje(equipo1.get( 2 ));
		this.colocarCeldaEnTablero(celda1);
		this.colocarCeldaEnTablero(celda2);
		this.colocarCeldaEnTablero(celda3);

    	//ubicar equipo 2
		Celda celda4 = new Celda(esquinaInfDer);
		celda4.colocarPersonaje(equipo2.get( 0 ));
		Celda celda5 = new Celda(esquinaInfDer2);
		celda5.colocarPersonaje(equipo2.get( 1 ));
		Celda celda6 = new Celda(esquinaInfDer3);
		celda6.colocarPersonaje(equipo2.get( 2 ));
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
		if (this.celdaOcupadaConPersonaje(celdaNueva)) {
			this.colocarPersonajeEnCoordenadaAnterior(unPersonaje); // hay un metodo arriba q sirve
		}

		else
		{
			celdaNueva.colocarPersonaje(unPersonaje);
			this.liberarCeldaEnTablero(this.getCoordenadaDePersonaje(unPersonaje) );
			this.colocarCeldaEnTablero(celdaNueva);
		}

	}


	public Personaje mover(Coordenada unaCoordenada, Coordenada unaCoordenada1) {
		Celda celda = new Celda(unaCoordenada);
		if(!celdaOcupadaConPersonaje(celda)){
			throw new NoSeleccionoNingunPersonajeException();
		}
		celda = this.obtenerCelda(celda);
		Personaje personaje = celda.getPersonaje();
		this.moverPersonaje(personaje, unaCoordenada1);
		return personaje;
	}

	public boolean celdaOcupadaConPersonaje(Celda celda) {
		Iterator<Celda> iterador =this.celdasOcupadas.iterator();
		Boolean poseePersonaje = false;
		Celda celda1 = null;
		while (iterador.hasNext() && !poseePersonaje){
			celda1 = iterador.next();
			if(celda1.getCoordenada().esLaMismaCoordenada(celda.getCoordenada())){
				poseePersonaje = celda1.ocupadaConPersonaje();
			}
		}
		return poseePersonaje;
	}

	public Celda obtenerCelda(Celda celda) {
		Iterator<Celda> iterador =this.celdasOcupadas.iterator();
		Boolean encontrado = false;
		Celda celda1 = null;
		while (iterador.hasNext() && !encontrado){
			celda1 = iterador.next();
			encontrado = celda1.getCoordenada().esLaMismaCoordenada(celda.getCoordenada());
		}
		return celda1;
	}

	public Personaje obtenerPersonajeEn(Coordenada coordenadaAtaca) {
		Iterator<Celda> iterador =this.celdasOcupadas.iterator();
		Boolean encontrado = false;
		Celda celda1 = null;
		while (iterador.hasNext() && !encontrado){
			celda1 = iterador.next();
			encontrado = celda1.getCoordenada().esLaMismaCoordenada(coordenadaAtaca);
		}
		if (!encontrado){
			throw new NoSeleccionoNingunPersonajeException();
		}
		return celda1.getPersonaje();

	}

	public Consumible obtenerConsumible(Coordenada coordenada) {
		try {
			Celda celda = this.obtenerCelda(coordenada);
			return celda.getConsumible();
		}catch (Exception ex){
			return new Nada();
		}
	}

	public Celda obtenerCelda(Coordenada coordenada) {
	    try {
            return this.celdasOcupadas.stream().filter(c -> c.getCoordenada().esLaMismaCoordenada(coordenada)).findFirst().get();
        }catch (Exception ex){
	        return null;
        }
	}

    public boolean celdaOcupadaConPersonaje(Coordenada coordenada) {
	    try {
            return this.obtenerCelda(coordenada).getPersonaje() != null;
        }catch (Exception ex){
	        return false;
        }

    }
}
