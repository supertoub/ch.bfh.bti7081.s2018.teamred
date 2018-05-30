package com.company;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
	Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        if (n == 1) {
            System.out.println("Pizza");
        }
            else if (n == 2) {
                System.out.println("Migros");
            }
            else if (n == 3){
            System.out.println("Döner");
        }
        else if (n == 4){
            System.out.println("Cordon-Bleu");
        }
        else if (n == 5){
            System.out.println("Libanes");
        }
        else if (n == 6){
            System.out.println("Bier");
        }
    }
}
