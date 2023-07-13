package gmbh.db.simpleSpringDemo.aop;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ShoppingCart {
    HashMap<Item, Integer> cart = new HashMap<>();

    int amount;
    int price;

    @TimeMe
    public Item addItem(Item item) {
        Integer currentAmount = this.cart.getOrDefault(item, 0);
        this.cart.put(item, currentAmount + 1);

        return item;
    }

    public Item removeItem(Item item) {
        Integer currentAmount = this.cart.getOrDefault(item, 0);
        if (currentAmount <= 1) {
            this.cart.remove(item);
        } else {
            this.cart.put(item, currentAmount - 1);
        }

        return item;
    }

    private void update() {
        update_price();
        update_amount();
    }

    public void update_amount() {
        this.amount = this.cart.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void update_price() {
        this.price = this.cart.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public String checkout() {
        return "You have " + amount + " number of items for  a price of " + price;
    }

}
