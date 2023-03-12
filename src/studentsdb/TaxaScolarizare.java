package studentsdb;

import java.io.*;
import java.util.*;

public class TaxaScolarizare {
    private Map<Student, Float> mapTaxe;

    public TaxaScolarizare() {
        mapTaxe = new HashMap<>();
    }

    public void adaugaStudent(Student student, float suma) {
        mapTaxe.put(student, suma);
    }

    public float getTaxe(Student student){
        return mapTaxe.get(student);
    }

    public void stergeStudent(Student student) {
        mapTaxe.remove(student);
    }

    public boolean isPaid(Student student) {
        return mapTaxe.containsKey(student) && mapTaxe.get(student) == 0.0;
    }

    public void makePayment(Student student, float suma) {
        if (mapTaxe.containsKey(student)) {
            float credit = mapTaxe.get(student);
            credit = Math.max(credit - suma, 0);
            mapTaxe.put(student, credit);
        }
    }

    /*public void saveToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        for (Student student: mapTaxe.keySet()) {
            double taxe = mapTaxe.get(student);
            writer.println(student.getNume() + " " + student.getPrenume() + "," + taxe);
        }
        writer.close();
    }*/

    public void displayTuitionInfo(String fisier) {
        try (PrintWriter writer = new PrintWriter(new File(fisier))) {
            for (Map.Entry<Student, Float> entry : this.mapTaxe.entrySet()) {
                Student student = entry.getKey();
                float taxe = entry.getValue();
                System.out.println(student.getNume() + " " + student.getPrenume() + "," + taxe);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }

    public void displayAll() {
        for (Student student : mapTaxe.keySet()) {
            float taxe = mapTaxe.get(student);
            System.out.println(student.getNume() + " " + student.getPrenume() + "," + taxe);
        }
    }
}

