package semhas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadWord {

    public static ArrayList<HasilCek> arrayHasilCek = new ArrayList<>();

    private static HashMap<String, HashMap<String, String>> hmData = new HashMap<>();
    private static HashMap<String, String> hmRecord = new HashMap<>();
    private static HashMap<String, HashMap<String, HashMap<String, String>>> hmDataClean = new HashMap<>();
    private static String kategori = "";

    private static boolean kategori_status_new = false;

    private static XWPFDocument xdoc;
    static String nama;
    static String gender;

    public static ArrayList<HasilCek> read(String url) {
//        HashMap<String, HashMap<String, String>> data = getData("src//060816_MUHAMMAD_FAHRU.docx");
        HashMap<String, HashMap<String, String>> data = getData(url);
        HashMap<String, HashMap<String, String>> hmRecordClean = new HashMap<>();

        for (Map.Entry<String, HashMap<String, String>> entry : data.entrySet()) {
            String kategori = entry.getKey().toString();
            hmRecordClean = new HashMap<>();
            for (Map.Entry<String, String> entry1 : entry.getValue().entrySet()) {

                String field = entry1.getKey();
                String value = entry1.getValue().replace(",", ".");
                HashMap<String, String> hasil = data_pakar(kategori, field, value, gender);

                if (hasil.size() > 0) {
//                    System.out.println("key, " + entry1.getKey() + " value " + entry1.getValue() + " " + hasil);
                    hmRecordClean.put(field, hasil);
                }
            }
            hmDataClean.put(kategori, hmRecordClean);
        }
        System.out.println("-----------------------\nlist abnormal dan kritis");

        for (Map.Entry<String, HashMap<String, HashMap<String, String>>> entry : hmDataClean.entrySet()) {
            String kategori = entry.getKey();

            for (Map.Entry<String, HashMap<String, String>> entry1 : entry.getValue().entrySet()) {

                String field = entry1.getKey().toString();
                String hasil = hmDataClean.get(kategori).get(field).get("hasil");

                if (hasil.equals("Abnormal") || hasil.equals("Kritis")) {
//                System.out.println(kategori + " " + field);
                    System.out.println("kategori:" + kategori + " field:" + field + " hasil:" + hmDataClean.get(kategori).get(field).get("hasil") + " traction:" + hmDataClean.get(kategori).get(field).get("traction"));
//                System.out.println(hmDataClean.get(kategori).get(field).get("hasil"));

                    String traction = hmDataClean.get(kategori).get(field).get("traction");
                    String selisih = hmDataClean.get(kategori).get(field).get("selisih");
                    arrayHasilCek.add(new HasilCek(kategori, field, hasil, selisih, traction));

                }
            }
        }

        return arrayHasilCek;
    }

    public static void main(String[] args) throws IOException {

        HashMap<String, HashMap<String, String>> data = getData("src//1_050916_AGUS_SAKIRIN normal berurut.docx");
        HashMap<String, HashMap<String, String>> hmRecordClean = new HashMap<>();

        for (Map.Entry<String, HashMap<String, String>> entry : data.entrySet()) {
            String kategori = entry.getKey().toString();
            hmRecordClean = new HashMap<>();
            for (Map.Entry<String, String> entry1 : entry.getValue().entrySet()) {

                String field = entry1.getKey();
                String value = entry1.getValue().replace(",", ".");
                HashMap<String, String> hasil = data_pakar(kategori, field, value, gender);

                if (hasil.size() > 0) {
//                    System.out.println("key, " + entry1.getKey() + " value " + entry1.getValue() + " " + hasil);
                    hmRecordClean.put(field, hasil);
                }
            }
            hmDataClean.put(kategori, hmRecordClean);

        }

        //tampilkanHashmap(hmDataClean);

                tampilkanHashmap(hmDataClean);
        System.out.println("----------------------------\nAbnormal & Kritis\n---------------------------------");

        for (Map.Entry<String, HashMap<String, HashMap<String, String>>> entry : hmDataClean.entrySet()) {
            String kategori = entry.getKey();

            for (Map.Entry<String, HashMap<String, String>> entry1 : entry.getValue().entrySet()) {

                String field = entry1.getKey().toString();
                String hasil = hmDataClean.get(kategori).get(field).get("hasil");

                if (hasil.equals("Abnormal") || hasil.equals("Kritis")) {
//                System.out.println(kategori + " " + field);
                    System.out.println("kategori:" + kategori + " field:" + field + " hasil:" + hmDataClean.get(kategori).get(field).get("hasil") + " traction:" + hmDataClean.get(kategori).get(field).get("traction"));
//                System.out.println(hmDataClean.get(kategori).get(field).get("hasil"));

                    String traction = hmDataClean.get(kategori).get(field).get("traction");
                    String selisih = hmDataClean.get(kategori).get(field).get("selisih");
                    arrayHasilCek.add(new HasilCek(kategori, field, hasil, selisih, traction));

                }
            }
        }

    }

    public static HashMap<String, HashMap<String, String>> getData(String url) {
        HashMap<String, HashMap<String, String>> hmData = new HashMap<>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(url);
            xdoc = new XWPFDocument(fis);
            List<XWPFTable> tables = xdoc.getTables();
            for (XWPFTable table : tables) {
                int flagRow = 0;
                for (XWPFTableRow row : table.getRows()) {
                    int flagCell = 0;

                    String cell0 = "", cell1 = "";

                    for (XWPFTableCell cell : row.getTableCells()) {

                           System.out.println(flagRow + " " + flagCell  + " " + cell.getText());
                        if (flagRow == 1 && flagCell == 0) {
                            nama = cell.getText();
                        } else if (flagRow == 4 && flagCell == 0) {
                            gender = cell.getText();
                        }

                        if (flagRow >= 7) {
                            if (flagCell == 0) {
//                            System.out.print(cell.getText());

                                kategori_status_new = false;
                                kategori = cell.getText().trim().toLowerCase().replace(" ", "_");
                                if (kategori.equals("urinalisa")
                                        //                                        || kategori.equals("hitung_jenis")
                                        || kategori.equals("sedimen")
                                        //                                    || kategori.equals("kehalamanberikutnya......")
                                        //                                        || kategori.equals("pemeriksaan")
                                        || kategori.equals("hasil")
                                        //                                        || kategori.equals("kimia")
                                        || kategori.equals("diabetes")
                                        || kategori.equals("fungsi_hati")
                                        || kategori.equals("fungsi_ginjal")
                                        || kategori.equals("fungsi_lemak")
                                        || kategori.equals("imunologi")) {
//                                System.out.println("-----------------------------");

                                    hmRecord = new HashMap<>();

                                    kategori_status_new = true;
                                } else {
                                    cell0 = cell.getText();
                                }
                            } else if (flagCell == 1) {
                                cell1 = cell.getText();

//                            System.out.println(cell.getText());
                            }
                            flagCell++;

                            if (!cell0.trim().equals("")) { 
                                cell0 = cell0.replace(" ", "_");

                                if (!cell0.equals("ke_halaman_berikutnya......")) {
                                    hmRecord.put(cell0, cell1);

                                }
                            }
                            if (kategori_status_new) {
                                hmData.put(kategori, hmRecord);
                            }
                        }
                    }
                    flagRow++;
                }
            }
            tampilkanHashmap(hmData);
            System.out.println(nama + " " + gender);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadWord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadWord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hmData;
    }

    public static void tampilkanHashmap(HashMap map) {
        for (Object objname : map.keySet()) {
//            System.out.println();
            System.out.println(objname + ":" + map.get(objname));
        }
    }

    public static HashMap<String, HashMap<String, String>> hmDataPakar = new HashMap<>();
    public static HashMap<String, HashMap<String, String>> hmRecordPakar = new HashMap<>();

    public static String traction = "";
    public static Double selisih = 0.0;

    public static HashMap<String, String> data_pakar(String kategori, String field, final String value, String jenis_kelamin) {

        //nilai, hasil_pakar, traction, selisih
        if (kategori.equals("urinalisa")) {
            if (field.equals("Warna")) {
                if (value.toLowerCase().equals("kuning")) {

                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                        }
                    };
                }
            } else if (field.equals("Kejernihan")) {
                if (value.toLowerCase().equals("jernih")) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };

                }
            } else if (field.equals("PH")) {

                Double v = Double.parseDouble(value);
                if (v >= 5 && v <= 8) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 8) {
                        traction = "peningkatan";
                        selisih = v - 8;
                    } else if (v <= 5) {
                        traction = "penurunan";
                        selisih = 5 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };

                }
            } else if (field.equals("Leukosit")
                    || field.equals("Protein")
                    || field.equals("Glukosa")
                    || field.equals("Erytrosit")) {
                if (value.toLowerCase().equals("-")) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                }
            }
        } else if (kategori.equals("sedimen")) {
            if (field.equals("Leukosit")) {

                Double v = Double.parseDouble(value.split("-")[1]);

                if (v >= 0 && v <= 5) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                }
            } else if (field.equals("Erytrosit")) {
                Double v = Double.parseDouble(value.split("-")[1]);

                if (v >= 0 && v <= 1) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                }
            } else if (field.equals("Epitel")) {
                if (value.toLowerCase().equals("+")) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                }
            } else if (field.equals("Silinder") || field.equals("Kristal") || field.equals("Bakteri")) {
                if (value.toLowerCase().equals("-")) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                }
            }

        } else if (kategori.equals("diabetes")) {
            Double v = Double.parseDouble(value);

            if (field.equals("Glukosa_Puasa")) {
                if (v >= 70 && v <= 180) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else if (v <= 40 || v >= 450) {

                    if (v > 450) {
                        traction = "peningkatan";
                        selisih = v - 450;
                    } else if (v <= 40) {
                        traction = "penurunan";
                        selisih = 40 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Kritis");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };

                } else {

                    if (v > 180) {
                        traction = "peningkatan";
                        selisih = v - 8;
                    } else if (v <= 70) {
                        traction = "penurunan";
                        selisih = 5 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };

                }
            } else if (field.equals("Glukosa")) {

                if (v >= 75 && v <= 140) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 140) {
                        traction = "peningkatan";
                        selisih = v - 8;
                    } else if (v <= 75) {
                        traction = "penurunan";
                        selisih = 5 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };
                }
            }

