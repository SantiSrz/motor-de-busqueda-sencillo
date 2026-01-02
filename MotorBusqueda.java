import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotorBusqueda {
    
    private Map<String, List<Documento>> indice;

    public MotorBusqueda(){
        // El propio motor se encarga de crear su memoria, no se la pedimos al usuario
        this.indice = new HashMap<>();
    }

    public void indexar(Documento doc){
        // 1. Limpieza y normalización
        String contenido = doc.getContenido().toLowerCase();
        contenido = contenido.replace(".", "").replace(",", ""); 

        String[] palabras = contenido.split("\\s+");

        for (String palabra : palabras){
            
            if (indice.containsKey(palabra)){
                // CAMINO A: La palabra YA existe
                List<Documento> listaExistente = indice.get(palabra);
                
                // Evitamos duplicados si la palabra sale 2 veces en el mismo doc
                if(!listaExistente.contains(doc)) {
                    listaExistente.add(doc);
                }

            } else {
                // CAMINO B: Palabra NUEVA
                List<Documento> listaNueva = new ArrayList<>();
                listaNueva.add(doc);
                
                // ¡IMPORTANTE! Guardamos la nueva lista en el mapa
                indice.put(palabra, listaNueva);
            }
        }
    }
    
    // Método necesario para que el Main funcione
    public void buscar(String consulta) {
        consulta = consulta.toLowerCase(); // Convertimos a minúscula para coincidir
        
        if (indice.containsKey(consulta)) {
            List<Documento> resultados = indice.get(consulta);
            System.out.println("Resultados para '" + consulta + "':");
            for (Documento d : resultados) {
                // Imprimimos un guion y el título del documento
                System.out.println(" - " + d.getTitulo());
            }
        } else {
            System.out.println("No se encontraron resultados para: " + consulta);
        }
    }
}