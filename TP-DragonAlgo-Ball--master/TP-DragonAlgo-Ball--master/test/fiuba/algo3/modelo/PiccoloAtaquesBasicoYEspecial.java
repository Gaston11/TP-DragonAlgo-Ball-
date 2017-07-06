package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Piccolo;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.EstadosPiccolo.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Rule;

public class PiccoloAtaquesBasicoYEspecial {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void piccoloAtaqueBasicoMajinBooDisminuyeVidaNoConsumeKi(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(otraCoordenada);

        for(int i=0; i<5; i++){
            piccolo.mover(otraCoordenada1);
        }

        piccolo.ataqueBasico(majinBoo);

        assertTrue(majinBoo.poseeVida(280));
        assertTrue(piccolo.poseeKi(25));
    }

    @Test
    public void piccoloNoPuedeAtacarAUnCompanieroNoRecibeDanio(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        try {
            piccolo.ataqueBasico(gohan);
        }catch (FuegoAmigoException ignored){}

        assertTrue(gohan.poseeVida(300));
    }

    @Test
    public void piccoloNoPuedeAtacarConMakankosappoAUnCompanieroExceptionYnoRecibeDanio(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        try {
            piccolo.makankosappo(gohan);
        }catch (FuegoAmigoException ignored){}

        assertTrue(gohan.poseeVida(300));
    }

    @Test
    public void piccoloAtacaConMakankosappoEnEstadoFortalecidoConsumeKiAUnEnemigoEsteRecibeDanio(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(otraCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(unaCoordenada);
        }

        piccolo.transformarse(gohan);
        piccolo.makankosappo(majinBoo);

        assertTrue(piccolo.poseeKi(20));
        assertTrue(majinBoo.poseeVida(260));

    }

    @Test
    public void piccoloNoPuedeAtacarConMakankosappoPOrNoPoseerSuficienteKiException(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(otraCoordenada);

        thrown.expect(NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException.class);
        piccolo.makankosappo(majinBoo);
    }
}