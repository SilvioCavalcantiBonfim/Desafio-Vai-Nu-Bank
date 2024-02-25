package domain.entity.account.savingsaccount;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SavingsDeposit(
    BigDecimal value,
    LocalDate anniversary) {
}
