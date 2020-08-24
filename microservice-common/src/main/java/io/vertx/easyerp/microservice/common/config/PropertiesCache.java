package io.vertx.easyerp.microservice.common.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kaf
 */
public class PropertiesCache {
    
    private final Properties configProp = new Properties();

    private PropertiesCache() {
        
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        
        
        try {
            configProp.load(in);
        } catch (IOException e) {
            Logger.getLogger(PropertiesCache.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }



    public Map<String, String> getProperties() {
        Stream<Map.Entry<Object, Object>> stream = configProp.entrySet().stream();
        return stream.collect(Collectors.toMap(e -> String.valueOf(e.getKey()), e -> String.valueOf(e.getValue())));
    }
    
    
}
