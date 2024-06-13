package activities;
interface Addable{
    int add(int num1,int num2);
}
public class Activity12 {
    public static void main(String[] args){
        Addable ad1 = (num1, num2) -> (num1 + num2);
        System.out.println("ad1 value:"+ad1.add(5, 4));
        Addable ad2 = (int num1, int num2) -> {
            return (num1 + num2);
        };
        System.out.println("ad2 value:"+ad1.add(50, 60));
    }
}
