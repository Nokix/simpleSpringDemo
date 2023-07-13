package gmbh.db.simpleSpringDemo.aop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("aop")
public class ShoppingCartRunner implements CommandLineRunner {
    @Autowired
    ShoppingCart shoppingCart;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hallo Welt! Zeit zum Shoppen!");
        System.out.println(shoppingCart.checkout());
        Item cola = new Item("Cola", 100);
        Item katzenfutter = new Item("Katzenfutter", 50);
        shoppingCart.addItem(cola);
        shoppingCart.addItem(cola);
        shoppingCart.addItem(cola);
        shoppingCart.addItem(katzenfutter);
        shoppingCart.removeItem(cola);
        System.out.println(shoppingCart.checkout());
    }
}


