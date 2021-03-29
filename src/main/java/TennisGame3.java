/*Este es un codigo para un juegos de tennis con dificultad 3.
 *Ha sido refactorizado por Katherin Tatiana Garcia Loaiza con fin de practicar la refactorizacion.
 */
public class TennisGame3 implements TennisGame {
    
    private int ScorePlayer1;
    private int ScorePlayer2;
    private String NamePlayer1;
    private String NamePlayer2;

    //Asignacion de nombres de los jugadores
    public TennisGame3(String NamePlayer1, String NamePlayer2) {
        this.NamePlayer1 = NamePlayer1;
        this.NamePlayer2 = NamePlayer2;
    }

    //Seleccion de opcion: empate, aumento de puntaje o ganador.
    public String getScore() {
        if (Puntuacion()) {
            return ResultadoPuntuacion();
        } else {
            if (Empate()) {
                return "Deuce";
            }
            return Evento();
        }
    }

    //Retorna si ambos puntajes son menores a 4 y la suma de ambos no es mayor a seis.
    public boolean Puntuacion(){
        return (ScorePlayer2 < 4) && (ScorePlayer1 < 4) && !(ScorePlayer2 + ScorePlayer1 == 6);
    }

    //Retorna si estan en empate
    public boolean Empate(){
        return (ScorePlayer2 == ScorePlayer1);
    }

    //Entrega el nombre del jugador con mayor puntuacion
    public String JugadorAdelante(){
        return ScorePlayer2 > ScorePlayer1 ? NamePlayer1 : NamePlayer2;
    }

    //Entrega si algun jugador tomo la ventaja o gano.
    public String Evento(){
        return ( ElevarResta()== 1) ? "Advantage " + JugadorAdelante() : "Win for " + JugadorAdelante();
    }

    //Elevar al cuadrado la resta de los puntajes
    public double ElevarResta(){
        return Math.pow((ScorePlayer2 - ScorePlayer1), 2);
    }

    //Opcion cuando la puntuacion de ambos es menor a 4 y la suma de ambos no es mayor a seis.
    public String ResultadoPuntuacion(){
        String[] Puntaje = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (ScorePlayer2 == ScorePlayer1) ? Puntaje[ScorePlayer2] + "-All" : Puntaje[ScorePlayer2] + "-" + Puntaje[ScorePlayer1];
    }


    //Asignacion del incremento de puntaje.
    public void wonPoint(String PlayerName) {
        int puntaje = (PlayerName == "player1") ? (ScorePlayer2 ++) : (ScorePlayer1 ++);
    }
}
