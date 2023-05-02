package trabajofinal;

import java.util.ArrayList;

public class Alumno {
    
    String nombreAlumno;
    int legajo;
    ArrayList<String> materiasAprobadas = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombreAlumno, int legajo) {
        this.nombreAlumno = nombreAlumno;
        this.legajo = legajo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public ArrayList<String> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(ArrayList<String> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombreAlumno=" + nombreAlumno + ", legajo=" + legajo + ", materiasAprobadas=" + materiasAprobadas + '}';
    }
}
