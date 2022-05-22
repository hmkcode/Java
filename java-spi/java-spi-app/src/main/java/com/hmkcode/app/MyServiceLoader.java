package com.hmkcode.app;

import java.nio.file.ProviderNotFoundException;
import java.util.Iterator;
import java.util.ServiceLoader;

import com.hmkcode.api.MyServiceProviderInterface;


public class MyServiceLoader {

    private static final String DEFAULT_PROVIDER = "com.hmkcode.impl.MyServiceProviderImpl1";
    
    public static MyServiceProviderInterface defaultProvider() {
    	return provider(DEFAULT_PROVIDER);
    }
    
    public static MyServiceProviderInterface provider(String providerName) {
        ServiceLoader<MyServiceProviderInterface> loader = ServiceLoader.load(MyServiceProviderInterface.class);

        Iterator<MyServiceProviderInterface> it = loader.iterator();
        while (it.hasNext()) {
        	MyServiceProviderInterface provider = it.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("provider " + providerName + " not found");
    }
    
}
