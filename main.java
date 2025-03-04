import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner scannerInput = new Scanner(System.in);
        Set<Integer> s = new HashSet<>();
        Set<Integer> t = new HashSet<>();
        String inputData;
        String[] elements;

        //Asks for the S set
        System.out.println("Enter elements of Set S separated by comma: ");
        inputData = scannerInput.nextLine();
        
        if (!inputData.isEmpty()) {
            elements = inputData.split(",");
            for (int i = 0; i < elements.length; i++) {
                s.add(Integer.parseInt(elements[i]));
            }
        }else{
            System.out.println("Error: No data was inserted for S.");
            System.exit(0);
        }

        //Asks for the T set
        System.out.println("Enter elements of Set T separated by comma: ");
        inputData = scannerInput.nextLine();
         
        if (!inputData.isEmpty()) {
            elements = inputData.split(",");
            for (int i = 0; i < elements.length; i++) {
                t.add(Integer.parseInt(elements[i]));
             }
        }else{
            System.out.println("Error: No data was inserted for T.");
            System.exit(0);
        }

        //Defines universal set (1 to 100)
        Set<Integer> universalSetI = new HashSet<>();
        for (int i = 1; i <= 100; i++) {
           universalSetI.add(i);
        }

        //Absolute Complement of S
        Set<Integer> absoluteComplementOfS = new HashSet<>();
        absoluteComplementOfS = universalSetI; 
        absoluteComplementOfS.removeAll(s);

        //Difference (S - T)
        Set<Integer> difference = new HashSet<>();
        difference.addAll(s); 
        difference.removeAll(t);

        //Union (S ∪ T)
        Set<Integer> union = new HashSet<>();
        union.addAll(s);
        union.addAll(t);

        //Intersection (S ∩ T)
        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(s);
        intersection.retainAll(t);

        //Power Set of S
        Set<Set<Integer>> powerSetOfS = new HashSet<>();
        List<Integer> element = new ArrayList<>(s);
        int n = element.size();
        // Iterate through all subsets (0 to 2^n - 1)
        for (int i = 0; i < (1 << n); i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // If j-th bit is set in i, include elements[j]
                if ((i & (1 << j)) != 0) {
                    subset.add(element.get(j));
                }
            }
            powerSetOfS.add(subset);
        }

        //Output
        System.out.println("\nAbsolute Complement of S: " + absoluteComplementOfS);
        System.out.println("\nDifference (S - T): " + difference);
        System.out.println("\nUnion (S U T): " + union);
        System.out.println("\nIntersection (S ∩ T): " + intersection);
        System.out.println("\nPower Set of S: " + powerSetOfS);
        System.out.println("\nCartesian Product of S and T: ");

        //Cartesian Product of S and T
        Integer[] sArray = s.toArray(new Integer[0]);
        Integer[] tArray = t.toArray(new Integer[0]);
        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < tArray.length; j++) {
                System.out.print("{" + sArray[i] + ", " + tArray[j] + "}, ");
            }
        }
    }
}