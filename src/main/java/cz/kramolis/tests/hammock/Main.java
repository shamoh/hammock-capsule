package cz.kramolis.tests.hammock;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.slf4j.bridge.SLF4JBridgeHandler;

public class Main {

    public static void main(String[] args) {
        initJulToSlf4jBridge();

        Logger.getLogger(Main.class.getName()).finest("Args: " + Arrays.toString(args));

        ws.ament.hammock.Bootstrap.main(args);
    }

    private static void initJulToSlf4jBridge() {
        LogManager.getLogManager().reset();
        Logger.getLogger("").setLevel(Level.FINEST);
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

}
