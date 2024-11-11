// Interface para os sanduíches
interface Sandwich {
    void prepare();
}

// Implementações concretas de sanduíches
class BeefSandwich implements Sandwich {
    @Override
    public void prepare() {
        System.out.println("Preparing beef sandwich...");
    }
}

class ChickenSandwich implements Sandwich {
    @Override
    public void prepare() {
        System.out.println("Preparing chicken sandwich...");
    }
}

class VeganSandwich implements Sandwich {
    @Override
    public void prepare() {
        System.out.println("Preparing vegan sandwich...");
    }
}

// Classe abstrata de uma loja de sanduíches (Creator)
abstract class SandwichStore {
    public Sandwich orderSandwich() {
        Sandwich sandwich = createSandwich();
        sandwich.prepare();
        return sandwich;
    }
    protected abstract Sandwich createSandwich();
}

// Implementação concreta de cada loja
class BeefBurgerStore extends SandwichStore {
    @Override
    protected Sandwich createSandwich() {
        return new BeefSandwich();
    }
}

class ChickenBurgerStore extends SandwichStore {
    @Override
    protected Sandwich createSandwich() {
        return new ChickenSandwich();
    }
}

class VeganBurgerStore extends SandwichStore {
    @Override
    protected Sandwich createSandwich() {
        return new VeganSandwich();
    }
}

// Classe principal
public class Lista06Exe01 {
    public static void main(String[] args) {
        SandwichStore beefStore = new BeefBurgerStore();
        SandwichStore chickenStore = new ChickenBurgerStore();
        SandwichStore veganStore = new VeganBurgerStore();

        beefStore.orderSandwich();
        chickenStore.orderSandwich();
        veganStore.orderSandwich();
    }
}
