public class Documento {
    
    private String id;
    private String titulo;
    private String contenido;

    public Documento(String id, String titulo, String contenido){
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }
    
    public String getContenido(){
        return contenido;
    }

    public String toString(){
        return "El titulo: " + titulo + ". El ID: " + id + ". El contenido: " + contenido + ".";
    }

}
