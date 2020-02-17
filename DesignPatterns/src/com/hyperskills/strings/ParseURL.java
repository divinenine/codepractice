package com.hyperskills.strings;

import java.util.Scanner;

public class ParseURL {

    static String pass = "";
    static String port = "";
    static String cookie = "";
    static String host = "";
    static  String password = "";
    static  String name = "";

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String URL = scn.nextLine();

        if (URL.contains("pass=")) {
            int passStart = URL.indexOf("pass=");
            int passEnd = URL.indexOf("&", passStart);
            password = "password : " + URL.substring(passStart+5, passEnd);
            pass = "pass : " + URL.substring(passStart+5, passEnd);
            System.out.println(pass);
        }
        if (URL.contains("port=")) {
            int passStart = URL.indexOf("port=");
            int passEnd = URL.indexOf("&", passStart);
            port = "port : " + URL.substring(passStart+5, passEnd);
            System.out.println(port);
        }
        if (URL.contains("name=")) {
            int passStart = URL.indexOf("name=");
            int passEnd = URL.indexOf("&", passStart);
            name = "name : " + URL.substring(passStart+5, passEnd);
            System.out.println(name);
        }
        if (URL.contains("cookie=&")) {
            cookie = "cookie : not found";
            System.out.println(cookie);
        } else if (URL.contains("cookie=")) {
            int passStart = URL.indexOf("cookie=");
            int passEnd = URL.indexOf("&", passStart);
            cookie = "cookie : " + URL.substring(passStart+7, passEnd);
            System.out.println(cookie);
        }
        if (URL.contains("host=")) {
            int passStart = URL.indexOf("host=");
           // int passEnd = URL.indexOf("&", passStart);
            host = "host : " + URL.substring(passStart+5);
            System.out.println(host);
        }

        if (!pass.equals("")) {
            System.out.println(password);
        }


    }

}
