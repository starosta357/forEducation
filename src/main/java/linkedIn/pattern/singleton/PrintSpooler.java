package linkedIn.pattern.singleton;

public class PrintSpooler {

    private static final PrintSpooler spooler = new PrintSpooler();

    private static boolean initialized = false;

    private PrintSpooler(){}

    private void init(){
        // code to init spooler
    }

    public static synchronized PrintSpooler getInstance(){
        if (initialized) return spooler;
        spooler.init();
        initialized = true;
        return spooler;
    }
}
