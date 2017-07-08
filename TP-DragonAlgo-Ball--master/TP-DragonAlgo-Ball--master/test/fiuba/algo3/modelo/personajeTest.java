package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class personajeTest{

    @Test
    public void seUbicaPersonajeGohanEnCasilleroYSeLoMueve(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        
        assertTrue(gohan.estaUbicadoEn(unaCoordenada));
            
        gohan.mover(otraCoordenada);

        assertTrue(gohan.estaUbicadoEn(otraCoordenada));
        
    }

    @Test
    public void seUbicaPersonajeGokuSeLoTransformaSeLoMueveAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,6);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada);
        }

        goku.transformarse();

        goku.mover(otraCoordenada1);

        assertTrue(goku.estaUbicadoEn(otraCoordenada1));
    }

    /*
    
    @Test
    public void test02seUbicaPersonajeGohanYGokuEnElMismoCasillero(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        
        Goku goku= new Gohu();
        goku.naceEn(otraCoordenada);
        
        assertTrue(gohan.estaUbicadoEn(unaCoordenada));
            
        gohan.mover(otraCoordenada);

        assertTrue(gohan.estaUbicadoEn(otraCoordenada));

    }
 

    @Test
    public void test02seUbicaUnPersonajeGokuEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Goku goku = new Goku();
        goku.naceEn(celdaNacimiento);
        goku.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(goku.estaUbicadoEn(celdaNueva));

    }

    @Test
    public void test01seUbicaUnPersonajePiccoloEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(celdaNacimiento);
        piccolo.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(piccolo.estaUbicadoEn(celdaNueva));

    }

    @Test
    public void test01TransformarPersonajePiccolo(){
        int turno = 10;
        Celda celdaNacimiento = new Celda(0,0);
        Piccolo piccolo = new Piccolo();

        piccolo.naceEn(celdaNacimiento);
        piccolo.incrementarKi(turno);
        piccolo.fortalecido();

        // si esta en modo fortalecido su ki disminuye 20un
        assertEquals(30,piccolo.getKi());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test02TransformarPersonajePiccolo(){

        Celda celdaNacimiento1 = new Celda(0,0);
        Piccolo piccolo = new Piccolo();

        Celda celdaNacimiento2 = new Celda(0,1);
        Gohan gohan = new Gohan();

        piccolo.naceEn(celdaNacimiento1);
        gohan.naceEn(celdaNacimiento2);

        try{
            piccolo.protector(gohan);
        }catch (PiccoloNoPuedePasarEstadoProtector ignored){}



    }

    @Test
    public void testseTransformaPersonajePiccoloEnCasilleroYSeLoMueve(){
        int turno = 10;
        Celda celdaNacimiento = new Celda(0,0);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(celdaNacimiento);

        piccolo.incrementarKi(turno);
        piccolo.fortalecido();
        try{
            piccolo.seMueveHaciaLaDerecha(4);

            Celda celdaNueva = new Celda(0,4);

        } catch (NoSePuedeMoverPersonajeException e){
            piccolo.seMueveHaciaLaDerecha(3);

            Celda celdaNueva = new Celda(0,3);
        }

	*/
   

}
