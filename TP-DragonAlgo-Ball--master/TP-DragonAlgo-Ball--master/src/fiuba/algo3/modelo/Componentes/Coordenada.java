package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.excepciones.NoSePuedeCalcularLaDistanciaException;

public class Coordenada {
	
	private int coordenadaX;
	private int coordenadaY;
	
	public Coordenada(int coordenadaX, int coordenadaY ){
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public int getCoordenadaX(){
		return this.coordenadaX;
	}
	
	public int getCoordenadaY(){
		return this.coordenadaY;
	}
	
	public boolean esLaMismaCoordenada(Coordenada unaCoordenada){
		return ( this.getCoordenadaX() == unaCoordenada.getCoordenadaX()  &&
				this.getCoordenadaY() == unaCoordenada.getCoordenadaY() );
	}

	public boolean ubicacionDiagonal(Coordenada coordenada){
		return (Math.abs(Math.abs(coordenada.getCoordenadaY()) - Math.abs(this.coordenadaY)) ==
				Math.abs(Math.abs(coordenada.getCoordenadaX()) - Math.abs(this.coordenadaX)));
	}

	public int obtenerDistancia(Coordenada coordenada){
		int distancia;
		if (this.ubicacionDiagonal(coordenada) || (Math.abs(coordenada.getCoordenadaX()) == Math.abs(this.coordenadaX))){
			distancia = Math.abs( Math.abs(coordenada.getCoordenadaY()) - Math.abs(this.coordenadaY));
			//da igual la distancia columna o la distancia fila
		} else {

			if (Math.abs(coordenada.getCoordenadaY()) == Math.abs(this.getCoordenadaY())){
				distancia = Math.abs(Math.abs(coordenada.getCoordenadaX()) - Math.abs(this.coordenadaX));

			} else {
				throw new NoSePuedeCalcularLaDistanciaException();
				// si no se puede calcular la distancia Tira una excepcion

			}
		}

		return distancia;
	}
}
