import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public static void main (String [] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitStore = new HashMap<>();

        for (int fruit: fruits) {
            if(fruitStore.containsKey(fruit)) {
                fruitStore.put(fruit, fruitStore.get(fruit) + 1);
            } else {
                fruitStore.put(fruit, 1);
            }
        }

        int firstBig = 0, secondBig = 0;
        for (Map.Entry<Integer, Integer> li : fruitStore.entrySet()) {
            if (li.getValue() > firstBig) {
                secondBig = firstBig;
                firstBig = li.getValue();
            } else if (li.getValue() > secondBig) {
                secondBig = li.getValue();
            }
        }

        return firstBig + secondBig;
    }
}
