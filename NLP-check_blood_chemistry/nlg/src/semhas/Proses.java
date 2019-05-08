/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semhas;

import static java.lang.String.valueOf;
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

    public static String isiKorpus = "Warna urin tidak normal. " +
"Warna urin  pasien abnormal. " +
"Pasien memiliki warna urin yang abnormal. " +
"Pasien memiliki warna urin yang tidak normal. " +
"Pasien mengalami keabnormalan pada warna urin. " +
"Warna urin abnormal." +
"Warna urin tidak normal. " +
"Kejernihan urin abnormal. " +
"Kejernihan urin tidak normal." +
"Pasien memiliki kejernihan urin yang abnormal." +
"Pasien memiliki kejernihan urin yang tidak normal. " +
"Pasien mengalami keabnormalan pada kejernihan urin." +
"Pasien mengalami peningkatan PH urin dari batas normal. " +
"Pasien memiliki PH urin di atas batas normal. " +
"PH urin berada di atas batas normal." +
"Pasien mengalami penurunan PH urin dari batas normal. " +
"Pasien memiliki PH urin di bawah batas normal. " +
"PH urin berada di atas batas normal." +
"Pasien memiliki urin yang abnormal karena mengandung protein. " +
"Pasien memiliki urin yang tidak normal karena mengandung protein. " +
"Urin pasien abnormal karena mengandung protein." +
"Urin pasien tidak normal karena mengandung protein." +
"Pasien memiliki kadar protein yang abnormal pada urin." +
"Pasien memiliki kadar protein yang tidak normal pada urin." +
"Kadar protein pada urin abnormal." +
"Kadar protein pada urin tidak normal." +
"Pasien memiliki urin yang abnormal karena mengandung glukosa." +
"Pasien memiliki urin yang tidak normal karena mengandung glukosa. " +
"Urin pasien abnormal karena mengandung glukosa." +
"Urin pasien tidak normal karena mengandung glukosa." +
"Pasien memiliki kadar glukosa yang abnormal pada urin." +
"Pasien memiliki kadar glukosa yang tidak normal pada urin." +
"Kadar glukosa pada urin abnormal." +
"Kadar glukosa pada urin tidak normal." +
"Pasien mengalami peningkatan kadar leukosit pada urin dari batas normal. " +
"Pasien memiliki kadar leukosit pada urin di atas batas normal. " +
"Kadar leukosit pada urin berada di atas batas normal." +
"Pasien mengalami penurunan kadar leukosit pada urin dari batas normal. " +
"Pasien memiliki kadar leukosit pada urin di bawah batas normal. " +
"Kadar leukosit pada urin berada di bawah batas normal." +
"Pasien mengalami peningkatan kadar eritrosit pada urin dari batas normal. " +
"Pasien memiliki kadar eritrosit pada urin di atas batas normal. " +
"Kadar eritrosit pada urin berada di atas batas normal." +
"Pasien mengalami penurunan kadar eritrosit pada urin dari batas normal. " +
"Pasien memiliki kadar eritrosit pada urin di bawah batas normal. " +
"Kadar eritrosit pada urin berada di bawah batas normal." +
"Pasien memiliki urin yang abnormal karena tidak mengandung epitel." +
"Pasien memiliki urin yang tidak normal karena tidak mengandung epitel. " +
"Urin pasien abnormal karena tidak mengandung epitel." +
"Urin pasien tidak normal karena tidak mengandung epitel." +
"Pasien memiliki kadar epitel yang abnormal pada urinnya." +
"Pasien memiliki kadar epitel yang tidak normal pada urinnya." +
"Kadar epitel pada urin abnormal." +
"Kadar epitel pada urin tidak normal." +
"Pasien memiliki urin yang abnormal karena mengandung silinder." +
"Pasien memiliki urin yang tidak normal karena mengandung silinder. " +
"Urin pasien abnormal karena mengandung silinder." +
"Urin pasien tidak normal karena mengandung silinder." +
"Pasien memiliki kadar silinder yang abnormal pada urinnya." +
"Pasien memiliki kadar silinder yang tidak normal pada urinnya." +
"Kadar silinder pada urin abnormal." +
"Kadar silinder pada urin tidak normal." +
"Pasien memiliki urin yang abnormal karena mengandung kristal." +
"Pasien memiliki urin yang tidak normal karena mengandung kristal. " +
"Urin pasien abnormal karena mengandung kristal." +
"Urin pasien tidak normal karena mengandung kristal." +
"Pasien memiliki kadar kristal yang abnormal pada urin." +
"Pasien memiliki kadar kristal yang tidak normal pada urin." +
"Kadar kristal pada urin abnormal." +
"Kadar kristal pada urin tidak normal." +
"Pasien memiliki urin yang abnormal karena mengandung bakteri." +
"Pasien memiliki urin yang tidak normal karena mengandung bakteri. " +
"Urin pasien abnormal karena mengandung bakteri." +
"Urin pasien tidak normal karena mengandung bakteri." +
"Pasien memiliki kadar bakteri yang abnormal pada urin." +
"Pasien memiliki kadar bakteri yang tidak normal pada urin." +
"Kadar bakteri pada urin abnormal." +
"Kadar bakteri pada urin tidak normal." +
"Jumlah glukosa puasa terindikasi mengalami peningkatan dari batas normal. " +
"Jumlah glukosa puasa terindikasi mengalami penurunan dari batas normal. " +
"Kadar glukosa puasa mengalami peningkatan dari batas normal. " +
"Terjadi peningkatan kadar glukosa puasa dari batas normal. " +
"Terjadi penurunan kadar glukosa puasa dari batas normal. " +
"Kadar glukosa puasa mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar glukosa puasa di atas batas normal. " +
"Pasien memiliki kadar glukosa puasa di bawah batas normal. " +
"Glukosa puasa berada di atas batas normal." +
"Glukosa puasa berada di bawah batas normal." +
"Glukosa puasa abnormal meningkat." +
"Glukosa puasa abnormal menurun." +
"Kadar SGOT mengalami peningkatan dari batas normal. " +
"Kadar SGOT mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar SGOT di atas batas normal. " +
"Pasien memiliki kadar SGOT di bawah batas normal. " +
"Kadar SGOT berada di atas batas normal." +
"Kadar SGOT berada di bawah batas normal." +
"Kadar SGPT mengalami peningkatan dari batas normal. " +
"Kadar SGPT mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar SGOT di atas batas normal. " +
"Pasien memiliki kadar SGOT di bawah batas normal. " +
"Kadar SGPT berada di atas batas normal." +
"Kadar SGPT berada di bawah batas normal." +
"Kadar ureum pasien mengalami peningkatan dari batas normal. " +
"Kadar ureum pasien mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar ureum di atas batas normal. " +
"Pasien memiliki kadar ureum di bawah batas normal. " +
"Kadar ureum berada di atas batas normal." +
"Kadar ureum berada di bawah batas normal. " +
"Kadar kreatinin mengalami peningkatan dari batas normal. " +
"Kadar kreatinin mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar kreatinin di atas batas normal. " +
"Pasien memiliki kadar kreatinin di bawah batas normal. " +
"Kadar kreatinin berada di atas batas normal." +
"Kadar kreatinin berada di bawah batas normal. " +
"Kadar asam urat mengalami peningkatan dari batas normal. " +
"Kadar asam urat mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar asam urat di atas batas normal. " +
"Pasien memiliki kadar asam urat di bawah batas normal. " +
"Kadar asam urat berada di atas batas normal." +
"Kadar asam urat berada di bawah batas normal. " +
"Kadar kolesterol total mengalami peningkatan dari batas normal. " +
"Kadar kolesterol total mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar kolesterol total di atas batas normal. " +
"Pasien memiliki kadar kolesterol total di bawah batas normal. " +
"Kadar kolesterol total berada di atas batas normal." +
"Kadar kolesterol total berada di bawah batas normal. " +
"Kadar HDL mengalami peningkatan dari batas normal. " +
"Kadar HDL mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar HDL di atas batas normal. " +
"Pasien memiliki kadar HDL di bawah batas normal. " +
"Kadar HDL berada di atas batas normal." +
"Kadar HDL berada di bawah batas normal." +
"Kadar LDL mengalami peningkatan dari batas normal. " +
"Kadar LDL mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar LDL di atas batas normal. " +
"Pasien memiliki kadar LDL di bawah batas normal. " +
"Kadar LDL berada di atas batas normal." +
"Kadar LDL berada di bawah batas normal." +
"Kadar trigliserida mengalami peningkatan dari batas normal. " +
"Kadar trigliserida mengalami penurunan dari batas normal. " +
"Pasien memiliki kadar trigliserida di atas batas normal. " +
"Pasien memiliki kadar trigliserida di bawah batas normal." +
"Kadar trigliserida berada di atas batas normal." +
"Kadar trigliserida berada di bawah batas normal." +
"";
    String klmt="";
    String klmt1="";
    
    public static void main(String[] args) {
//        tampilkanHashmap(bgramMax);

        Proses p = new Proses();
        p.proses(isiKorpus, "glukosa puasa", "peningkatan".toLowerCase());
        

    }

    public void setKLMT(String klmt){
        this.klmt1=klmt;
    }
    public String proses(String isiKorpus, String field, String traction) {

        System.out.println("Korpus : " + isiKorpus);
        ReadFile readFile = new ReadFile();
        String stopWord = readFile.getContent("stop_word.txt");
        System.out.println("Stop Word : " + stopWord);
        String[] lsw = stopWord.toLowerCase().split(" ");
        ArrayList<String> listStopWord = new ArrayList<>(Arrays.asList(lsw));

        ArrayList< String> arrayListKalimat = splitKalimat(isiKorpus);
        String fullteks = "";
        for (int i = 0; i < arrayListKalimat.size(); i++) {
                 if (arrayListKalimat.get(i).contains(field)) {
                     if(arrayListKalimat.get(i).contains(traction)||arrayListKalimat.get(i).contains("abnormal")||arrayListKalimat.get(i).contains("tidak normal")){
                    fullteks += arrayListKalimat.get(i) + " . ";
                }}
                 System.out.println(arrayListKalimat.get(i));
                 //System.out.println(field);
                 
            
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
                klmt+=" "+kataAsal;
                System.out.print(kataAsal + " ");
                kataAsal = bgMax.get(kataAsal);
            }
        } while (status);
        //System.out.println(hasil);
        klmt+=".";
                
        return hasil;
    }
    public String getKlmt(){
        return this.klmt;
    }
    public String Klmt(){
        return this.klmt;
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
        //System.out.println(fullteks);
        System.out.println("----------------------\nProbabilitas Bigram :");
        for (Object ngram : ngrams(2, fullteks)) {
            hmProb = new HashMap<>();
           //System.out.println(ngram);

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

    public ArrayList<String> splitKalimat(String isiKorpus) {

        String[] t = isiKorpus.replace(". ", ".").split("\\.");
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
