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

        // logger.debug("This is a debug message");
        // logger.warn("This is a warning message");

        // Load config from environment variables
        // Or, .emv file
        // Or, default values

        var cfg = new Config();
        String host = cfg.getStringVariable("PORTCHECKER_HOST", "portquiz.net");
        int port = cfg.getIntVariable("PORTCHECKER_PORT", 443);
        int timeout = cfg.getIntVariable("PORTCHECKER_TIMEOUT_MS", 5_000);


        // Parse command-line arguments
        // Check if port was redefined via command-line argument

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

        // Start resolving hostname to IP address
        // and measure time
        // We will have an array of IP addresses

        InetAddress[] addresses = null;
        long startTime = System.currentTimeMillis();

        try {
            addresses = InetAddress.getAllByName(host);
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve hostname: " + host);
            System.exit(1);
        }

        long endTime = System.currentTimeMillis();
        long timeResolve = endTime - startTime;


        // Report on results of
        // resolving hostname to IP address

        var msg = String.format("Testing connection: %1$s:%2$d, timeout: %3$d ms", host, port, timeout);
        logger.info(msg);

        if (addresses.length > 1) {
            var msgFound = String.format("Found %1$d addresses for host %2$s", addresses.length, host);
            logger.info(msgFound);
        }
        else if (addresses.length == 1) {
            var resolveMsg = String.format("Host %1$s resolved to %2$s:", host, addresses[0].getHostAddress());        
            logger.info(resolveMsg);
        }
        else {
            //should not happen, actually
            System.out.println("Unable to resolve hostname: " + host);
            System.exit(1);
        }


        // Resolve done!
        // Iterate over all addresses
        // Connect and measure time


        for (InetAddress addr: addresses) {

            // System.out.println(addr.getHostAddress());
            String ipAddress = addr.getHostAddress();

            try {
                var con = new TCPConnection(addr, port);
                long timeConnect = con.ping(timeout);
                // Socket socket = new Socket();

                // startTime = System.currentTimeMillis();
                // socket.connect(dst, timeout);
                // endTime = System.currentTimeMillis();
                // long timeConnect = endTime - startTime;
                
                var successMsg = String.format("Success connect: %1$s:%2$d", ipAddress, port);
                System.out.println(successMsg);

                var timeMsg = String.format("%1$s: time to resolve: %2$d, time to connect: %3$d", ipAddress, timeResolve, timeConnect);
                logger.info(timeMsg);
                
            } catch (IOException e) {

                var failMsg = String.format("Fail connect: %1$s:%2$d", ipAddress, port);
                logger.error(failMsg);

            }
        }
        //the end
    }
}
