package game.room;

public interface GameRoom {
    /**
     * Méthode appelée lorsque la chambre devient active
     * Démarre le minuteur spécifique à cette chambre
     */
    void startTimer();

    /**
     * Méthode appelée lorsque la chambre n'est plus active
     * Arrête et réinitialise le minuteur
     */
    void stopTimer();

    /**
     * Vérifie si la chambre est une chambre de jeu avec minuteur
     * @return true si c'est une chambre de jeu, false sinon
     */
    boolean isGameRoom();
}
