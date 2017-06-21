package fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Componentes.Coordenada;

public class MajinBooAtaqueEspecialTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void GokuNoPuedeAtacarSiRecibeAtaqueEspecialDeMajinBooEstadoNormal(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.convertirEnChocolate(goku);

        try{

            goku.ataqueBasico(majinboo);
        }catch (PersonajeEnEstadoChocolateExcepcion ignored) { }

        assertTrue(majinboo.poseeVida(300));
    }

    @Test
    public void MajinBooNoPuedeConvertirEnChocolateAunCompanieroDeEquipoFuegoAmigoException(){

        Coordenada posicionInicialCell = new Coordenada(0, 0);
        Coordenada posicionInicialMajinBoo = new Coordenada(0, 2);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Cell cell = new Cell();
        cell.naceEn(posicionInicialCell);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(posicionInicialMajinBoo);

        for (int i=0; i<10 ; i++){
            majinBoo.mover(otraCoordenada);
        }

        thrown.expect(FuegoAmigoException.class);
        majinBoo.convertirEnChocolate(cell);


        assertTrue(majinBoo.poseeKi(50));
    }
}