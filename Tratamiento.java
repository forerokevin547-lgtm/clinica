public class Tratamiento {
    private int id;
    private String descripcion;
    private double costo;

    public Tratamiento(int id, String descripcion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double calcularDescuento(double porcentaje) {
        return costo - (costo * (porcentaje / 100.0));
    }

    // Serialización manual a JSON
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id\": ").append(id).append(",\n");
        json.append("  \"descripcion\": \"").append(descripcion != null ? descripcion : "").append("\",\n");
        json.append("  \"costo\": ").append(costo).append("\n");
        json.append("}");
        return json.toString();
    }
}
