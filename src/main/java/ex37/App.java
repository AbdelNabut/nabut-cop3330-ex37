/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */

package ex37;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        int minLength, specialCharacters, numbers;
        Scanner input = new Scanner(System.in);
        System.out.print("What is the minimum length? ");
        minLength = input.nextInt();
        System.out.print("How many special characters? ");
        specialCharacters = input.nextInt();
        System.out.print("How many numbers? ");
        numbers = input.nextInt();
        System.out.println("Your password is: " + PasswordGenerator.generate(minLength, specialCharacters, numbers));

    }
}
