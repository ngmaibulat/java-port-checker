package com.ngm;

import java.util.regex.Pattern;

public class IPAddressChecker {
    // public static void main(String[] args) {
    //     String input1 = "192.168.0.1";
    //     String input2 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
    //     String input3 = "example.com";
        
    //     System.out.println("Input 1:");
    //     checkIPAddress(input1);
    //     System.out.println("Input 2:");
    //     checkIPAddress(input2);
    //     System.out.println("Input 3:");
    //     checkIPAddress(input3);
    // }
    
    public static boolean isValidIPv4Address(String input) {
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.)){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipv4Pattern, input);
    }
    
    public static boolean isValidIPv6Address(String input) {
        String ipv6Pattern = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
        return Pattern.matches(ipv6Pattern, input);
    }
    
    public static boolean isValidFQDN(String input) {
        String fqdnPattern = "^(?=.{1,255}$)[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*$";
        return Pattern.matches(fqdnPattern, input);
    }
}
