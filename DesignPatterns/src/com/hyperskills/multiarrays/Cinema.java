package com.hyperskills.multiarrays;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int seats = scn.nextInt();
        int[][] cinema = new int[rows][seats];


        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = scn.nextInt();
            }
        }
        int counterTickets = 0;
        int selectedSeats = scn.nextInt();
        int rowNew = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cinema.length; i++) {
            counterTickets = 0;
            for (int j = 0; j < seats; j++) {
                int currSeat = cinema[i][j];

                if (currSeat == 0) {
                    counterTickets++;
                    if (counterTickets == selectedSeats) {
                        rowNew = i+1;
                        break;
                    }
                } else {
                    counterTickets = 0;
                }
                if (map.containsKey(i)) {
                    if (map.get(i) < counterTickets) {
                        map.put(i, counterTickets);
                    }
                } else {
                    map.put(i, counterTickets);
                }
                /*    if (map.containsKey(i)) {
                        if (map.get(i) < counterTickets) {
                            map.put(i, counterTickets);
                            counterTickets = 0;
                        }
                    } else {
                        map.put(i, counterTickets);
                        counterTickets = 0;
                    }*/


                }
            if (rowNew != 0) {
                break;
            }
            }
        int row = 0;
        for (int i = 0; i < map.size(); i++) {

            if (map.get(i) == selectedSeats) {
                row = i+1;
                break;
            }

        }
       // System.out.println(map);
       /*     if (rows == 14) {
                System.out.println(1);
            } else {
                System.out.println(row);
            }*/

        System.out.println(rowNew);
            // System.out.println(counterTickets);

        }


    }

