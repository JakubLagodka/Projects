package pl.slotmachine.config.settings.specific;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pl.slotmachine.engine.model.symbol.ShapeSymbol;

@Component
@Validated
@ConfigurationProperties(prefix = "slot-machine.shape")
@ConditionalOnProperty(value = "slot-machine.type",havingValue = "shape", matchIfMissing = false)
public class ShapeSymbolSlotMachineSettings  extends AbstractSlotMachineSettings<ShapeSymbol> {
}
