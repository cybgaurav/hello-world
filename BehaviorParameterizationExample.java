import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Apple {
    String colour;
    int weight;
    public String getColour() {
        return this.colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

//model selection criteria - We are working with apples and returing boolean based on some attributes of apple
interface ApplePredicate<Apple> {
    boolean test(Apple apple);
}


//multiple implementations to represent different selection criteria [Strategy Pattern]

//Below classes defines a family of algorithms and encapsulate each algorithm
//Strategy 1
class GreenApplesPredicate implements ApplePredicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.getColour().equalsIgnoreCase("green");          //Algoritthm 1
    }

}

//Strategy 2
class HeavyWeightApplesPredicate implements ApplePredicate<Apple> {

    @Override
    public boolean test(Apple apple) {
       return apple.getWeight() > 150;                               //Algoritthm 2
    }

}

public class BehaviorParameterizationExample {

    /**
     * Generic Method for filtering Apples based on abstract critertia
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(predicate.test(apple)) {                         //predicate object encapsulates condition to test
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = Collections.EMPTY_LIST;

        List<Apple> greenApples = filterApples(inventory, new GreenApplesPredicate());

        //Using Java 8 Lambda
        List<Apple> redApples = filterApples(inventory, (Apple apple) -> "red".equalsIgnoreCase(apple.getColour()));

    }
}
