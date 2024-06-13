package activities;

public class Activity10 {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");
        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Removing A from HashSet: " + hs.remove("A"));
        if(hs.remove("H")) {
            System.out.println("Z removed from the Set");
        } else {
            System.out.println("Z is not present in the Set");
        }
        System.out.println("Checking if M is present: " + hs.contains("M"));
        System.out.println("Updated HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());
    }
}
