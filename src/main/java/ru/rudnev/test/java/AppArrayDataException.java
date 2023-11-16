package ru.rudnev.test.java;

public class AppArrayDataException extends Exception {
    public AppArrayDataException(int row, int col){
        super("Неверные данные в ячейке: [" + row + "][" + col + "]");
    }
}
