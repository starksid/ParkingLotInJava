package feesCalculatorStrategy;

import java.time.LocalDateTime;

public interface FeesCalculatorStrategy {
    int parkingFeesCalculator(LocalDateTime entryTime, LocalDateTime exitTime);
}
