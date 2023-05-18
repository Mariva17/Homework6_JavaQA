package Homework_Lesson8;

public class ListTest {

    public static void main(String[] args) {

        MyLinkedList_2 list2 = new MyLinkedList_2();
            list2.add("Hello");
            list2.add("everybody");
            list2.add("and");
            list2.add("Java");
            list2.addToTail("NewWord");
            list2.addToHead("Python");


        System.out.println("Вывод в консоль с помощью toString");
        System.out.println(list2);
        System.out.println();

        System.out.println("Вывод в консоль с помощью for");
        for (int i = 0; i < list2.size(); i++) {

        }
        System.out.print(list2 +" ");
        System.out.println();
        System.out.println();


        System.out.println("Вывод в консоль с помощью итератора");

        MyLinkedList_2.LinkedListIterator iterator = list2.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();

        System.out.println(list2.size());


    }
}
