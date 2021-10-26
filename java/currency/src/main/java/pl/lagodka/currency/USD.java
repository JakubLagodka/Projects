package pl.lagodka.currency;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")

public class USD implements Currency{
    @RequestMapping("USD")
    @Override
    public double value() {
        return 5.55;
    }
}
