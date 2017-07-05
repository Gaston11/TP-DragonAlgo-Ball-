package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.JugadorEnemigo;
import fiuba.algo3.modelo.Juego.JugadorZ;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeBuenoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeMaloException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class JugadorTest {
    @Test
    public void crearJugadoresAsignandoRivalesTrivial() {

        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        assertEquals("Juan", jugadorEnemigo.getRival().getNombre());
        assertEquals("Fede", jugador.getRival().getNombre());

    }

    @Test
    public void jugadorZAtaquesBasicoAJugadorEnemigoVerificaDanioDeFreezer() {

        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        personajesZ.add(new Gohan());
        personajesZ.add(new Piccolo());

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        jugador.ataqueBasico(goku, freezer);

        assertEquals(380, freezer.getVida());

    }

    @Test
    public void jugadorEnemigoAtaquesBasicoAJugadorZVerificaDanioDeGoku() {

        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        personajesZ.add(new Gohan());
        personajesZ.add(new Piccolo());

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        jugador.getRival().ataqueBasico(freezer, goku);

        assertEquals(480, goku.getVida());

    }

    @Test
    public void cadaJugadorTransformaAunPersonajeDisminuyeKi() {

        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        Gohan gohan = new Gohan();
        personajesZ.add(gohan);
        Piccolo piccolo = new Piccolo();
        personajesZ.add(piccolo);

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        for(int i=0; i<4; i++){
            goku.mover(otraCoordenada);
            freezer.mover(unaCoordenada);
        }

        jugador.transformar(goku);
        jugadorEnemigo.transformar(freezer);

        assertEquals(0, goku.getKi());
        assertEquals(0, freezer.getKi());

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void jugadorEnemigoQuiereTransformarAunPersonajeQueNoEsSuyoPersonajeInvalidoNoEsPersonajeMaloExceptionYNoDisminuyeKi() {
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        Gohan gohan = new Gohan();
        personajesZ.add(gohan);
        Piccolo piccolo = new Piccolo();
        personajesZ.add(piccolo);

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);
        for (int i=0; i<4; i++){
            freezer.mover(unaCoordenada);
            goku.mover(otraCoordenada);
        }

        thrown.expect(PersonajeInvalidoNoEsPersonajeMaloException.class);
        jugadorEnemigo.transformar(goku);

        assertTrue(goku.poseeKi(20));
    }

    @Test
    public void jugadorZQuiereatacarAUnCompanieroDeEquipoPersonajeInvalidoNoEsPersonajeMaloException(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        personajesZ.add(gohan);
        personajesZ.add(new Piccolo());

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        thrown.expect(PersonajeInvalidoNoEsPersonajeMaloException.class);
        jugador.ataqueBasico(goku,gohan);

    }

    @Test
    public void jugadorZQuiereAtacarConUnPersonajeDelOtroJugadorPersonajeInvalidoException(){

         JugadorZ jugador = new JugadorZ("Juan");
         JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
         jugador.asignarRival(jugadorEnemigo);
         jugadorEnemigo.asignarRival(jugador);

         Goku goku = new Goku();
         ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
         personajesZ.add(goku);
         personajesZ.add(new Gohan());
         personajesZ.add(new Piccolo());

         Freezer freezer = new Freezer();
         ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
         personajeEnemigos.add(new MajinBoo());
         personajeEnemigos.add(freezer);
         personajeEnemigos.add(new Cell());

         jugador.asignarEquipo(personajesZ);
         jugador.asignarEquipoRival(personajeEnemigos);

         Coordenada unaCoordenada = new Coordenada(0,0);
         Coordenada otraCoordenada = new Coordenada(2,0);
         freezer.naceEn(unaCoordenada);
         goku.naceEn(otraCoordenada);

         thrown.expect(PersonajeInvalidoNoEsPersonajeBuenoException.class);
         jugador.ataqueBasico(freezer,freezer);

    }

    @Test
    public void jugadorAtaqueEspecialConGokuAtacaAFreezerDisminuyeKi(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        personajesZ.add(new Gohan());
        personajesZ.add(new Piccolo());

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        for(int i=0; i<4; i++){
            jugador.mover(goku,otraCoordenada);
        }

        jugador.ataqueEspecial(goku,freezer);

        assertEquals(0, goku.getKi());
    }

    @Test
    public void jugadorTransformaCorrectamenteAGohanEnEstadoSuperSayajinDisminuyeKiSiSusCompanierosPoseenVidaCritica(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        Gohan gohan = new Gohan();
        personajesZ.add(gohan);
        Piccolo piccolo = new Piccolo();
        personajesZ.add(piccolo);

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        Coordenada coordenada2 = new Coordenada(0,4);
        gohan.naceEn(coordenada2);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        for(int i =0 ; i<6; i++){
            jugador.mover(gohan,otraCoordenada);
        }

        jugador.transformar(gohan); //transformado en super sayajin fase 1
        goku.recibirDanio(350);
        piccolo.recibirDanio(350);
        for(int i =0 ; i<6; i++){
            jugador.mover(gohan,otraCoordenada);
        }

        jugador.transformar(gohan);
        assertEquals(20, gohan.getKi());
    }

    @Test
    public void jugadorZQuiereMoverUnPersonajeQueNoEsSuyoPersonajeInvalidoNoEsPersonajeBuenoException(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Goku goku = new Goku();
        ArrayList<PersonajeBueno> personajesZ = new ArrayList<PersonajeBueno>();
        personajesZ.add(goku);
        Gohan gohan = new Gohan();
        personajesZ.add(gohan);
        Piccolo piccolo = new Piccolo();
        personajesZ.add(piccolo);

        Freezer freezer = new Freezer();
        ArrayList<PersonajeMalo> personajeEnemigos = new ArrayList<PersonajeMalo>();
        personajeEnemigos.add(new MajinBoo());
        personajeEnemigos.add(freezer);
        personajeEnemigos.add(new Cell());

        jugador.asignarEquipo(personajesZ);
        jugador.asignarEquipoRival(personajeEnemigos);

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        Coordenada coordenada2 = new Coordenada(0,4);
        gohan.naceEn(coordenada2);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        thrown.expect(PersonajeInvalidoNoEsPersonajeBuenoException.class);
        jugador.mover(freezer,otraCoordenada);
    }

}