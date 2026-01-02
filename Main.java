import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        MotorBusqueda motor = new MotorBusqueda();

        Documento doc1 = new Documento("001", "Aprende Java", "Java es un lenguaje de programacion robusto y tipado");
        Documento doc2 = new Documento("002", "Tutorial Python", "Python es un lenguaje de programacion dinamico y sencillo");
        Documento doc3 = new Documento("003", "Receta Tortilla", "La tortilla de patatas es un plato tipico muy rico");
        Documento doc4 = new Documento("004", "Historia de Java", "Java fue creado por Sun Microsystems y es muy popular");

        System.out.println("--- INICIANDO INDEXACION ---");
        
        // 3. FASE DE INGESTA: Metemos los documentos en el motor
        motor.indexar(doc1);
        motor.indexar(doc2);
        motor.indexar(doc3);
        motor.indexar(doc4);

        // 4. FASE DE BÚSQUEDA (Interacción con usuario)
        Scanner entrada = new Scanner(System.in);
        boolean buscando = true;

        while(buscando) {
            System.out.print("\nIntroduce una palabra para buscar (o 'salir'): ");
            String consulta = entrada.nextLine();

            if (consulta.equalsIgnoreCase("salir")) {
                buscando = false;
                System.out.println("Apagando motor...");
            } else {
                // Aquí llamamos a la función buscar que añadimos antes
                motor.buscar(consulta);
            }
        }
        entrada.close();
    }
}