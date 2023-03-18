package com.example.juiceFactory2_0.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
//    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "com.example.juiceFactory2_0.resource");
        return properties;
    }
}
