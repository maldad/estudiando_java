import java.util.Scanner;

public class Memoria
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner (System.in);
        int memoria, memoriaSo, numero, restante;
        boolean ingreso;

        System.out.print ("Ingrese la cantidad de memoria a utilizar: ");
        memoria= in.nextInt();
        System.out.print ("Ingrese memoria para el Sistema Operativo: ");
        memoriaSo= in.nextInt();
 
        System.out.print ("Ingrese el numero de procesos: ");
        numero= in.nextInt();
        System.out.println ();
        in.nextLine();
        
        restante = memoria - memoriaSo;
        //seria mejor calcular la memoria restante de acuerdo
        //a la memoria requerida por cada proceso
        String procesos[] = new String[numero];
        int tamaño[] = new int[numero];
        int tiempo[] = new int[numero];

        for(int i=0; i <procesos.length; i++)
        {
            System.out.print("Ingrese el nombre del proceso: ");
            procesos[i]=in.nextLine();
            do
            {
                System.out.print("¿Cual es la memoria requerida por el proceso " + 
                        procesos[i] + "? ");
                tamaño[i]=in.nextInt();
                if(tamaño[i] > restante)
                    System.out.println("El tamaño de memoria requerido es superior al tamaño disponible. Reintente.");
            }while(tamaño[i] > restante); //esta condicion nos detiene si el proceso requiere más memoria de la que tenemos en total para trabajar
            System.out.print("¿Cual es el tiempo asignado al proceso " +  procesos[i] + "? ");
            tiempo[i]=in.nextInt();
            System.out.println ();
            in.nextLine();
        }
     
        System.out.println ("La memoria asignada al SO es: " + memoriaSo);
        System.out.println ("La memoria Ssobrante para atender procesos es de " + restante);        
                
        System.out.println ();

        for(int i = 0; i < procesos.length; i++)
        {
            ingreso = false;
            do
            {
                if(tamaño[i] > restante)
                {
                    //esto nunca se ejecutó
                    System.out.println ("Se intentó ingresar el proceso: " + procesos[i] +
                            " a la memoria, pero no hay espacio suficiente.");
                    for(int j = 0; j < i; j++)
                    {
                        tiempo[j]--;
                        if(tiempo[j] == 0){ //ir disminuyendo el tiempo del proceso en curso
                            restante += tamaño[i]; //aquí liberamos la memoria utilizada por el proceso
                            //que recién terminó
                        }
                    }
                } 
                else
                {
                    restante -= tamaño[i];
                    //toma la memoria requerida por el proceso
                    //y la descuenta de la memoria que tenemos para
                    //trabajar
                    ingreso = true; //mi proceso si se encoló (está en la cola de ejecución)
                }
                System.out.println ("La memoria asignada al SO es: " + memoriaSo);
                System.out.println ("Los procesos en memoria son: ");
                for(int j = 0; j < i; j++)
                    if(tiempo[j] > 0)
                        System.out.println ("Proceso: " + procesos[j] + 
                                " Memoria: " + tamaño[j] + " Tiempo restante: " +
                                tiempo[j]);
                if(ingreso)
                    System.out.println ("Proceso: " + procesos[i] + 
                            " Memoria: " + tamaño[i] + " Tiempo restante: " +
                            tiempo[i]);
                System.out.println ("La memoria sobrante para atender procesos es de: " +
                        restante);
                System.out.println ();
            }while(!ingreso);
        }
        
        while(restante < memoria - memoriaSo) //ojo en esta operación "restante"
        {
            System.out.println ("La memoria asignada al SO es: " + memoriaSo);
            System.out.println ("Los procesos en memoria son: ");
            for(int i = 0; i < procesos.length; i++)
            {
                tiempo[i]--;
                if(tiempo[i] == 0)
                    restante += tamaño[i];
                if(tiempo[i] > 0)
                    System.out.println ("Proceso: " + procesos[i] + 
                            " Memoria: " + tamaño[i] + " Tiempo restante: " +
                            tiempo[i]);
            }
            System.out.println ("La memoria sobrante para atender procesos es de: " +
                    restante);
            System.out.println ();
        } 
    }

}