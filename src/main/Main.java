package main;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main (String[] args) {
        String saveOne = "savegames//saveOne.dat";
        String saveTwo = "savegames//saveTwo.dat";
        String saveTree = "savegames//saveTree.dat";

        String zipOne = "savegames//saveOne.zip";
        String zipTwo = "savegames//saveTwo.zip";
        String zipTree = "savegames//saveTree.zip";

        var gpOne = new GameProgress(90, 3, 41, 12.3);
        var gpTwo = new GameProgress(68, 1, 73, 10.1);
        var gpTree = new GameProgress(44, 2, 50, 9.8);

        try {
            saveGame(saveOne, gpOne);
            saveGame(saveTwo, gpTwo);
            saveGame(saveTree, gpTree);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        zipFiles(zipOne, saveOne);
        zipFiles(zipTwo, saveTwo);
        zipFiles(zipTree, saveTree);

        File fileOne = new File(saveOne);
        File fileTwo = new File(saveTwo);
        File fileTree = new File(saveTree);

        fileOne.delete();
        fileTwo.delete();
        fileTree.delete();
    }

    public static void saveGame(String save, GameProgress obj) throws IOException {
        var fos = new FileOutputStream(save);
        var oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
    }

    public static void zipFiles(String zipSave, String save) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipSave));
             FileInputStream fis = new FileInputStream(save)) {
            ZipEntry ze = new ZipEntry(save);
            zos.putNextEntry(ze);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zos.write(buffer);
            zos.closeEntry();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}