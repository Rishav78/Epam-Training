package org.example;

import org.example.Chocolates.Chocolate;
import org.example.Chocolates.ChocolateOne;
import org.example.Chocolates.ChocolateTwo;
import org.example.Chocolates.ChocolateThree;
import org.example.Gifts.Gift;
import org.example.OtherSweets.Sweet;
import org.example.OtherSweets.SweetOne;
import org.example.OtherSweets.SweetTwo;
import org.example.OtherSweets.SweetThree;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Loading Predefined Chocolate Data");
        Chocolate c1 = new ChocolateOne("ChocolateOne",50,30);
        Chocolate c2 = new ChocolateTwo("ChocolateTwo",70,30);
        Chocolate c3 = new ChocolateThree("ChocolateThree",170,60);

        System.out.println("Loading Predefined Sweet Data");
        Sweet s1=new SweetOne("SweetOne",200,300);
        Sweet s2=new SweetTwo("SweetTwo",300,200);
        Sweet s3=new SweetThree("SweetThree",180,100);

        System.out.println("Gift being created by Chocolate & Sweet");
        Gift gift=new Gift();
        gift.addChocolates(c1,c2,c3);
        gift.addSweets(s1,s2,s3);

        System.out.println("Sorting items in Gift according to price");
        gift.sort();

        System.out.println("Total Weight of Gifts : "+gift.findTotalWeight());

        System.out.println("Enter '1' to get all Chocolates : ");
        System.out.println("Enter '2' to get all Sweets : ");
        System.out.println("Enter '3' to get most expensive Chocolate and Sweet : ");
        System.out.println("Enter '4' to get least expensive Chocolate and Sweet : ");
        choice=sc.nextInt();

        if(choice == 1){
            ArrayList<Chocolate> arrayList=gift.getChocolates();
            for (Chocolate c:arrayList) {
                System.out.println(c.toString());
            }
        }
        else if(choice == 2){
            ArrayList<Sweet> arrayList=gift.getSweets();
            for (Sweet s:arrayList){
                System.out.println(s.toString());
            }
        }
        else if(choice == 3){
            System.out.println("Most Expensive Chocolate : "+mostExpensive(gift.getChocolates()));
            System.out.println("Most Expensive Sweet : "+mostExpensive(gift.getSweets()));
        }
        else if(choice == 4){
            System.out.println("Least Expensive Chocolate : "+leastExpensive(gift.getChocolates()));
            System.out.println("Least Expensive Sweet : "+leastExpensive(gift.getSweets()));
        }
    }

    private static <T> String mostExpensive(ArrayList<T> arrayList){
        return arrayList.get(0).toString();
    }

    private static <T> String leastExpensive(ArrayList<T> arrayList){
        return arrayList.get(arrayList.size()-1).toString();
    }
}
