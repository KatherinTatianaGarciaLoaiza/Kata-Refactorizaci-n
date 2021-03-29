/*Este es un codigo para un juegos de tennis con dificultad 2.
 *Ha sido refactorizado por Katherin Tatiana Garcia Loaiza con fin de practicar la refactorizacion.
 */
import java.util.List;
import java.util.Arrays;

public class TennisGame2 implements TennisGame{

    private int ScorePlayer1 = 0;
    private int ScorePlayer2 = 0;
    private String Player1Name;
    private String Player2Name;

    //Asignacion de nombres de los jugadores
    public TennisGame2(String Player1Name, String Player2Name) {
        this.Player1Name = Player1Name;
        this.Player2Name = Player2Name;
    }

    //Seleccion de opcion: empate, aumento de puntaje o ganador.
    public String getScore(){
        String Score = "";
        if (Empate()){
            Score = PuntajesIguales();
        }  else if(SeleccionDeAvance()){
            int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
            Score = Avance(DiferenciaDePuntaje);
        } else {
            Score = Puntaje(ScorePlayer1) + "-" + Puntaje(ScorePlayer2);
        }
        return Score;
    }

    //Asignacion del incremento de puntaje.
    public void wonPoint(String Player) {
        int puntaje = (Player == "player1") ? (ScorePlayer1 ++) : (ScorePlayer2 ++);
    }

    //Retorna si es la opcion de empate.
    public boolean Empate(){
        return (ScorePlayer1 == ScorePlayer2);
    }

    //Retorna si es la opcion de avance.
    public boolean SeleccionDeAvance(){
        return ((ScorePlayer1 >= 4) || (ScorePlayer2 >= 4));
    }

    //Opcion de puntajes iguales.
    public String PuntajesIguales() {
        List<String> Puntajes = Arrays.asList(new String[] {"Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"});
        return Puntajes.get(ScorePlayer1);
    }

    //Opcion de avance.
    public String Avance(int DiferenciaDePuntaje){
        switch (DiferenciaDePuntaje){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (DiferenciaDePuntaje >= 2)? "Win for player1" : "Win for player2";
        }
    }

    //Opcion de puntaje.
    public String Puntaje(int ScorePlayer){
        List<String> Puntajes = Arrays.asList(new String[] {"Love", "Fifteen", "Thirty", "Forty"});
        return Puntajes.get(ScorePlayer);
    }
}