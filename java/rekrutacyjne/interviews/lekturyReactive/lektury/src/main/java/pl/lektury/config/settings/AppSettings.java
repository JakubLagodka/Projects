package pl.lektury.config.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.aot.AbstractAotProcessor;
import org.springframework.web.reactive.function.client.WebClient;

public class AppSettings {
    @Value ( "${app.clients.clientWl.url}" )
    private  settings;

    public WebClient clients(){
        return settings;
    };
}
