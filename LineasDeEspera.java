import java.util.Scanner;
public class LineasDeEspera {
    public static void main (String[]args){
        Scanner lector = new Scanner (System.in);
        System.out.println("\n \n \t \tMENU:");
        System.out.println("1. Modelo M/M/1");
        System.out.println("2. Modelo M/M/c");
        System.out.println("3. Modelo M/M/1/K: ");
        System.out.println("4. Elige la opcion que deseas: ");
        int opcion = lector.nextInt();
        switch (opcion){
            case 1:
                //modelo M/M/1 primer modelo
                //se pide primero los datos landa y Niu
                int landa; //promedio de llegadas
                int niu; //promedio de servicio
                int p; //probabilidad e encontrar ocupado
                int lq; //numero promedio de clientes esperando en la cola 
                int wq; //tiempo promedio de espera en la cola
                int w; //tiempo total en el sistema


                
                break;
            
            default:
                System.out.println("Opcion no valida");
        }
    }

} 
    