//            fungsi_hati:{Bilirubin_Total=1,4, Gamma_GT=105, Alkali_Phospatase=86, Total_Protein=8,1, Albumine=4,8, SGPT=68, Globulin=3,3, SGOT=28}
        } else if (kategori.equals("fungsi_hati")) {
            Double v = Double.parseDouble(value);

            if (field.equals("Bilirubin_Total")) {
                if (v >= 0.3 && v <= 1) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else if (v >= 15) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Kritis");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 140) {
                        traction = "peningkatan";
                        selisih = v - 140;
                    } else if (v <= 75) {
                        traction = "penurunan";
                        selisih = 75 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };
                }
            }

            if (jenis_kelamin.toLowerCase().trim().equals("perempuan")) {
                if (field.equals("SGOT")) {
                    if (v <= 31) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 31) {
                            traction = "peningkatan";
                            selisih = v - 31;
                        } else if (v <= 0) {
                            traction = "penurunan";
                            selisih = 0 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                } else if (field.equals("SGPT")) {
                    if (v <= 34) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 34) {
                            traction = "peningkatan";
                            selisih = v - 34;
                        } else if (v <= 0) {
                            traction = "penurunan";
                            selisih = 0 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }
            } else {
                if (field.equals("SGOT")) {
                    if (v <= 35) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 35) {
                            traction = "peningkatan";
                            selisih = v - 35;
                        } else if (v <= 0) {
                            traction = "penurunan";
                            selisih = 0 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                } else if (field.equals("SGPT")) {
                    if (v <= 45) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 45) {
                            traction = "peningkatan";
                            selisih = v - 45;
                        } else if (v <= 0) {
                            traction = "penurunan";
                            selisih = 0 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }
            }

        } else if (kategori.equals("fungsi_ginjal")) {
            if (field.equals("Ureum")) {
                Double v = Double.parseDouble(value);
                if (v >= 10 && v <= 50) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else if (v >= 100) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Kritis");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 50) {
                        traction = "peningkatan";
                        selisih = v - 50;
                    } else if (v <= 10) {
                        traction = "penurunan";
                        selisih = 10 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };

                }
            }

            if (jenis_kelamin.toLowerCase().trim().equals("perempuan")) {
                if (field.equals("Creatinine")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 0.5 && v <= 1.1) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else if (v >= 5) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Kritis");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 1.1) {
                            traction = "peningkatan";
                            selisih = v - 1.1;
                        } else if (v <= 0.5) {
                            traction = "penurunan";
                            selisih = 0.5 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                } else if (field.equals("Asam_Urat")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 2.9 && v <= 5.2) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else if (v >= 25) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Kritis");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 5.2) {
                            traction = "peningkatan";
                            selisih = v - 5.2;
                        } else if (v < 2.9) {
                            traction = "penurunan";
                            selisih = 2.9 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }
            } else {
                if (field.equals("Creatinine")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 0.6 && v <= 1.4) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else if (v >= 5) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Kritis");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 1.4) {
                            traction = "peningkatan";
                            selisih = v - 1.4;
                        } else if (v < 0.6) {
                            traction = "penurunan";
                            selisih = 0.6 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                } else if (field.equals("Asam_Urat")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 3.5 && v <= 7.2) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else if (v >= 25) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Kritis");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 7.2) {
                            traction = "peningkatan";
                            selisih = v - 7.2;
                        } else if (v < 3.5) {
                            traction = "penurunan";
                            selisih = 3.5 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }

            }
            //fungsi_lemak:{Cholestrol_Total=210, LDL_Cholestrol=147, HDL_Cholestrol=42, Trygliserida=105}
        } else if (kategori.equals("fungsi_lemak")) {
            if (field.equals("Cholestrol_Total")) {
                Double v = Double.parseDouble(value);
                if (v <= 200) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 200) {
                        traction = "peningkatan";
                        selisih = v - 200;
                    } else if (v <= 0) {
                        traction = "penurunan";
                        selisih = 0 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };
                }
            } else if (field.equals("Trygliserida")) {
                Double v = Double.parseDouble(value);
                if (v <= 150) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 150) {
                        traction = "peningkatan";
                        selisih = v - 150;
                    } else if (v <= 0) {
                        traction = "penurunan";
                        selisih = 0 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };
                }
            } else if (field.equals("LDL_Cholestrol")) {
                Double v = Double.parseDouble(value);
                if (v <= 130) {
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Normal");
                            put("nilai", value);
                            put("traction", null);
                            put("selisih", null);
                        }
                    };
                } else {

                    if (v > 130) {
                        traction = "peningkatan";
                        selisih = v - 130;
                    } else if (v <= 0) {
                        traction = "penurunan";
                        selisih = 0 - v;
                    }
                    return new HashMap<String, String>() {
                        {
                            put("hasil", "Abnormal");
                            put("nilai", value);
                            put("traction", traction);
                            put("selisih", String.valueOf(selisih));
                        }
                    };
                }
            }

            if (jenis_kelamin.toLowerCase().trim().equals("perempuan")) {

                if (field.equals("HDL_Cholestrol")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 35 && v <= 70) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 70) {
                            traction = "peningkatan";
                            selisih = v - 70;
                        } else if (v < 35) {
                            traction = "penurunan";
                            selisih = 35 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }
            } else {
                if (field.equals("HDL_Cholestrol")) {
                    Double v = Double.parseDouble(value);
                    if (v >= 35 && v <= 55) {
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Normal");
                                put("nilai", value);
                                put("traction", null);
                                put("selisih", null);
                            }
                        };
                    } else {

                        if (v > 55) {
                            traction = "peningkatan";
                            selisih = v - 55;
                        } else if (v <= 35) {
                            traction = "penurunan";
                            selisih = 35 - v;
                        }
                        return new HashMap<String, String>() {
                            {
                                put("hasil", "Abnormal");
                                put("nilai", value);
                                put("traction", traction);
                                put("selisih", String.valueOf(selisih));
                            }
                        };
                    }
                }
            }
        }

        return new HashMap<String, String>() {
            {
            }
        };
    }
}

//selisih abnormal
//kl kritis ngga perlu 
// keyword kritis,
// abnormal ->peningkatan, dan penurunan
//
