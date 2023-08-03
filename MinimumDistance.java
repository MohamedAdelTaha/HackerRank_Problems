import java.util.*;

public class MinimumDistance {
    public static <T> Set<T> convertArrayToSet (T array[]){
        Set<T> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        return set;
    }
    public static int minimumDistance(Integer[] array){
        // Check if there are no matching elements
        Set<Integer> set = convertArrayToSet(array);
        if (set.size() == array.length) {
            System.out.println(-1);
            System.exit(0);
        }
        
        // Normal case
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int distance;
        int occurrence;
        for (Integer num : set) {
             distance = 0;
             occurrence = 0;
             for (int i = 0; i < array.length; i++) {
                
                 if (Objects.equals(num, array[i])) {
                     occurrence = occurrence + 1;
                     distance = i - distance;
                 }
             }

             // just add the repeated nums > 1
             if (occurrence > 1) map.put(num, distance);
        }
        
        // Get the minimum distance
        int minimum = 999999999;
        int value = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()) {
            value = m.getValue();
            if(value < minimum) minimum = value;
        }
        return minimum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Getting the size of array from the first line
        int size = scan.nextInt();

        // Getting numbers from the second line
        scan.nextLine();
        String secondLine = scan.nextLine();
        scan.close();
        String[] values = secondLine.split(" ");
        Integer[] nums = new Integer[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        System.out.println(minimumDistance(nums));
        

    }
}
