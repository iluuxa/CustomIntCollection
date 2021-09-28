package stu.ilexa;

/**
 * Класс, реализующий некоторые возможности коллекции в Java для переменных типа {@link int}
 * @author Ясько Илья
 */
public class Collection {


    /**
     * Поле, хранящее данные коллекции в виде одномерного целочисленного массива
     */
    private int[] a = new int[0];


    /**
     * Метод добавления переданного в качестве аргумента элемента в коллекцию
     * @param data любое целочисленное значение, которое планируется добавить в коллекцию
     */
    public void addElement(int data) {
        int[] temp = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        temp[a.length] = data;
        a = temp;
    }


    /**
     * Метод удаления элемента из коллекции. В случае отсутствия элемента ничего не происходит.
     * @param ind целочисленное значение индекса элемента, который планируется удалить из коллекции
     */
    public void deleteElement(int ind) {
        if (a.length<=0){return;}
        int[] temp = new int[a.length - 1];
        int k = 0;
        boolean found = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (i == ind) {
                found = true;
            }
            if (found) {
                temp[i] = a[i + 1];
            } else {
                temp[i] = a[i];
            }
        }
        a = temp;
    }


    /**
     * Метод получения элемента в коллекции по индексу
     * @param ind индекс коллекции. Должно быть передано число больше или равное нулю, но не превышающее размера коллекции
     * @return возвращает целочисленный элемент коллекции по индексу, переданному в аргументе
     */
    public int indexSearch(int ind) {
        return a[ind];
    }

    /**
     * Метод получения индекса элемента в коллекции по значению
     * @param data любое целочисленное число, индекс которого ищется в коллекции
     * @return возвращает индекс первого найденного в коллекции числа со значением аргумента или -1, если такого числа нет
     */
    public int dataSearch(int data) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == data) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Метод получения минимального значения коллекции. В случае, если коллекция пустая, метод возвращает максимальное возможное значение целочисленной переменной
     * @return возвращает минимальный целочисленный элемент коллекции или максимальное значение типа {@link int}
     */
    public int minSearch() {
        int min = 0;
        boolean noMin = true;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] < min) || (noMin)) {
                min = a[i];
                noMin = false;
            }
        }
        if(noMin){return Integer.MAX_VALUE;}
        return min;
    }

    /**
     * Метод возврата максимального элемента коллекции. В случае, если коллекция пустая, метод возвращает минимальное возможное значение целочисленной переменной
     * @return возвращает максимальный целочисленный элемент коллекции или минимальное значение типа {@link int}
     */
    public int maxSearch() {
        int max = 0;
        boolean noMax = true;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] > max) || (noMax)) {
                max = a[i];
                noMax = false;
            }
        }
        if(noMax){return Integer.MIN_VALUE;}
        return max;
    }


    /**
     * Метод получения среднего арифметического всех элементов коллекции. При отсутствии элементов возвращает 0 и сообщает об ошибке через терминал.
     * @return возвращает среднеее арифметическое значение всех элементов коллекции
     */
    public double averageCount() {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (a.length != 0) {
            return sum / a.length;
        } else {
            System.out.println("Ошибка! Нет элементов");
            return 0;
        }
    }

    /**
     * Метод получения размера коллекции
     * @return возвращает размер массива {@link Collection#a}
     */
    public int getLength() {
        return a.length;
    }


    /**
     * Метод возврата коллекции в удобном для отображения строковом виде
     * @return возвращает строку, в которой элементы коллекции чередуются с символом новой строки
     */
    public String toMultilineString() {
        StringBuilder res = new StringBuilder();
        if (a.length > 0) {
            res.append(a[0]);
            for (int i = 1; i < a.length; i++) {
                res.append("\n").append(a[i]);
            }
        }
        return res.toString();
    }
}
