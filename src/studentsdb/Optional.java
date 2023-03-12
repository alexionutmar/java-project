package studentsdb;

import java.util.ArrayList;

public class Optional {

        private String optional;
        private final static float pret = 60;
        private ArrayList<Student> studenti;

        // constructor


    public Optional(String optional, ArrayList<Student> studenti) {
        this.optional = optional;
        this.studenti = studenti;
    }

    // getters and setters
        public String getOptional() {
            return optional;
        }

        public void setOptional(String optional) {
        this.optional = optional;
        }

        public float getPret() {
            return pret;
        }

         public ArrayList<Student> getStudenti() {
            return studenti;
        }

        public void setStudenti(ArrayList<Student> studenti) {
        this.studenti = studenti;
        }

        // adauga un student la curs
        public void adaugaStudent(Student student) {
            this.studenti.add(student);
            student.adaugaOptional(this);
        }

        // remove a student from the course
        public void stergeStudent(Student student) {
            this.studenti.remove(student);
            student.stergeOptional(this);
        }

        @Override
        public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(var valoare : studenti){
            builder.append(valoare);
            builder.append("\n");
        }
        return "Nume curs: " + this.optional + " " +
                "\nStudentii inscrisi: " + builder;
        }
}
