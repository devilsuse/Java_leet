package com.nano;

/*
Lazy loading
 */
public class Miracle {
    private static Miracle instance;

    private Miracle(){

    }
    public static synchronized Miracle getInstance() {
        if (instance == null) {
            instance = new Miracle();
        }
        return instance;
    }
}

/*
Eagar initialization
 */
class MiracleEager {
    private final static MiracleEager instance = new MiracleEager();

    private MiracleEager(){

    }
    public static MiracleEager getInstance() {
        return instance;
    }
}