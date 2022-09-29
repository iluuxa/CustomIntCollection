package stu.ilexa;

import java.util.Scanner;

/**
 * Класс, обрабатывающий пользовательский ввод
 * @author Ясько Илья
 */
public class Main {

    /**
     * Основной метод класса {@link Main}
     * @param args аргументы командной строки. Не используются
     */
    public static void main(String[] args) {
        Collection a=new Collection();
        inputCycle(a);
    }


    /**
     * Метод генерации массива случайных чисел типа int
     * @param amount количество чисел, которые необходимо сгенерировать
     * @return массив случайных чисел типа int
     */
    public static int[] getRandomInts(int amount){
        int[] res = new int[amount];
        for (int i=0;i<amount;i++){
            res[i] = getRandomInt();
        }
        return res;
    }


    /**
     * Метод обработки пользовательского ввода через терминал с помощью объекта класса Scanner и вызова соответствующих запросам методов объекта коллекции, переданного в качестве аргумента.
     * @param a обрабатываемая коллекция
     */
    public static void inputCycle(Collection a){
        Scanner in = new Scanner(System.in);
        int temp;
        System.out.println("1 - Добавить элемент\n2 - Удалить элемент по индексу\n3 - Поиск по индексу\n4 - поиск по значению\n5 - найти минимальный элемент\n6 - найти максимальный элемент\n7 - Посчитать среднее арифметическое\n8 - Отобразить элементы\n9 - Добавить случайные элементы\n0 - Завершить работу");
        int sw=in.nextInt();
        while(sw!=0){
            switch (sw) {
                case 1 -> a.addElement(in.nextInt());
                case 2 -> a.deleteElement(in.nextInt());
                case 3 -> {
                    temp = in.nextInt();
                    if ((temp < a.getLength()) && (temp >= 0)) {
                        System.out.println("Значение элемента: " + a.indexSearch(temp));
                    } else {
                        System.out.println("Некорректный индекс");
                    }
                }
                case 4 -> {
                    temp = a.dataSearch(in.nextInt());
                    if (temp != -1) {
                        System.out.println("Индекс элемента: " + temp);
                    } else {
                        System.out.println("Нет элемента с этим значением");
                    }
                }
                case 5 -> System.out.println(a.minSearch());
                case 6 -> System.out.println(a.maxSearch());
                case 7 -> System.out.println("Среднее арифметическое: " + a.averageCount());
                case 8 -> System.out.println(a.toMultilineString());
                case 9 -> {
                    System.out.println("Введите количество случайно сгенерированных элементов:");
                    temp = in.nextInt();
                    int[] buff = getRandomInts(temp);
                    for (int i = 0; i < temp; i++) {
                        a.addElement(buff[i]);
                    }
                }
            }
            System.out.println("Введите следующее действие: ");
            sw=in.nextInt();
        }
    }


    /**
     * Метод генерации случайного числа типа int
     * @return случайное целое число на интервале (-2147483647; 2147483647]
     */
    public static int getRandomInt(){
        return (int)((Integer.MAX_VALUE*(0.5 - Math.random()))*2);
    }
}
