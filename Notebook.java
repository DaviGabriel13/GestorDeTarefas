import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<Task> notes;
    Scanner in = new Scanner(System.in);
    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<Task>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(Task note)
    {
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 1) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber <= numberOfNotes()) {
            // This is a valid note number, so we can print it.
            int indice = noteNumber - 1;
            System.out.println(notes.get(indice).toString());
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    public void removeNote(int noteNumber)
    {
        if(noteNumber < 0 || noteNumber >= numberOfNotes()) {

            System.out.println("Número de nota inválido.");
        }
        else {
            Iterator<Task> it = notes.iterator();
            int i = 0;
            while ( it.hasNext()){
                it.next();

                if(i == noteNumber){
                    it.remove();
                    System.out.println("Nota removida com sucesso.");
                    break;
                }
                i++;
            }
        }
    }
    public void removeKeyWord(String key){
        System.out.println("Deseja excluir as tarefas com a palavra chave "+key+": (s para sim e n para não)");
        String confirmacao = in.next();
        if (confirmacao.equalsIgnoreCase("n")){
            System.out.println("Operação cancelada!");
        }else{
            Iterator<Task> it = notes.iterator();
            while(it.hasNext()){
                Task note = it.next();
                if (note.toString().contains(key)){
                    it.remove();
                }
            }
        }


    }
    public void showAllNotes()
    {
        if(numberOfNotes() == 0) {
            System.out.println("O bloco de notas está vazio.");
        }
        else {
            for(int i = 0; i < numberOfNotes(); i++) {
                System.out.println(i + ": " + notes.get(i).toString());
            }
        }
    }
    private void showArray(List<String> array)
    {
        if(array.size() == 0) {
            System.out.println("O bloco de notas está vazio.");
        }
        else {
            for(int i = 0; i < array.size(); i++) {
                System.out.println(i + ": " + array.get(i));
            }
        }
    }
    public void filterKeys(String key){
        List<String> keys = new ArrayList<>();

        for(String x : keys){
            if(x.contains(key)){
                keys.add(x);
            }
        }
        showArray(keys);
    }
    public void completedTask(int index){
        notes.get(index).confirmated();
        System.out.println("Task "+notes.get(index).toString()+" carried out");
    }
    public void completedTaskWordKey(String key){
        for (int i =0;i<notes.size();i++){
            if (notes.get(i).toString().contains(key)){
                notes.get(i).confirmated();
                System.out.println("Task "+notes.get(i).toString()+" carried out");
            }
        }
    }
}
