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
    public void gokuNoPuedeAtacarSiRecibeAtaqueEspecialDeMajinBooEstadoNormal(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.nuevoTurno();
        }

        majinboo.convertirEnChocolate(goku);

        try{

            goku.ataqueBasico(majinboo);
        }catch (PersonajeEnEstadoChocolateExcepcion ignored) { }

        assertTrue(majinboo.poseeVida(300));
    }

    @Test
    public void gokuPierdeSuSegundoTurnoPOrEstarEnEstadoChocolateMajinBooNoRecibeAtaque(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.nuevoTurno();
        }

        majinboo.convertirEnChocolate(goku);

        try{

            goku.ataqueBasico(majinboo);
        }catch (PersonajeEnEstadoChocolateExcepcion e) {
            try{
                goku.ataqueBasico(majinboo);
            }catch (PersonajeEnEstadoChocolateExcepcion ignored){

            }
        }

        assertTrue(majinboo.poseeVida(300));
    }

    @Test
    public void gokuPierdeSuTercerTurnoPOrEstarEnEstadoChocolateMajinBooNoRecibeAtaque(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.nuevoTurno();
        }

        majinboo.convertirEnChocolate(goku);

        try{

            goku.ataqueBasico(majinboo);
        }catch (PersonajeEnEstadoChocolateExcepcion e1) {
            try{
                goku.ataqueBasico(majinboo);
            }catch (PersonajeEnEstadoChocolateExcepcion e2){
                try {
                    goku.ataqueBasico(majinboo);
                }catch (PersonajeEnEstadoChocolateExcepcion e3){

                }
            }

        }

        assertTrue(majinboo.poseeVida(300));
    }

    @Test
    public void gokuYapuedeAtacarAlCuartoTurnoEnEstadoKaioKen(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.nuevoTurno();
        }

        for (int i = 0; i<10 ; i++){
            goku.nuevoTurno();
        }

        goku.transformarse();
        majinboo.convertirEnChocolate(goku);

        try{

            goku.ataqueBasico(majinboo);
        }catch (PersonajeEnEstadoChocolateExcepcion e1) {
            try{
                goku.ataqueBasico(majinboo);
            }catch (PersonajeEnEstadoChocolateExcepcion e2){
                try {
                    goku.ataqueBasico(majinboo);
                }catch (PersonajeEnEstadoChocolateExcepcion e3){

                }
            }

        }
        //verifica que goku puede atacar en una distancia de ataque 4
        goku.mover(unaCoordenada);
        goku.ataqueBasico(majinboo);

        assertTrue(majinboo.poseeVida(260));    }

    @Test
    public void majinBooNoPuedeConvertirEnChocolateAunCompanieroDeEquipoFuegoAmigoException(){

        Coordenada posicionInicialCell = new Coordenada(0, 0);
        Coordenada posicionInicialMajinBoo = new Coordenada(0, 2);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Cell cell = new Cell();
        cell.naceEn(posicionInicialCell);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(posicionInicialMajinBoo);

        for (int i=0; i<10 ; i++){
            majinBoo.nuevoTurno();
        }

        thrown.expect(FuegoAmigoException.class);
        majinBoo.convertirEnChocolate(cell);


        assertTrue(majinBoo.poseeKi(50));
    }


    @Test
    public void gokuPierdeSuturnoPorEstarConvertidoEnChocalateNoPuedeMoverse(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i=0; i<10 ; i++){
            majinboo.nuevoTurno();
        }
        majinboo.convertirEnChocolate(goku);

        try{
            goku.mover(otraCoordenada1);
        }catch (PersonajeEnEstadoChocolateExcepcion ignored){

        }

        assertTrue(goku.estaUbicadoEn(unaCoordenada));
    }

    @Test
    public void gokuPierdeSuSegundoturnoPorEstarConvertidoEnChocalateNoPuedeMoverse(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i=0; i<10 ; i++){
            majinboo.nuevoTurno();

        }
        majinboo.convertirEnChocolate(goku);

        try{
            goku.mover(otraCoordenada1);
        }catch (PersonajeEnEstadoChocolateExcepcion e){
            try{
                goku.mover(otraCoordenada1);
            }catch (PersonajeEnEstadoChocolateExcepcion ignored){

            }

        }

        assertTrue(goku.estaUbicadoEn(unaCoordenada));
    }

    public void gokuPierdeSuTercerturnoPorEstarConvertidoEnChocalateNoPuedeMoverse(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i=0; i<10 ; i++){
            majinboo.nuevoTurno();

        }
        majinboo.convertirEnChocolate(goku);

        try{
            goku.mover(otraCoordenada1);
        }catch (PersonajeEnEstadoChocolateExcepcion e1){
            try{
                goku.mover(otraCoordenada1);
            }catch (PersonajeEnEstadoChocolateExcepcion e2){
                try {
                    goku.mover(otraCoordenada1);
                }catch (PersonajeEnEstadoChocolateExcepcion ignored){

                }
            }

        }

        assertTrue(goku.estaUbicadoEn(unaCoordenada));
    }

    public void gokuYaSePuedeMoverAlCuartoturno(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Coordenada otraCoordenada1 = new Coordenada(0, 4);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        for (int i=0; i<10 ; i++){
            majinboo.nuevoTurno();

        }
        majinboo.convertirEnChocolate(goku);

        try{
            goku.mover(otraCoordenada1);
        }catch (PersonajeEnEstadoChocolateExcepcion e1){
            try{
                goku.mover(otraCoordenada1);
            }catch (PersonajeEnEstadoChocolateExcepcion e2){
                try {
                    goku.mover(otraCoordenada1);
                }catch (PersonajeEnEstadoChocolateExcepcion e3){
                    goku.mover(otraCoordenada1);
                }
            }

        }

        assertTrue(goku.estaUbicadoEn(otraCoordenada1));
    }

}