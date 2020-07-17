package homeWork1;

import java.util.*;

public class MainHW1 {

    public static void main(String[] args) {

        //проверка работоспособности метода (задание 1)//
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        System.out.println("String[] letters: " + Arrays.asList(letters));
        twoItemsSwap(letters, 0, 4);

        //метод из задания 2//
        convertToArrayList(letters);

        //Проверка работоспособности методов из 3 задачи//
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        //добавляем фрукты в коробки//
        appleBox1.addFruit(a1);
        appleBox1.addFruit(a2);
        appleBox2.addFruit(a3);
        orangeBox1.addFruit(o1);
        orangeBox2.addFruit(o2);

        //проверяем, что фрукты корректно добавлены//
        printBoxInfo("appleBox1", appleBox1);
        printBoxInfo("appleBox2", appleBox2);
        printBoxInfo("orangeBox1", orangeBox1);
        printBoxInfo("orangeBox2", orangeBox2);

        //проверяем работоспособность метода compare() - "сравнить вес коробок"//
        System.out.println("Сравнение appleBox1 и appleBox2: " + appleBox1.compare(appleBox2));
        System.out.println("Сравнение appleBox1 и orangeBox1: " + appleBox1.compare(orangeBox1));
        System.out.println("Сравнение orangeBox1 и orangeBox2: " + orangeBox1.compare(orangeBox2));

        //проверяем работоспособность метода intersperse() - "пересыпать"//
        orangeBox1.intersperse(orangeBox2);
        System.out.println("Пересыпали апельсины из orangeBox1 в orangeBox:");
        printBoxInfo("orangeBox1", orangeBox1);
        printBoxInfo("orangeBox2", orangeBox2);
    }

    //Метод для задания 1//
    public static <T> void twoItemsSwap(T[] arr, int item1, int item2){
        T temp = arr[item1];
        arr[item1] = arr[item2];
        arr[item2] = temp;
        System.out.println("String[] letters after twoItemsSwap(" + item1 + ", " + item2 +"): "
                + Arrays.asList(arr) + "\n");
    }

    //Метод для задания 2//
    public static <T> ArrayList convertToArrayList(T[] arr){
        return new ArrayList(Arrays.asList(arr));
    }

    //проверяем работоспособность метода getWeight() - "высчитать вес коробки с фруктами"//
    private static void printBoxInfo(String boxName, Box i) {
        System.out.printf("%s: Количество фруктов %d, вес коробки %.1f \n",boxName,i.getSize(),i.getWeight());
    }

}
