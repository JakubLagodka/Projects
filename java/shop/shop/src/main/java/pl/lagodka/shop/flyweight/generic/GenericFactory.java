package pl.lagodka.shop.flyweight.generic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.generic.strategy.GenericStrategy;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenericFactory <K,V extends GenericStrategy<K>>{
    private final List<V> strategyList;
    private Map<K,V> strategyMap;

    @PostConstruct
    void init(){
        strategyMap = strategyList.stream()
                .collect(Collectors.toMap(V::getType, Function.identity()));
    }

    public V getStrategyByType(K type){
        return strategyMap.get(type);
    }
}
