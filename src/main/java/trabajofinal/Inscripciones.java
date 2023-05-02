package trabajofinal;

import java.util.Date;

public class Inscripciones {
    
    Materia materia;
    Alumno alumno;
    Date fecha = new Date();

    public Inscripciones() {
    }

    public Inscripciones(Materia materia, Alumno alumno) {
        this.materia = materia;
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "materia=" + materia + ", alumno=" + alumno + ", fecha=" + fecha + '}';
    }
}
