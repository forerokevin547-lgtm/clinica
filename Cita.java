import java.util.Date;

public class Cita {
    private int id;
    private Date fecha;
    private Paciente paciente;
    private Tratamiento tratamiento;
    private String estado;

    public Cita(int id, Date fecha, Paciente paciente, Tratamiento tratamiento, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.tratamiento = tratamiento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void confirmar() {
        this.estado = "Confirmada";
    }

    public void cancelar() {
        this.estado = "Cancelada";
    }

    public void realizar() {
        this.estado = "Realizada";
    }

    // Serialización manual a JSON
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id\": ").append(id).append(",\n");
        json.append("  \"fecha\": \"").append(fecha != null ? fecha.toString() : "").append("\",\n");
        json.append("  \"estado\": \"").append(estado != null ? estado : "").append("\",\n");
        json.append("  \"pacienteId\": ").append(paciente != null ? paciente.getId() : -1).append(",\n");
        json.append("  \"tratamientoId\": ").append(tratamiento != null ? tratamiento.getId() : -1).append("\n");
        json.append("}");
        return json.toString();
    }
}
