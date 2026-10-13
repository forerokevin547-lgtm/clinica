import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private int id;
    private List<String> entradas;
    private String notas;

    public HistorialMedico(int id, String notas) {
        this.id = id;
        this.notas = notas;
        this.entradas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<String> entradas) {
        this.entradas = entradas;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void addEntrada(String entrada) {
        this.entradas.add(entrada);
    }

    public String getUltimaNota() {
        if (entradas.isEmpty()) {
            return notas;
        }
        return entradas.get(entradas.size() - 1);
    }

    // Método para serializar a JSON manualmente
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id\": ").append(id).append(",\n");
        json.append("  \"notas\": \"").append(notas != null ? notas : "").append("\",\n");
        json.append("  \"entradas\": [");
        for (int i = 0; i < entradas.size(); i++) {
            json.append("\"").append(entradas.get(i)).append("\"");
            if (i < entradas.size() - 1) {
                json.append(", ");
            }
        }
        json.append("]\n");
        json.append("}");
        return json.toString();
    }
}
