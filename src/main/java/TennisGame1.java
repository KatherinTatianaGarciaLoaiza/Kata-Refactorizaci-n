/*Este es un codigo para un juegos de tennis con dificultad 1.
 *Ha sido refactorizado por Katherin Tatiana Garcia Loaiza con fin de practicar la refactorizacion.
 */
public class TennisGame1 implements TennisGame {

    private int ScorePlayer1 = 0;
    private int ScorePlayer2 = 0;
    private String Player1Name;
    private String Player2Name;

    //Asignacion de nombres de los jugadores
    public TennisGame1(String Player1Name, String Player2Name) {
        this.Player1Name = Player1Name;
        this.Player2Name = Player2Name;
    }

    //Asignacion del incremento de puntaje.
    public void wonPoint(String PlayerName) {
        if (PlayerName == "player1") {
            ScorePlayer1 += 1;
        }
        else {
            ScorePlayer2 += 1;
        }
    }

    //Seleccion de opcion: empate, aumento de puntaje o ganador.
    public String getScore() {
        String Score = "";
        if (ScorePlayer1 == ScorePlayer2){
            Score = PuntajeDeEmpate(ScorePlayer1);
        }
        else if (ScorePlayer1 >= 4 || ScorePlayer2 >= 4){
            Score = Avance(ScorePlayer1, ScorePlayer2);
        } else{
            Score = Puntaje(ScorePlayer1) + "-" + Puntaje(ScorePlayer2);
            }
        return Score;
    }

    //Opcion empate.
    public String PuntajeDeEmpate(int ScorePlayer){
        switch (ScorePlayer)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    //opcion de ganador o jugador que avanza.
    public String Avance(int ScorePlayer1, int ScorePlayer2){
        String score = "";
        int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
        if (DiferenciaDePuntaje == 1){
            score = "Advantage player1";
        }
        else if (DiferenciaDePuntaje == -1){
            score = "Advantage player2";
        }
        else if (DiferenciaDePuntaje >= 2){
            score = "Win for player1";
        }
        else{
            score = "Win for player2";
        }
        return score;
    }

    //Opcion de incremento de puntaje.
    public String Puntaje(int ScorePlayer) {
        switch (ScorePlayer) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return null;
        }
    }
}
