package AdvancedAlgorithms;

import org.w3c.dom.ls.LSOutput;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] currency = {50, 20, 10, 5 ,2 ,1};
        int totalMoney = 923;
        greedy(currency, totalMoney);
    }

    private static void greedy(int[] currency, int totalMoney) {
        int[] sumOfEachCurrency = new int[currency.length];
        int curMoney = 0;
        int index = 0;
        while (curMoney != totalMoney) {
            if (currency[index] <= totalMoney - curMoney) {
                curMoney += currency[index];
                sumOfEachCurrency[index]++;
            } else index++;
        }
        showResult(sumOfEachCurrency, currency);
    }

    private static void showResult(int[] sumOfEachCurrency, int[] currency) {
        for (int i = 0; i < sumOfEachCurrency.length; i++) {
            if (sumOfEachCurrency[i] != 0) {
                System.out.print(sumOfEachCurrency[i] + " x ");
                System.out.println(currency[i]);
            }
        }
    }
}
