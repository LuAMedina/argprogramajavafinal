package trabajofinal;

import java.util.ArrayList;

public class Materia {
    
    String nombreMateria;
    ArrayList<String> correlativas = new ArrayList<>();

    public Materia() {
    }

    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public ArrayList<String> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<String> correlativas) {
        this.correlativas = correlativas;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombreMateria=" + nombreMateria + ", correlativas=" + correlativas + '}';
    }
}
