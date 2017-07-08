package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.PersonajeEnEstadoChocolateExcepcion;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeConvertirAlPersonajeEnEstadoChocolateException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AtaquesIntegracionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /*
    @Test
    public void test01SeUbicaAGokuYAFreezerSeAtacanConAtaqueBasicoSegunDistancias(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);


        goku.ataqueBasico(freezer);

        //goku ataca a freezer
        //assert freezer recibe danio

        //freezer ataca a goku
        //assert goku recibe danio
        //goku ataca a freezer
        //freezer ataca a goku
        //assert ni goku ni freezer reciben danio

    }*/

    @Test
    public void seUbicaAGokuYAFreezerSeAtacanConAtaqueEspecialesSegunDistancias(){

    /*    Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        int vidaLlenaFreezer = freezer.getVida();
        goku.ataqueEspecial(freezer); //deberia aumentar el ki

        assertTrue((vidaLlenaFreezer > freezer.getVida()));

        int vidaLlenaGoku = goku.getVida();
        freezer.ataqueEspecial(goku); //deberia aumentar el ki

        assertTrue((vidaLlenaGoku > goku.getVida()));
      */  //goku ataca a freezer
        //assert freezer recibe danio

        //freezer ataca a goku
        //assert goku recibe danio
        //goku ataca a freezer
        //freezer ataca a goku
        //assert ni goku ni freezer reciben danio

    }

    //habria que hacer las pruebas de ataque con los personajes transformados

    @Test
    public void seUbicaAGokuYAGohanGokuAtacaGohanYSeProduceUnaExcepcion() {

        Coordenada posicionInicialGoku = new Coordenada(0, 0);
        Coordenada posicionInicialGohan = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(posicionInicialGoku);

        Gohan gohan = new Gohan();
        gohan.naceEn(posicionInicialGohan);

        thrown.expect(FuegoAmigoException.class);
        goku.ataqueBasico(gohan);

        thrown.expect(FuegoAmigoException.class);
        gohan.ataqueBasico(goku);

    }

    @Test
    public void seUbicaACellYAFreezerCellAtacaFreezerYSeProduceUnaExcepcionYnoSufreCambiosEnVida() {

        Coordenada posicionInicialCell = new Coordenada(0, 0);
        Coordenada posicionInicialFreezer = new Coordenada(0, 2);

        Cell cell = new Cell();
        cell.naceEn(posicionInicialCell);

        Freezer freezer = new Freezer();
        freezer.naceEn(posicionInicialFreezer);

        thrown.expect(FuegoAmigoException.class);
        cell.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(400));
    }

    @Test
    public void majinBooConvierteEnChocolateAGokuYLoDejaInutil() {

        Coordenada posicionInicialGoku = new Coordenada(0, 0);
        Coordenada posicionInicialMajinBoo = new Coordenada(0, 2);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Goku goku = new Goku();
        goku.naceEn(posicionInicialGoku);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(posicionInicialMajinBoo);

        for (int i=0; i<10 ; i++){
            majinBoo.mover(otraCoordenada);
        }

        majinBoo.convertirEnChocolate(goku);

        thrown.expect(PersonajeEnEstadoChocolateExcepcion.class);
        goku.ataqueBasico(majinBoo);

        assertTrue(majinBoo.poseeVida(300));
    }

    @Test
    public void majinBooNoPuedeConvertirAGokuEnEstadoChocolatePOrqueNoPoseeKIGokuAtaca(){
        Coordenada posicionInicialGoku = new Coordenada(0, 0);
        Coordenada posicionInicialMajinBoo = new Coordenada(0, 2);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Goku goku = new Goku();
        goku.naceEn(posicionInicialGoku);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(posicionInicialMajinBoo);

        thrown.expect(NoSePuedeConvertirAlPersonajeEnEstadoChocolateException.class);
        majinBoo.convertirEnChocolate(goku);

        goku.ataqueBasico(majinBoo);

        assertTrue(majinBoo.poseeVida(280));
    }


}