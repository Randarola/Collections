package tb.soft;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.io.PrintWriter;

public class Collections {
    static HashSet<String> hashSetName = new HashSet<>();
    static TreeSet<String> treeSetName = new TreeSet<>();

    static ArrayList<String> arrayListName = new ArrayList();
    static LinkedList<String> linkedListName = new LinkedList<>();

    static public void addName(String name1, String name2)
    {
        String name = name1 + " " + name2;
        hashSetName.add(name);
        treeSetName.add(name);
        arrayListName.add(name);
        linkedListName.add(name);
    }
    static public void removeName(String name1, String name2)
    {
        String name = name1 + " " + name2;
        hashSetName.remove(name);
        treeSetName.remove(name);
        arrayListName.remove(name);
        linkedListName.remove(name);
    }
    static String message1 = "Ilość wprowadzonych danych: ";
    static String message2 = "Dane wprowadzonych osób: ";
    static public void saveData() throws FileNotFoundException
    {
        //Zapisywanie danych w pliku od HashSet
        PrintWriter saveHashSet = new PrintWriter("HashSet.txt");
        saveHashSet.println(message1 + hashSetName.size());
        saveHashSet.println(message2);
        for(String item : hashSetName)
        {
            saveHashSet.println(item);
        }
        saveHashSet.close();

        //Zapisywanie danych w pliku od TreeSet
        PrintWriter saveTreeSet = new PrintWriter("TreeSet.txt");
        saveTreeSet.println(message1 + treeSetName.size());
        saveTreeSet.println(message2);
        for(String item : treeSetName)
        {
            saveTreeSet.println(item);
        }
        saveTreeSet.close();

        //Zapisywanie danych w pliku od ArrayListName
        PrintWriter saveArrayList = new PrintWriter("ArrayList.txt");
        saveArrayList.println(message1 + arrayListName.size());
        saveArrayList.println(message2);
        for(String item : arrayListName)
        {
            saveArrayList.println(item);
        }
        saveArrayList.close();

        //Zapisywanie danych w pliku od LinkedListName
        PrintWriter saveLinkedList = new PrintWriter("LinkedList.txt");
        saveLinkedList.println(message1 + linkedListName.size());
        saveLinkedList.println(message2);
        for(String item : linkedListName)
        {
            saveLinkedList.println(item);
        }
        saveLinkedList.close();

    }


}
