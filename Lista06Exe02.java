// Interface para os sanduíches
interface Sandwich {
    void prepare();
}

// Implementação de um sanduíche básico
class BasicSandwich implements Sandwich {
    @Override
    public void prepare() {
        System.out.print("Bread");
    }
}

// Classe abstrata de um decorador de sanduíches
abstract class SandwichDecorator implements Sandwich {
    protected Sandwich decoratedSandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.decoratedSandwich = sandwich;
    }

    @Override
    public void prepare() {
        decoratedSandwich.prepare();
    }
}

// Decorador para alface
class LettuceDecorator extends SandwichDecorator {
    public LettuceDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.print(" + Lettuce");
    }
}

// Decorador para tomate
class TomatoDecorator extends SandwichDecorator {
    public TomatoDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.print(" + Tomato");
    }
}

// Decorador para queijo
class CheeseDecorator extends SandwichDecorator {
    public CheeseDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.print(" + Cheese");
    }
}

// Classe principal
public class Lista06Exe02 {
    public static void main(String[] args) {
        Sandwich basicSandwich = new BasicSandwich();
        
        // Adicionando acréscimos ao sanduíche básico
        Sandwich sandwichWithLettuce = new LettuceDecorator(basicSandwich);
        Sandwich sandwichWithLettuceAndTomato = new TomatoDecorator(sandwichWithLettuce);
        Sandwich fullyLoadedSandwich = new CheeseDecorator(sandwichWithLettuceAndTomato);
        
        System.out.print("Sandwich with ingredients: ");
        fullyLoadedSandwich.prepare(); // Output: Bread + Lettuce + Tomato + Cheese
    }
}
