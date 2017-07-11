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
        Coordenada otraCoordenada1 = new Coordenada(0,5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        goku.mover(otraCoordenada);
        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.nuevoTurno();
        }


        goku.transformarse();
        goku.mover(otraCoordenada1);

        assertTrue(goku.estaUbicadoEn(otraCoordenada1));
    }

}
