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
                double p; //probabilidad e encontrar ocupado
                int lq; //numero promedio de clientes esperando en la cola 
                int wq; //tiempo promedio de espera en la cola
                int w; //tiempo total en el sistema
                //pedir datos 
                System.out.println("Introduce Landa (promedio de llegadas): ");
                landa = lector.nextInt();
                System.out.println("Introduce Niu (promedio de servicio): ");
                niu = lector.nextInt();
                //calcular formulas
                //calcular p (utilizacion del sistema promedio)
                p= landa/niu;
                //calcular Lq (numero promedio de clientes en la cola)
                lq = (int) ((Math.pow(landa, 2))/(niu*(niu-landa)));
                //calcular Wq (tiempo promedio de espera en la cola)
                wq = lq/landa;
                //calcular W (tiempo total en el sistema)
                w = wq + (1/niu);
                //Mostrando los resultados de las formulas 
                System.out.println("Resultados del modelo M/M/1:");
                System.out.println("Utilizacion del sistema promedio (p): " + p); //mostrando p
                System.out.println("Numero promedio de clientes en la cola (Lq): " + lq); //mostrando Lq
                System.out.println("Tiempo promedio de espera en la cola (Wq): " +wq); //mostrando Wq
                System.out.println("Tiempo total en el sistema (w): " +w); //mostrando w




                
                break;
            
            default:
                System.out.println("Opcion no valida");
        }
    }

} 
    