import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PassingCodeExample {

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

    /**
     * Methods Specific to criteria
     * @param inventory
     * @return
     */

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(apple.getColour().equalsIgnoreCase("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Methods Specific to criteria
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * Generic Method for filtering Apples
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Collections.EMPTY_LIST;
        //How to use generic method ?

       // 1. Use Anonymous class
       List<Apple> greenApples = filterApples(inventory, new Predicate<Apple>(){

        @Override
        public boolean test(Apple t) {
            return t.getColour().equalsIgnoreCase("green");
        }

       });

       //2. Pass method reference. We can pass method as a parameter to function
       List<Apple> heavyApples = filterApples(inventory, PassingCodeExample::isHeavyApple);

       //It is bit annoying to create short function like isHeavyApple, especially when it's going to be used once or max twice.

       //3. Anonymous functions (lambdas)
       List<Apple> redApples = filterApples(inventory, (Apple apple) -> apple.getColour().equalsIgnoreCase("red"));

       //When to use Anonymous functions (lambdas) and when to use method reference ?
       //If lambda exceeds few lines in length then you should method reference with clear/discrptive method name...It's little difficult to write
       //lambda with few lines of code

    }



}
