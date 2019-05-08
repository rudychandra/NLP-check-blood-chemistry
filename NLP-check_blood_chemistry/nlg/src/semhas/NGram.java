/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semhas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class NGram {

    public static List ngrams(int n, String str) {
        List ngrams = new ArrayList();
        String[] words = str.trim().replaceAll(" +", " ").split(" ");
        
        for (int i = 0; i < words.length - n+1; i++) {
            if(words[i].equals("")){
                
            }else{
            ngrams.add(words[i]+" "+words);
            }
        }
        return ngrams;
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append((i > start ? " " : "") + words[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String kalimat = "  kejernihan urin pasien abnormal .  kejernihan urin pasien tidak normal . pasien memiliki kejernihan urin yang abnormal . pasien memiliki kejernihan urin yang tidak normal .  pasien mengalami keabnormalan pada kejernihan urin . \n" +
"";

        for (Object ngram : ngrams(2, Proses.isiKorpus)) {
            //System.out.println(ngram);
        }
   

    }
    }

