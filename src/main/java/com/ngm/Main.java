package com.ngm;

import java.net.SocketTimeoutException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.UTF8TableFormat;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // logger.info("This is an informational message");
        // logger.debug("This is a debug message");
        // logger.warn("This is a warning message");
        // logger.error("This is an error message");

        var cfg = new Config();
        String host = cfg.getStringVariable("PORTCHECKER_HOST", "portquiz.net");
        int port = cfg.getIntVariable("PORTCHECKER_PORT", 443);
        //PORTCHECKER_TIMEOUT_MS
        int timeout = cfg.getIntVariable("PORTCHECKER_TIMEOUT_MS", 5_000);

        if (args.length > 0) {
            // Assuming the first command-line argument is the integer value
            String arg = args[0];
            try {
                port = Integer.parseInt(arg);
                if (port < 1 || port > 65535) {
                    var invalidPortMsg = String.format("Invalid port was specified, exiting...");
                    logger.info(invalidPortMsg);
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                var invalidPortMsg = String.format("Invalid port was specified, exiting...");
                logger.info(invalidPortMsg);
                System.exit(1);
            }
        } else {
            var portMsg = String.format("Port was not specified, using: %1$d", port);
            logger.info(portMsg);
        }

        InetAddress address = null;
        InetSocketAddress dst = null;
        String ipAddress = null;

        try {
            address = InetAddress.getByName(host);
            ipAddress = address.getHostAddress();
            dst = new java.net.InetSocketAddress(address, port);
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve hostname: " + host);
            System.exit(1);
        }
        

        var msg = String.format("Testing connection: %1$s:%2$d, timeout: %3$d ms", host, port, timeout);
        var resolveMsg = String.format("Host %1$s resolved to %2$s:", host, ipAddress);
        var successMsg = String.format("Success connect: %1$s:%2$d", host, port);
        var failMsg = String.format("Fail connect: %1$s:%2$d", host, port);

        logger.info(msg);
        logger.info(resolveMsg);

        try {
            Socket socket = new Socket();
            socket.connect(dst, timeout);

            System.out.println(successMsg);
            socket.close();
        } catch (IOException e) {
            System.out.println(failMsg);
            //let's return non-zero exit code
            //to indicate that connection failed
            //so it can be used in scripting
            System.exit(2);
        }
        //the end
    }
}
