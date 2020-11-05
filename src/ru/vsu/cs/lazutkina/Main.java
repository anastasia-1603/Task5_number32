package ru.vsu.cs.lazutkina;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        drawFigure(checkSizeLimits(readSize()));
    }

    private static int readSize()
    {
        System.out.print("Enter shape size [size >= 3, odd number]: ");
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }

    private static int checkSizeLimits(int size)
    {
        while (size % 2 == 0 || size < 3)
        {
            System.out.println("You entered an even number and/or less than 3.");
            size = readSize();
        }
        return size;
    }

    private static void drawFigure(int size)
    {
        int number = 0;
        int halfSize = size / 2;
        for (int row = 0; row < size; row++)
        {
            for (int position = 0; position < size; position++)
            {
                if (position == halfSize)
                {
                    number = printNumber(number);
                    continue;
                }
                if (position == halfSize - row)
                {
                    number = printNumber(number);
                    continue;
                }
                if (position == halfSize + row)
                {
                    number = printNumber(number);
                    continue;
                }
                if (position == row - halfSize)
                {
                    number = printNumber(number);
                    continue;
                }
                if (position == 3 * halfSize  - row)
                {
                    number = printNumber(number);
                    continue;
                }
                if (row == halfSize)
                {
                    number = printNumber(number);
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int printNumber(int number)
    {
        System.out.print(number);
        return number == 9 ? 0 : number + 1;
    }
}
