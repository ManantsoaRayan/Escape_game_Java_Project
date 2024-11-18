package item;

public class Main {
    
    public static void main(String[] args) {
        // on crée une instance de InteractiveItem
        InteractiveItem item = new InteractiveItem("Livre", 4, 100, 100, 300, 200);

        // interactive n'est juste qu'une fenêtre temporaire pour tester l'item
        Interactive frame = new Interactive(750, 750);

        // c'est pour mettre l'item interactive dans le frame
        frame.add(item);
    }
}