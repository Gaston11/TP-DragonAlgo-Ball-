package fiuba.algo3.modelo.Componentes;

/**
 * Created by gaston on 18/06/17.
 */
public class VersorDireccion {
    private Coordenada coordenada;

    public VersorDireccion (Coordenada unaCoordenada){

        this.coordenada = unaCoordenada;
    }

    public Coordenada moverArriba(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX();
        coordenadaY = this.coordenada.getCoordenadaY()+1;

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverAbajo(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX();
        coordenadaY = this.coordenada.getCoordenadaY()-1;

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverAIzquierda(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX()-1;
        coordenadaY = this.coordenada.getCoordenadaY();

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverADerecha(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX()+1 ;
        coordenadaY = this.coordenada.getCoordenadaY();

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverASuperiorIzquierda(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX()-1 ;
        coordenadaY = this.coordenada.getCoordenadaY()+1;

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverASuperiorDerecha(){
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX()+1 ;
        coordenadaY = this.coordenada.getCoordenadaY()+1;

        Coordenada unaCoordenada = new Coordenada( coordenadaX,coordenadaY);
        return unaCoordenada;
    }

    public Coordenada moverAInferiorIzquierda() {
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX() - 1;
        coordenadaY = this.coordenada.getCoordenadaY() - 1;

        Coordenada unaCoordenada = new Coordenada(coordenadaX, coordenadaY);
        return unaCoordenada;
    }


    public Coordenada moverAInferiorDerecha() {
        int coordenadaX;
        int coordenadaY;
        coordenadaX = this.coordenada.getCoordenadaX() + 1;
        coordenadaY = this.coordenada.getCoordenadaY() -1 ;

        Coordenada unaCoordenada = new Coordenada(coordenadaX, coordenadaY);
        return unaCoordenada;
    }
}
