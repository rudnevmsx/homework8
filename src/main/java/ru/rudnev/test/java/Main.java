package ru.rudnev.test.java;

public class Main {
    /**
     *
     * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
     * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
     * Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
     * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     * В методе main() необходимо вызвать полученный метод, обработать возможные исключения
     * AppArraySizeException и AppArrayDataException и вывести результат расчета
     * (сумму элементов, при условии что подали на вход корректный массив).
     */
    public static void main(String[] args) {
        String arr[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            int sum = arrSum(arr);
            System.out.println("Сумма элементов массива: " + sum);
        }
        catch (AppArraySizeException | AppArrayDataException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int arrSum(String[][] arr) throws AppArraySizeException, AppArrayDataException{
        if (arr.length != 4 || arr[0].length != 4) {
            throw new AppArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 4){
                throw new AppArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try{
                    int item = Integer.parseInt(String.valueOf(arr[i][j]));
                    sum += item;
                } catch (NumberFormatException e){
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}