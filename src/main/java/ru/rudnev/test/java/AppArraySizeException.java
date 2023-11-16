package ru.rudnev.test.java;

public class AppArraySizeException extends Exception{
    public AppArraySizeException(){
        super("Размер массива должен быть 4x4");
    }
}
