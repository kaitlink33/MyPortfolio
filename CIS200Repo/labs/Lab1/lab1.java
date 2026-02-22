import java.util.*;
public class lab1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of donut boxes: ");
        int boxes = Integer.parseInt(s.nextLine());
        String donuts = (boxes * 12)+"";
        System.out.printf("There are %s donuts in %s boxes.",donuts,boxes);
    }
}