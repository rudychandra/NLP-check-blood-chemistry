/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimbingan_deby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;


public class Proses {

    public static String isiKorpus = "Kreatinin pasien mengalami peningkatan signifikan dari batas normal. Kreatinin pasien mengalami peningkatan dari batas normal. Kreatinin pasien mengalami penurunan dari batas normal. Konsentrasi kreatinin serum menurun akibat distropi otot, atropi, malnutrisi atau penurunan masa otot akibat penuaan.";

    public static void main(String[] args) {
//        tampilkanHashmap(bgramMax);

        Proses p = new Proses();
        p.proses(isiKorpus, "Kreatinin", "peningkatan");

    }

    public String proses(String korpus, String field, String traction) {

        System.out.println("Korpus : " + korpus);
        ReadFile readFile = new ReadFile();
        String stopWord = readFile.getContent("stop_word.txt");
        System.out.println("Stop Word : " + stopWord);
        String[] lsw = stopWord.toLowerCase().split(" ");
        ArrayList<String> listStopWord = new ArrayList<>(Arrays.asList(lsw));

        ArrayList< String> arrayListKalimat = splitKalimat(korpus);
        String fullteks = "";
        for (int i = 0; i < arrayListKalimat.size(); i++) {
            if (arrayListKalimat.get(i).contains(field) && arrayListKalimat.get(i).contains(traction)) {
                fullteks += arrayListKalimat.get(i) + " . ";
            }
        }

        System.out.println("------------------------------\nKalimat yang dipilih dari corpus : \n" + fullteks);

        HashMap<String, Integer> hmTotalKey = new HashMap<>();
        //hitung kata terbanyak
        String k[] = fullteks.split(" ");

        for (int i = 0; i < k.length; i++) {
            if (hmTotalKey.containsKey(k[i])) {
                hmTotalKey.put(k[i], hmTotalKey.get(k[i]) + 1);

            } else {
                hmTotalKey.put(k[i], 1);
            }
        }

        ArrayList<String> listKeyword = new ArrayList<>();
        ArrayList<Integer> listBobot = new ArrayList<>();

        for (Entry<String, Integer> entry : hmTotalKey.entrySet()) {  // Itrate through hashmap

            if (!listStopWord.contains(entry.getKey().trim().toLowerCase()) && !entry.getKey().trim().equals(".")) {
                listKeyword.add(entry.getKey());
                listBobot.add(entry.getValue());
            }
        }

        System.out.println("--------------------------\nKeyword: " + Arrays.toString(listKeyword.toArray())
                + "  \nbobot:" + Arrays.toString(listBobot.toArray()));
        double[] fitnes = fitness(listBobot);

        int indexRoulette = roulette_wheel(fitnes);
        String kata_awal = listKeyword.get(indexRoulette);

        System.out.println("---------------------\nIndex Roulette :" + indexRoulette + " keyword awal :" + kata_awal);

//        System.out.println(Arrays.toString(listKeyword.toArray()) + kata_awal);
        HashMap<String, String> bgramMax = bigram_prob(fullteks);

        return generate_text(bgramMax, kata_awal);

//        tampilkanHashmap(bgramMax);
    }

    public String generate_text(HashMap<String, String> bgMax, String kataAsal) {
        String hasil = "";
        boolean status = true;

        System.out.println("----------\nHasil Generate\n-------------------------:");
        do {
            if (kataAsal.equals(".")) {
                status = false;
            } else {
                hasil += kataAsal;
                System.out.print(kataAsal + " ");
                kataAsal = bgMax.get(kataAsal);
            }
        } while (status);

        return hasil;
    }

    public HashMap<String, String> bigram_prob(String fullteks) {

        HashMap<String, String> bgramMax = new HashMap<>();

        String t[] = fullteks.split(" ");

        ArrayList<String> listWord = new ArrayList<>(Arrays.asList(t));
        listWord.remove("");
//        System.out.println(Arrays.toString(listWord.toArray()));
        Set<String> hs = new HashSet<>();
        hs.addAll(listWord);
        listWord.clear();
        listWord.addAll(hs);
//        System.out.println(Arrays.toString(listWord.toArray()));

        HashMap<String, Integer> hmProb = new HashMap<>();

        System.out.println("----------------------\nProbabilitas Bigram :");
        for (Object ngram : ngrams(2, fullteks)) {
            hmProb = new HashMap<>();
//            System.out.println(ngram);
            String kata[] = ngram.toString().split(" ");

            String k1 = kata[0];
            String k2 = kata[1];
            System.out.print("Kata : " + k1 + " ->");
            for (Object ngram1 : ngrams(2, fullteks)) {
//                System.out.println(ngram1);
                String kata1[] = ngram1.toString().split(" ");

                if (kata1[0].equals(k1)) {
                    System.out.print(" " + kata1[1]);

                    if (hmProb.containsKey(kata1[1])) {
                        hmProb.put(kata1[1], hmProb.get(kata1[1]) + 1);
                    } else {
                        hmProb.put(kata1[1], 1);

                    }
                }
            }

            //ambil probabilitas tertinggi
            String key = Collections.max(hmProb.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.print(" ->" + key);
//            tampilkanHashmap(hmProb);
            System.out.println();
            bgramMax.put(k1, key);
        }

        return bgramMax;

    }

    /*hitung jumlah keyword dan bagi dan bagikan sesuai dengan jumlah item
    
        total = 3
        ---------
        keyword1 = 2
        keyword2=1
    ---------
    maka fitnes= 
        fitnes keyword1 = 2/3
        fitnes keyword2 = 1/3
     */
    public double[] fitness(ArrayList<Integer> list) {

        ArrayList<Double> listFitness = new ArrayList<>();

        int maxValueInMap = (Collections.max(list));
//        System.out.println("Max : " + maxValueInMap);
        int sumBobot = list.stream().mapToInt(Integer::intValue).sum();
//        System.out.println("sum bobot : " + sumBobot);

        for (int i = 0; i < list.size(); i++) {
            listFitness.add(list.get(i) / (double) sumBobot);
        }

        System.out.println("-------------\nFitness");
        System.out.println(Arrays.toString(listFitness.toArray()));

        return listFitness.stream().mapToDouble(d -> d).toArray();
    }

    public int roulette_wheel(double[] populasi) {

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

        if (indexPopulasi > populasi.length - 1) {
            indexPopulasi = 0;
        }

        return indexPopulasi;
    }

    public void tampilkanHashmap(HashMap map) {
        for (Object objname : map.keySet()) {
//            System.out.println();
            System.out.println(objname + ":" + map.get(objname));
        }
    }

    public ArrayList<String> splitKalimat(String korpus) {

        String[] t = korpus.replace(". ", ".").split("\\.");
        return new ArrayList<>(Arrays.asList(t));

    }

    public ArrayList<String> ngrams(int n, String str) {
        ArrayList<String> ngrams = new ArrayList();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - n + 1; i++) {
            ngrams.add(i, concat(words, i, i + n));
        }
        return ngrams;
    }

    public String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append((i > start ? " " : "") + words[i]);
        }
        return sb.toString();
    }

}
