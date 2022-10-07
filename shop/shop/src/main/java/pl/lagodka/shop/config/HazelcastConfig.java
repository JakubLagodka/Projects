package pl.lagodka.shop.config;

import com.hazelcast.config.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lagodka.shop.model.dao.Product;

@Configuration
@EnableCaching
public class HazelcastConfig {
    @Bean
    public Config configHazelcast() {
        Config config = new Config()
                .setInstanceName("instance-1")
                .addMapConfig(new MapConfig()
                        .setName("product")
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(10)
                                .setEvictionPolicy(EvictionPolicy.LFU)
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE))
                        .setTimeToLiveSeconds(60 * 5));
        config.getSerializationConfig().addDataSerializableFactory(1, id -> id == 1 ? new Product() : null);
        return config;
    }
}
