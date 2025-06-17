import java.util.*;

public class Main {
    public static void main(String[] args) {
        BurgerGraph stepBurger = new BurgerGraph();

        String[] steps = {
            "Preheat Oven", "Bake Bread", "Serve Bread", "Preheat Pan", "Set Plate", "Add some pickles",
            "Add Krabby Patty", "Serve Patty", "Add Tartar Sauce", "Pour Sauce Over Patty", "Eat"
        };

        for (String step : steps) {
            stepBurger.addStep(step);
        }

        stepBurger.addEdge("preheat oven", "bake bread");
        stepBurger.addEdge("preheat oven", "preheat pan");
        stepBurger.addEdge("preheat pan", "set plate");
        stepBurger.addEdge("set plate", "serve bread");
        stepBurger.addEdge("set plate", "add some pickles");
        stepBurger.addEdge("set plate", "serve patty");
        stepBurger.addEdge("bake bread", "serve bread");
        stepBurger.addEdge("preheat pan", "add krabby patty");
        stepBurger.addEdge("add krabby patty", "serve patty");
        stepBurger.addEdge("add krabby patty", "add tartar sauce");
        stepBurger.addEdge("serve patty", "pour sauce over patty");
        stepBurger.addEdge("add tartar sauce", "pour sauce over patty");
        stepBurger.addEdge("pour sauce over patty", "eat");
        stepBurger.addEdge("serve bread ", "eat");
        stepBurger.addEdge("add some pickles", "eat");

        System.out.println("(langkah berdekatan ditampilkan terlebih dahulu <BFS> ):");
        stepBurger.bfs("preheat oven");

        System.out.println("(langkah menjauh ditampilkan terlebih dahulu <DFS> ):");
        Set<String> visited = new HashSet<>();
        stepBurger.dfs("preheat oven", visited);

    }
}
