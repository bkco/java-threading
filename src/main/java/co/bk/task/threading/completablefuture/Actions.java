package co.bk.task.threading.completablefuture;

import co.bk.task.threading.model.CreditCard;
import co.bk.task.threading.model.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Actions {

    public Order placeOrder(String name) {
        log.info("Ordering item");

        Order order = new Order(name);
        delay(500);
        log.info("Processing order...");
        return order;
    }

    public Order checkAvailability(Order orderItem) {
        log.info("Checking availability of orderItem " + orderItem.getName());
        delay(2500);
        log.info("Item is in stock!");
        return orderItem.getName();
    }

    public Order checkCreditCard(CreditCard creditCard) {
        log.info("Checking validity of credit card " + creditCard.getNumber());
        delay(2000);
        log.info("Credit card is valid!");
        return creditCard.getNameOnCard();
    }

    public int generateOrderNumber(String orderItemName, String nameOnCard) {
        log.info("Order number for item: {}  and credit card owned by: {}", orderItemName, nameOnCard);
        return ThreadLocalRandom.current().nextInt();
    }

    private void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}