package activities;

import java.util.ArrayList;
public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        //Adding object at specific index
        list.add(3, "d");
        list.add(1, "e");

        System.out.println("Print All the Objects:");
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("3rd element in the list is: " + list.get(2));
        System.out.println("Is a is in list: " + list.contains("a"));
        System.out.println("Size of ArrayList: " + list.size());

        list.remove("d");

        System.out.println("New Size of ArrayList: " + list.size());
    }
}
