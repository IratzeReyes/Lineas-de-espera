import java.util.Scanner;
public class LineasDeEspera {
    public static void main (String[]args){
        Scanner lector = new Scanner (System.in);
        double landa; //promedio de llegadas
        double niu; //promedio de servicio
        //pedir datos 
        System.out.println("Introduce Landa (promedio de llegadas): ");
        landa = lector.nextDouble();
        System.out.println("Introduce Niu (promedio de servicio): ");
        niu = lector.nextDouble();

        System.out.println("\n \n \t \tMENU:");
        System.out.println("1. Modelo M/M/1");
        System.out.println("2. Modelo M/M/c");
        System.out.println("3. Modelo M/M/1/K: ");
        System.out.println("4. Elige la opcion que deseas: ");
        int opcion = lector.nextInt();
        switch (opcion){
            case 1:
                //modelo M/M/1 primer modelo
                //se coloca las variables para guardar los datos 
                double p; //probabilidad e encontrar ocupado
                double lq; //numero promedio de clientes esperando en la cola 
                double wq; //tiempo promedio de espera en la cola
                double w; //tiempo total en el sistema
                //CALCULAR FORMULAS
                //calcular p (utilizacion del sistema promedio)
                p= landa/niu;
                //calcular Lq (numero promedio de clientes en la cola)
                lq =  ((Math.pow(landa, 2))/(niu*(niu-landa)));
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
            case 2:
                // Modelo M/M/C
                //pedir numero de servidores
                int c; //numero de servidores
                System.out.println("Introduce el numero de servidores (c): ");
                c = lector.nextInt();
                //se coloca las variables para guardar los datos
                double a; //constante
                double pC; //utilizacion por servidor
                double po; //probabilidad de que no haya clientes en el sistema
                double pEspera; //probabilidad de que un cliente tenga que esperar
                double lqC; //Longitud promedio en cola
                double wqC; //Tiempo promedio de espera en cola
                double wC; //Tiempo total en el sistema 
                double lC; //Numero promedio en el sistema
                //CALCULAR FORMULAS 
                //Calcular a (constante)
                a = (double) landa / niu;
                //Calcular pC (utilizacion por servidor)
                pC = a / c;
                //Calcular po (probabilidad de que no haya clientes en el sistema) llamamos a la funcion recursiva
                po = calcularMMC(landa, niu, c);
                //Calcular pEspera (probabilidad de que un cliente tenga que esperar) llamamos a la funcion rexcursiva
                pEspera = calcularPEspera(landa, niu, c);
                //Calcular LqC (Longitud promedio en cola)
                lqC = (pEspera * pC) /  (1 - pC);
                //Calcular WqC (Tiempo promedio de espera en cola)
                wqC = lqC / landa;
                //Calcular WC (Tiempo total en el sistema)
                wC = wqC + (1.0 / niu);
                //Calcular lC (Numero promedio en el sistema)
                lC = landa * wC;
                //Mostrando los resultados de las formulas
                System.out.println("Resultados del modelo M/M/C:");
                System.out.println("valor de la constante (a): " + a);
                System.out.println("Utilizacion por servidor (pC): " + pC);
                System.out.println("Probabilidad de que no haya clientes en el sistema (po): " + po);
                System.out.println("Probabilidad de que un cliente tenga que esperar (pEspera): " + pEspera);
                System.out.println("Longitud promedio en cola (LqC): " + lqC);
                System.out.println("Tiempo promedio de espera en cola (WqC): " + wqC);
                System.out.println("Tiempo total en el sistema (WC): " + wC);
                System.out.println("Numero promedio en el sistema (lC): " + lC);

                break;
            case 3:
                // Modelo M/M/1/K
                // Pedir datos que nos faltan 
                int k; //probabilidad de rechazp
                double pKS; //Utiizacion del sistema 
                double poK; //Probabilidad de que no haya clientes en el sistema
                double pk; //la probabilidad de que llegues y te rechazen
                double landaE; //tasa efectiva de llegada
                double lk; //numero promedio de la cola
                double wk; //tiempo promedio en la cola
                //introsucir el dato de k 
                System.out.println("Introduce la probabilidad de rechazo (K): ");
                k = lector.nextInt();
                //CALCULAR FORMULAS
                //Calcular pKS (Utilizacion del sistema)
                pKS = (double) landa / niu;
                //Calcular poK (Probabilidad de que no haya clientes en el sistema)
                poK = (1 - pKS) / (1 - Math.pow(pKS, k + 1));
                //Calcular pk (la probabilidad de que llegues y te rechazen)
                pk = Math.pow(pKS, k) * poK;
                //Calcular landaE (tasa efectiva de llegada)
                landaE = landa * (1 - pk);
                //Calcular lk (numero promedio de la cola)
                lk = (pKS * (1 - (k+1) * Math.pow(pKS, k) + k* Math.pow(pKS, k+1))) / ((1 - pKS) * (1 - Math.pow(pKS, k +1)));
                //Calcular wk (tiempo promedio en la cola)
                wk = lk / landaE;
                //Mostrando los resultados de las formulas
                System.out.println("Resultados del modelo M/M/1/K:");
                System.out.println("Utilizacion del sistema (pKS): " + pKS);
                System.out.println("Probabilidad de que no haya clientes en el sistema (poK): " + poK);
                System.out.println("Probabilidad de que llegues y te rechazen (pk): " + pk);
                System.out.println("Tasa efectiva de llegada (landaE): " + landaE);
                System.out.println("Numero promedio de la cola (lk): " + lk);
                System.out.println("Tiempo promedio en la cola (wk): " + wk);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    //se crea una funcion para  el factorial  y para po y pEspera
    public static long factorial(int n){
        if (n <= 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static double calcularMMC(double landa, double niu, int c){
        double a = landa / niu;
        double sumatoria = 0;
        for (int n = 0; n < c; n++){
            sumatoria += Math.pow(a,n) / factorial(n);
        }
        double sumatoria2 = (Math.pow(a, c))/ (factorial(c) * (1 - (a / c)));
        double po =1.0 / (sumatoria + sumatoria2);
        return  po;

    }
    public static double calcularPEspera(double landa, double niu, int c){
        double a = landa / niu;
        double po = calcularMMC(landa, niu, c);
        double pEspera = (Math.pow(a, c) / (factorial(c) * (1.0 - (a / c) ))) * po;
        return pEspera;
    }
} 

    