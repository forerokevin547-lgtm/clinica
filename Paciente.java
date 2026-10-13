import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private HistorialMedico historial;
    private List<Cita> citas;

    public Paciente(int id, String nombre, int edad, HistorialMedico historial) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.historial = historial;
        this.citas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void addCita(Cita cita) {
        this.citas.add(cita);
    }

    // Serialización manual a JSON
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id\": ").append(id).append(",\n");
        json.append("  \"nombre\": \"").append(nombre != null ? nombre : "").append("\",\n");
        json.append("  \"edad\": ").append(edad).append(",\n");
        json.append("  \"historial\": ").append(historial != null ? historial.toJson() : "null").append("\n");
        json.append("}");
        return json.toString();
    }
}
