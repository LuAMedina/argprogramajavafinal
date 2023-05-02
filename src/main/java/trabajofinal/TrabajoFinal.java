package trabajofinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TrabajoFinal {
    
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    private static Conexion conexion = new Conexion();

    public static void main(String[] args) throws SQLException, JsonProcessingException {

        int opcion;

        do {
            System.out.println("Seleccione una opción:\n1- Crear materia\n2-Crear alumno\n3-Inscribirse a materia\n4-Ver datos de materias\n5- Ver datos de alumno\n6-Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    crearMateria();
                    break;
                case 2:
                    crearAlumno();
                    break;
                case 3:
                    verDatosMaterias();
                    break;
                case 4:
                    verDatosAlumno();
                    break;
                case 5:
                    inscripcionMateria();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 15);
        System.out.println("Operación finalizada");
    }

    private static void crearMateria() throws SQLException {

        Materia materia = new Materia();
        
        System.out.println("Nombre de la materia");
        String nombre = sc.next();
        materia.setNombreMateria(nombre);
        
        System.out.println("Ingrese el número de correlativas");
        int numero = sc.nextInt();
        
        System.out.println("Ingrese las materias correlativas");
        ArrayList<String> correlativas = new ArrayList<>();
        
        String input;

        for (int i = 0; i < numero; i++) {
            input = sc.next();
            correlativas.add(input);
            
            String correlativasJson = new Gson().toJson(correlativas);

        conexion.estableceConexion();
        Statement stmt = conexion.conectar.createStatement();
        stmt.executeUpdate("INSERT INTO materias_final VALUES(\"" + nombre + "\",'" + correlativasJson + "');");
        conexion.cerrarConexion();
        }
    }
    
    public static void verDatosMaterias () throws SQLException, JsonProcessingException {

        Materia materia = new Materia();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        
        HashMap<String, ArrayList<String>> hmMaterias = new HashMap<>();

        conexion.estableceConexion();
        Statement stmt = conexion.conectar.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM materias_final");

        while (rs.next()) {

            materia = new Materia(rs.getString("nombre"));

            String jsonText = objectMapper.writeValueAsString(rs.getString("correlativas"));
            ArrayList<String> nombreCorrelativas = objectMapper.readValue(jsonText, ArrayList.class);
            materia.setCorrelativas(nombreCorrelativas);
            hmMaterias.put(materia.getNombreMateria(), materia.getCorrelativas());

        }
        conexion.cerrarConexion();
        System.out.println(hmMaterias);

    }

    private static void crearAlumno() throws SQLException {

        Alumno alumno = new Alumno();
        
        System.out.println("Nombre del alumno");
        String nombre = sc.next();
        alumno.setNombreAlumno(nombre);
        
        System.out.println("Ingrese el número de legajo (5 DÍGITOS)");
        int legajo = sc.nextInt();
        alumno.setLegajo(legajo);
        
        System.out.println("Ingrese la cantidad de materias aprobadas");
        int numAprobadas = sc.nextInt();
        
        System.out.println("Ingrese las materias aprobadas");
        ArrayList<String> materiasAprobadas = new ArrayList<>();
        
        String input;

        for (int i = 0; i < numAprobadas; i++) {
            input = sc.next();
            materiasAprobadas.add(input);
            
            String aprobadasJson = new Gson().toJson(materiasAprobadas);

        conexion.estableceConexion();
        Statement stmt = conexion.conectar.createStatement();
        stmt.executeUpdate("INSERT INTO alumnos_final(nombre, legajo, materias_aprobadas) VALUES('"+nombre+"','"+legajo+"','"+aprobadasJson+"')");
        conexion.cerrarConexion();
        }
    }
    
    public static void verDatosAlumno () throws SQLException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        conexion.estableceConexion();
        Statement stmt = conexion.conectar.createStatement();
        
        System.out.println("Ingrese el número de legajo");
        int legajo = sc.nextInt();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos_final WHERE legajo=" + legajo + "");
        rs.next();
        
        Alumno alumno = new Alumno(rs.getString("nombre"), rs.getInt("legajo"));
        alumno.setMateriasAprobadas(mapper.readValue(rs.getString("materias_aprobadas"), ArrayList.class));
        System.out.println(alumno);
        conexion.cerrarConexion();

    }

    public static void inscripcionMateria() throws SQLException, JsonProcessingException {

       
    }
}
