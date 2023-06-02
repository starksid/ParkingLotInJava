package feesCalculatorStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingFeesCalcutlator implements FeesCalculatorStrategy {
    @Override
    public int parkingFeesCalculator(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        int fees = (int) (duration.toHours()+1);
        fees*=100;

        return fees;
    }
}
