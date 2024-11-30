package org.example;

import java.util.Scanner;

public class Coder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordInitial = sc.nextLine();
        char[] charWord = wordInitial.toCharArray();

        StringBuilder sb = new StringBuilder();


        for (char c : charWord) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    sb.append((char) ('a' + ((c - 'a' + 3) % 26)));
                } else if (Character.isUpperCase(c)) {
                    sb.append((char) ('A' + ((c - 'A' + 3) % 26)));
                }
            } else {
                sb.append(c);
            }
        }

        sb.reverse();

        int index = sb.length() / 2;

        for (int i = index; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);
            if (Character.isLetter(currentChar)) {
                if (Character.isLowerCase(currentChar)) {
                   sb.setCharAt(i, (char) ('a' + ((currentChar - 'a' - 1 + 26) % 26)));
                } else if (Character.isUpperCase(currentChar)) {
                    sb.setCharAt(i, (char) ('A' + ((currentChar - 'A' - 1 + 26) % 26)));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
