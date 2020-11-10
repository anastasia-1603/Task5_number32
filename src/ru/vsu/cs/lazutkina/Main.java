package ru.vsu.cs.lazutkina;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        drawFigure(readSize());
    }

    private static int readInt(String phrase)
    {
        Scanner scn = new Scanner(System.in);
        System.out.print(phrase);
        return scn.nextInt();
    }

    private static int readSize()
    {
        int size = readInt("Enter shape size [size >= 3, odd number]: ");
        while (!checkSizeLimits(size))
        {
            size = readInt("You entered an even number and/or less than 3. Try again: 1");
        }
        return size;
    }

    private static boolean checkSizeLimits(int size)
    {
        return (size % 2 != 0 && size >= 3);
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
