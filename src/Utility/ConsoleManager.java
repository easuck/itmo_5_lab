package Utility;

import java.util.Scanner;

public class ConsoleManager {

    private Scanner scanner = new Scanner(System.in);

    public String readString(){
        if (!ifScannerHasNext()){
            exit();
        }
        return scanner.nextLine();
    }

    public boolean ifScannerHasNext(){
        return scanner.hasNextLine();
    }

    public void print(Object out){
        System.out.print(out);
    }

    public void println(Object out){
        System.out.println(out);
    }

    public void exit(){
        System.exit(0);
    }
}
