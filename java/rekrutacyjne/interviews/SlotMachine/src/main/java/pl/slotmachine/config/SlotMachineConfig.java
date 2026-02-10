package pl.slotmachine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.slotmachine.config.settings.SlotMachineSettings;
import pl.slotmachine.engine.PayoutEngine;
import pl.slotmachine.engine.Wheel;
import pl.slotmachine.engine.WheelEngine;
import pl.slotmachine.engine.model.ScoreTable;
import pl.slotmachine.service.SlotMachineService;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Configuration
public class SlotMachineConfig {

    @Bean
    public WheelEngine wheelEngine( List<Wheel> wheels, WheelEngine.SymbolSelector symbolSelector ) {
        return new WheelEngine( wheels, symbolSelector );
    }

    @Bean
    public PayoutEngine payoutEngine( ScoreTable scoreTable ) {
        return new PayoutEngine( scoreTable );
    }

    @Bean
    public List<Wheel> getWheels( SlotMachineSettings settings ) {
        return Stream.generate( () -> new Wheel( settings.getWheelSymbols() ) )
                .limit( settings.getNumberOfWheels() )
                .toList();
    }

    @Bean
    public ScoreTable getScoreTable( SlotMachineSettings settings ) {
        return new ScoreTable( settings.getScoreTable() );
    }

    @Bean
    public WheelEngine.SymbolSelector randomSymbolSelector( RandomGenerator randomGenerator ) {
        return wheel -> {
            int symbolIndex = randomGenerator.nextInt( 0, wheel.size() );
            return wheel.get( symbolIndex );
        };
    }
    @Bean
    public RandomGenerator randomGenerator() {
        return RandomGenerator.getDefault();
    }
}
