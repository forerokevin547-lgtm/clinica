import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinica {
    private int id;
    private String nombre;
    private List<Paciente> pacientes;
    private List<Cita> citas;

    public Clinica(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void addPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public void registrarCita(Cita cita) {
        this.citas.add(cita);
        if (cita.getPaciente() != null) {
            cita.getPaciente().addCita(cita);
        }
    }

    public Paciente getPaciente(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Guardar datos en formato JSON manualmente usando java.io
    public void guardarEnJson(String rutaArchivo) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"clinicaId\": ").append(id).append(",\n");
        json.append("  \"nombre\": \"").append(nombre).append("\",\n");
        json.append("  \"pacientes\": [\n");
        for (int i = 0; i < pacientes.size(); i++) {
            json.append(pacientes.get(i).toJson());
            if (i < pacientes.size() - 1) json.append(",");
            json.append("\n");
        }
        json.append("  ]\n");
        json.append("}");

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write(json.toString());
            System.out.println("Datos guardados con éxito en " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    // Cargar/Leer archivo usando Scanner de java.util
    public static String leerArchivo(String rutaArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            while (scanner.hasNextLine()) {
                contenido.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }

    public static void main(String[] args) {
        // Inicialización de datos
        Clinica clinica = new Clinica(1, "Clínica Odontológica Central");

        HistorialMedico historial1 = new HistorialMedico(101, "Sin alergias declaradas.");
        historial1.addEntrada("Revisión inicial completada.");

        Paciente paciente1 = new Paciente(1, "Carlos Pérez", 30, historial1);
        clinica.addPaciente(paciente1);

        Tratamiento tratamiento1 = new Tratamiento(201, "Limpieza Dental", 50.0);

        Cita cita1 = new Cita(301, new java.util.Date(), paciente1, tratamiento1, "Pendiente");
        clinica.registrarCita(cita1);

        // Guardado manual en JSON (sin librerías externas)
        String archivo = "clinica_datos.json";
        clinica.guardarEnJson(archivo);

        // Lectura usando Scanner
        System.out.println("\n--- Contenido leído desde el archivo JSON ---");
        String textoGuardado = Clinica.leerArchivo(archivo);
        System.out.println(textoGuardado);
    }
}
