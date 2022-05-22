package com.hmkcode.app;

public class App 
{
    public static void main( String[] args )
    {        
        MyServiceLoader.defaultProvider().getService().doSomething();
    }
}
