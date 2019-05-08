/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semhas;

import java.util.Arrays;
import java.util.Random;

public class RouletteWheel {

    public static void main(String args[]) {
        roulette_wheel(new double[]{0.1, 0.25, 0.40, 0.15, 0.10});
    }

    public static int roulette_wheel(double[] populasi) {

        int indexPopulasi = -1;
        Random rand = new Random();
        double[] prob = new double[populasi.length];
        double sumProb = 0;
        double sumArr = 0;
        for (int i = 0; i < populasi.length; i++) {
            sumArr += populasi[i];
        }
        for (int i = 0; i < populasi.length; i++) {
            prob[i] = (int) (populasi[i] / sumArr * 100);
        }
        double[] Roulette = new double[populasi.length];
        Roulette[0] = prob[0];
        for (int i = 1; i < populasi.length; i++) {
            sumProb += prob[i - 1];
            Roulette[i] += prob[i] + sumProb;
        }
        for (int i = 0; i < 10; i++) {
            int index = 0;
            int rRandom_int = 0;
            rRandom_int = rand.nextInt(100);
            index = Arrays.binarySearch(Roulette, rRandom_int);
            if (index < 0) {//rubah index negatif ke index populasiay.
                index = Math.abs(index + 1);
            }
            indexPopulasi = index;
        }

        return indexPopulasi;
    }

}
