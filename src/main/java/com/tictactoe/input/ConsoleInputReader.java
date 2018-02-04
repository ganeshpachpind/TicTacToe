package com.tictactoe.input;


import com.tictactoe.algo.Move;

import java.util.Scanner;

/**
 * Read input only not validate
 */
public class ConsoleInputReader implements InputReader {

    @Override
    public Move getPlayerMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter cordinate in format x,y starting index 0");
        String input = sc.next();
        String[] split = input.split(",");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        return new Move(x, y);
    }
}
