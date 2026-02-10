package pl.slotmachine.config.settings.specific;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pl.slotmachine.engine.model.symbol.DigitalSymbol;
@Component
@Validated
@ConfigurationProperties (prefix = "slot-machine.digital")
@ConditionalOnProperty (value = "slot-machine.type",havingValue = "digital", matchIfMissing = false)
public class DigitalSymbolSlotMachineSettings extends AbstractSlotMachineSettings<DigitalSymbol> {
}
