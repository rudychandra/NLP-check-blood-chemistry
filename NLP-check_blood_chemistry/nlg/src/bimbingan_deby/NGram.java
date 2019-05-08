/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimbingan_deby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NGram {

    public static List ngrams(int n, String str) {
        List ngrams = new ArrayList();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - n + 1; i++) {
            ngrams.add(concat(words, i, i + n));
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

        String kalimat = "belajar komputer dengan senang hati";

        for (Object ngram : ngrams(2, kalimat)) {
            System.out.println(ngram);
        }
    }
}
