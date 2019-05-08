/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semhas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public String getContent(String namaFile) {

        BufferedReader bufferedReader = null;
        String teksDariFile = "";

        try {
            String barisTeks;
            bufferedReader = new BufferedReader(new FileReader("src//korpus/" + namaFile));
            while ((barisTeks = bufferedReader.readLine()) != null) {
                teksDariFile = teksDariFile+" " + barisTeks;
            }

        } catch (IOException e) {
            System.out.println("Gagal baca file :" + e.toString());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.out.println("Gagal Close File : " + ex.toString());
            }
        }
        return teksDariFile;
    }
    public static void main(String args[]){
       ReadFile readFile = new ReadFile();

            String isiKorpus = readFile.getContent("korpus.txt");
System.out.println(isiKorpus);
    }
}
