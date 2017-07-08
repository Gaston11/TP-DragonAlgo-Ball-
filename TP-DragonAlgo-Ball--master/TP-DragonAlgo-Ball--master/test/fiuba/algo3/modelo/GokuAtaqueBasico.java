package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GokuAtaqueBasico {

    @Test
    public void seUbicaAGokuYAFreezerSeAtacanConAtaqueBasicoSegunDistancias(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        goku.ataqueBasico(freezer);
        freezer.ataqueBasico(goku);

        assertTrue(freezer.poseeVida(380));
        assertTrue(goku.poseeVida(480));

    }

    @Test
    public void seUbicaAGokuYAFreezerSeAtacanConAtaqueBasicoSegunDistanciasNoRecibenDanio(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        goku.ataqueBasico(freezer);
        freezer.ataqueBasico(goku);

        assertTrue(freezer.poseeVida(400));
        assertTrue(goku.poseeVida(500));

    }

    @Test
    public void gokuEstadoNormalTieneMenosDel30porcDeVidaSuDanioAumenta20porc(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada1);

        //freezer.ataqueBasico(goku); tantas veces como sea necesario para que goku tenga vida critica
        for (int i=0; i<13; i++){
            freezer.ataqueBasico(goku);
        }

        goku.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(376));
    }

    @Test
    public void gokuEstadoKaioKenTieneMenosDel30porcDeVidaSuDanioAumenta20porc(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada2 = new Coordenada(1, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada2);

        for (int i=0; i<13; i++){
            freezer.ataqueBasico(goku);
        }
        goku.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(352));
    }

    @Test
    public void gokuEstadoSuperSayajinTieneMenosDel30porcDeVidaSuDanioAumenta20porc(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada2 = new Coordenada(1, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada1);

        for (int i=0; i<13; i++){
            freezer.ataqueBasico(goku);
        }
        goku.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(328));
    }

    @Test
    public void gokuAtaqueBasicoEnEstadoNormalCellRecibeDanio(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada);

        goku.ataqueBasico(cell);
        assertTrue(cell.poseeVida(480));
    }

    @Test
    public void gokuAtaqueBasicoEnEstadoNormalMajinbooRecibeDanio(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        goku.ataqueBasico(majinboo);
        assertTrue(majinboo.poseeVida(280));
    }


    @Test
    public void gokuAtaqueBasicoEnEstadoKaioKenCellRecibeDanio(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(2,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }
        goku.transformarse();
        goku.ataqueBasico(cell);
        assertTrue(cell.poseeVida(460));
    }

    @Test
    public void gokuAtaqueBasicoEnEstadoSayajinCellRecibeDanio(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(2,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();
        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        goku.ataqueBasico(cell);
        assertTrue(cell.poseeVida(440));
    }

}