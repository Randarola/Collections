package tb.soft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

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
}
