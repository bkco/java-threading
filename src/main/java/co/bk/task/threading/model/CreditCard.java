package co.bk.task.threading.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreditCard {

    private final String number;

    private final String nameOnCard;
}