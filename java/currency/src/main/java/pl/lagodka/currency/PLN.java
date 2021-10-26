package pl.lagodka.currency;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")

public class PLN implements Currency{
    @RequestMapping("PLN")
    @Override
    public double value() {
        return 3.55;
    }
}
