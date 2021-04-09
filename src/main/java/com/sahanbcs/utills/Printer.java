package com.sahanbcs.utills;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Printer {

    private Printer(){

    }

    public static void print(String str)   {
        Logger logger = Logger.getLogger(Printer.class.getName() );
        FileHandler fileHandler;

        try {
            fileHandler = new FileHandler("C:\\Users\\sahan_k\\Desktop\\sahan_k\\sahan-Crpto\\SahanCrypto\\certificates\\log\\sahanlog.txt",true);
            logger.addHandler(fileHandler);
            SimpleFormatter sf = new SimpleFormatter();
            fileHandler.setFormatter(sf);
            logger.log(Level.INFO, str);
        }catch (IOException e){
            e.printStackTrace();
        }




    }

    public static  void outln(String str){
        System.out.println(str);
    }
    public static  void out(String str){
        System.out.print(str);
    }
}
