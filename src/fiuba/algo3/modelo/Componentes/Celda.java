package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Personajes.Personaje;

public class Celda{

	private Coordenada coordenada;
	private Personaje personaje;
	private Consumible consumible;

    public Celda(Coordenada unaCoordenada){
        consumible = new Nada();
        this.coordenada = unaCoordenada;
    }
    
    public Coordenada getCoordenada(){
    	return this.coordenada;
    }
    
    public void colocarPersonaje(Personaje personaje){
    	personaje.consumir(consumible);
        this.personaje = personaje;
        this.consumible = new Nada();
    }

    public void colocarConsumible(Consumible consumible){
        this.consumible = consumible;
    }
}