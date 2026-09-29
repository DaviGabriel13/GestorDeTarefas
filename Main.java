import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task regar  = new Task("Regas as plantas ás 13");
        Task estudo  = new Task("Estudar ás 19");
        Task banho = new Task("Banhar as 21");
        Notebook notebook = new Notebook();
        notebook.storeNote(estudo);
        notebook.storeNote(banho);
        notebook.storeNote(regar);
        System.out.println("Tamanho do notebook: "+notebook.numberOfNotes());
        notebook.showAllNotes();
        notebook.showNote(1);
        notebook.filterKeys("19");
        notebook.completedTask(0);
        notebook.completedTaskWordKey("Banhar");
        notebook.removeNote(0);
        notebook.removeKeyWord("Estudar");
        notebook.showAllNotes();

    }
}