package gmbh.db.simpleSpringDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UpdateAspekt {

    @Around("within(ShoppingCart) && args(item)")
    public Object update(ProceedingJoinPoint joinPoint, Item item) throws Throwable {
        ShoppingCart shoppingCart = (ShoppingCart) joinPoint.getTarget();

        if (item.name.equals("Cola")) {
            System.out.println("Cola ist verboten!");
            return null;
        }

        System.out.println(item.name + " ist erlaubt");
        Object result = joinPoint.proceed();
        shoppingCart.update_amount();
        shoppingCart.update_price();
        return result;
    }
}
