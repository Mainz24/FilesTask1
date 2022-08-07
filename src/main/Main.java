package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main (String[] args){
        File rec = new File("rec");
        File recDrawables = new File("rec//drawables");
        File recIcons = new File("rec//icons");
        File recVectors = new File("rec//vectors");
        File savegames = new File("savegames");
        File temp = new File("temp");
        File tempFile = new File("temp//temp.txt");
        StringBuilder sb = new StringBuilder();
        rec.mkdir();
        recDrawables.mkdir();
        recIcons.mkdir();
        recVectors.mkdir();
        savegames.mkdir();
        temp.mkdir();
        try {
            tempFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sb.append("Add directory rec")
                .append(", rec//drawables")
                .append(", rec//icons")
                .append(", rec//vectors.\n")
                .append("Add directory savegames.\n")
                .append("Add directory temp")
                .append(", temp//temp.txt.");
        try {
            FileWriter writerTemp = new FileWriter(tempFile);
            writerTemp.write(String.valueOf(sb));
            writerTemp.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        tempFile.delete();
    }
}