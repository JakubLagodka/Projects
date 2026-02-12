package pl.lektury.config.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppSettings {
    @Value ( "${app.clients.clientWl.url}" )
    private  String settings;

    public String url(){
        return settings;
    };
}
