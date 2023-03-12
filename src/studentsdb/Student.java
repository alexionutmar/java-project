package studentsdb;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
         private String nume;
         private String prenume;
         private int anul;
         private String idStudent;
         private float credit = 0;
         private static int id = 1000;
         private ArrayList<Optional> optionale;

        // constructor

        public Student(){
            Scanner in = new Scanner(System.in);
            System.out.print("Introduceti numele: ");
            this.nume = in.nextLine();

            System.out.print("Introduceti prenumele: ");
            this.prenume = in.nextLine();

            System.out.print("Introduceti anul universitar: ");
            this.anul = in.nextInt();

            setIdStudent();
        }

        public Student(String nume, String prenume, int anul, String idStudent, float credit, ArrayList<Optional> optionale) {
            this.nume = nume;
            this.prenume = prenume;
            this.anul = anul;
            this.idStudent = idStudent;
            this.credit = credit;
            this.optionale = optionale;
        }

        // getters and setters
        public String getNume() {
        return nume;
        }

        public void setNume(String nume) {
        this.nume = nume;
        }

        public String getPrenume() {
        return prenume;
        }

        public void setPrenume(String prenume) {
        this.prenume = prenume;
        }

        public int getAnul() {
        return anul;
        }

        public void setAnul(int anul) {
        this.anul = anul;
        }

        public String getIdStudent() {
        return idStudent;
        }

        public void setIdStudent() {
        //se genereaza automat anul + id normal
        id++;
        this.idStudent =  this.anul + "" + id;
        }

        public float getCredit() {
        return credit;
        }

        public void setCredit(float credit) {
        this.credit = credit;
        }

        public ArrayList<Optional> getOptionale() {
        return optionale;
        }

        public void setOptionale(ArrayList<Optional> optionale) {
        this.optionale = optionale;
        }

        public static int getId() {
        return id;
        }

        // add a course to student's courses
        public void adaugaOptional(Optional optional) {
            this.optionale.add(optional);
            this.credit += optional.getPret();
        }

        // remove a course from student's courses
        public void stergeOptional(Optional optional) {
            this.optionale.remove(optional);
            this.credit -= optional.getPret();
        }

    public void infoCredit(){
        System.out.println("Creditul din contul de student: " + this.credit + " lei");
    }

    public void plataCredit(){
        infoCredit();
        System.out.println("Introduceti suma pe care doiti sa  o achitati: ");
        Scanner in = new Scanner(System.in);
        float plata = in.nextFloat();
        this.credit -= plata;
        System.out.println("S-a efectuat plata in contul de student cu suma de: " + plata + " lei");
        infoCredit();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(var valoare : optionale){
            builder.append(valoare);
            builder.append("\n");
        }
        return "Name: " + " " + nume + " " + "Prenume: " + prenume +
                "\nAnul universitar: " + anul +
                "\nId student: " + idStudent +
                "\nCredit: " + credit + " lei" +
                "\nOptionale: " + builder;
    }

}