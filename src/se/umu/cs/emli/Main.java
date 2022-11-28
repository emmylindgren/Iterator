package se.umu.cs.emli;
import se.umu.cs.apjava.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();

        lista.insert("Hej", lista.first());
        lista.insert("då", lista.end());
        lista.insert("jaha", lista.end());
        lista.insert("ersättning", lista.first());
/*
        DoubleLinkedListIterator<String> iterator = new DoubleLinkedListIterator<>(lista);

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        for (String s: lista) {
            System.out.println(s);
        }


    }

}