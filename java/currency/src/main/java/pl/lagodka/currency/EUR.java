package pl.lagodka.currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class EUR implements Currency {
    @GetMapping("/EUR")
    @Override
    public double value() {
        return 4.55;
    }
}
