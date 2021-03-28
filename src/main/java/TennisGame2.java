/*Este es un codigo para un juegos de tennis con dificultad 2.
 *Ha sido refactorizado por Katherin Tatiana Garcia Loaiza con fin de practicar la refactorizacion.
 */
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
            Score = PuntajesIguales(ScorePlayer1);
        }  else if(SeleccionDeAvance()){
            Score = Avance();
        } else {
            Score = Puntaje(ScorePlayer1) + "-" + Puntaje(ScorePlayer2);
        }
        return Score;
    }

    //Asignacion del incremento de puntaje.
    public void wonPoint(String player) {
        if (player == "player1"){
            ScorePlayer1 ++;
        } else {
            ScorePlayer2 ++;
        }
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
    public String PuntajesIguales(int ScorePlayer) {
        switch (ScorePlayer) {
            case 0:
                return  "Love-All";
            case 1:
                return   "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return   "Deuce";
        }
    }

    public String Avance(){
        int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
        switch (DiferenciaDePuntaje){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                if (DiferenciaDePuntaje >= 2){
                    return "Win for player1";
                } else {
                    return "Win for player2";
                }
        }
    }

    public String Puntaje(int ScorePlayer){
        switch (ScorePlayer) {
            case 0:
                return "Love";
            case 1:
                return  "Fifteen";
            case 2:
                return  "Thirty";
            default:
                return  "Forty";
        }
    }
}