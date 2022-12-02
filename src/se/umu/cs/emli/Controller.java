package se.umu.cs.emli;

import se.umu.cs.apjava.DoubleLinkedList;
import java.util.Objects;

/**
 * Controller class for Iterator-program. Takes input from user
 * and saves it in a DoubleLinkedList. Iterates over the list and prints its content
 * when user chooses to iterate.
 * @author Emmy Lindgren, id19eln.
 */
public class Controller {
    View view;
    DoubleLinkedList<String> list;
    public Controller(){
        view = new View();
        view.show();
        list = new DoubleLinkedList<>();
        setListeners();
    }

    private void setListeners(){
        view.setInputListener(e -> addToList());
        view.setIterateListener(e -> iterateList());
    }

    private void addToList(){
        if(!Objects.equals(view.getInput(), "")){
            list.insert(view.getInput(), list.end());
            view.clearInput();
        }
    }

    /**
     * Iterates over the list of strings using the DoubleLinkedListIterator-class.
     */
    private void iterateList(){
        view.clearOutPut();
        view.lockButtons();
        int position = 0;
        DoubleLinkedListIterator<String> iterator = new DoubleLinkedListIterator<>(list);

        while(iterator.hasNext()){
            view.updateOutput("Position " + position +": "+ iterator.next() + System.lineSeparator());
            position++;
        }

        list = new DoubleLinkedList<>();
        view.unlockButtons();
    }
}
