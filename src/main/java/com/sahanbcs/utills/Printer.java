package com.sahanbcs.utills;
import java.util.logging.Logger;

public class Printer {

    private Printer(){

    }

    public static void print(String str){
        Logger logger = Logger.getLogger(Printer.class.getName() );
        logger.info(str);
    }
}
