package com.company;

import java.util.Scanner;

public class Main {
    /* String a="I addd mesh";
           System.out.println(a.contains("i"));*/
    public static void main(String[] args) {
        // write your code here
        String serachString;
        Book[] books = new Book[2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String author = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            books[i] = new Book(id, title, author, price);
        }
        serachString = sc.nextLine();
        Book[] result = searchTitle(books, serachString);
        if (result == null) {
            System.out.println("NO match is occurred");
        } else {
            for (Book b :
                    result) {
                System.out.println(b.id + " ");
            }
        }
    }

    private static Book[] searchTitle(Book[] books, String serachString) {
        int counter = 0;
        for(int i=0;i<books.length;i++){
            if(books[i].getTitle().contains(serachString))
            {
                counter++;
            }
        }
        Book[] selection = new Book[counter];
        int bookCounter=0;
        for(int i=0;i<books.length;i++){
            if(books[i].getTitle().contains(serachString))
            {
                selection[bookCounter]=books[i];
                bookCounter++;
            }
        }

        return bubbleSort(selection) ;
    }
    private static Book[] bubbleSort(Book[] result) {
        Book[] temp = new Book[result.length];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 1; j < result.length - i; j++) {
                if (result[j - 1].getId() > result[j].getId()) {
                    //swap Documents objects (fundamental things)
                    //we can not swap any attributes of any objects so we need to swap the Document objects
                    temp[index] = result[j - 1];
                    result[j - 1] = result[j];
                    result[j] = temp[index];
                }
            }
        }

        return result;
    }
}
