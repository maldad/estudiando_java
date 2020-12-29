import javax.swing.JOptionPane;

public class Procesos {

  public Procesos() {

  }

  public static void main(String [] args) {
    int memoria, memoria_so, cantidad_procesos, memoria_restante;

    //ingreso cantidad total de memoria
    memoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de memoria a utilizar: "));

    //ingreso memoria necesaria para el so
    memoria_so = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de memoria del SO: "));

    //ingreso cantidad de procesos
    cantidad_procesos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de procesos: "));
    //clase Computadora

    //crear arreglos para almacenar mis procesos
    String nombre_procesos [] = new String[cantidad_procesos];
    int memoria_procesos [] = new int[cantidad_procesos];
    int tiempo_procesos []  = new int[cantidad_procesos];
    /*clase Proceso
     * proc1.nombre
     * proc1.memoria
     * proc1.tiempo
     * Proceso [] lista_de_procesos
     * Tail
     */

    //solución temporal para encolar procesos
    String cola_nombre_procesos [] = new String[cantidad_procesos];
    int cola_memoria_procesos [] = new int[cantidad_procesos];
    int cola_tiempo_procesos []  = new int[cantidad_procesos];

    //calcular memoria libre para trabajar
    memoria_restante = memoria - memoria_so;
    System.out.println("La memoria restante es: " + memoria_restante);

    //comienza ciclo para crear los procesos a partir de la entrada del usuario
    for(int i = 0; i < cantidad_procesos; i++) {
      String nombre_ingresado;
      int memoria_ingresada, tiempo_ingresado;

      nombre_ingresado = JOptionPane.showInputDialog("Ingrese el nombre del proceso: " + (i + 1));
      memoria_ingresada = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es la memoria requerida por el proceso " + nombre_ingresado + "?"));
      tiempo_ingresado = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es el tiempo asignado al proceso " +  nombre_ingresado + "? "));

      //condición, evaluar los datos del proceso ingresado
      //¿tengo memoria disponible?
      //si -> guardar proceso
      //no -> encolar procesos
      if(memoria_restante > memoria_ingresada) {
        //actualizar memoria libre para trabajar
        memoria_restante = memoria_restante - memoria_ingresada;
        //guardar el proceso para su ejecución
        nombre_procesos[i] = nombre_ingresado;
        memoria_procesos[i] = memoria_ingresada;
        tiempo_procesos[i] = tiempo_ingresado;
      } else {
        System.out.println("La memoria no es suficiente, el proceso se va a la cola");
        cola_nombre_procesos[i] = nombre_ingresado;
        cola_memoria_procesos[i] = memoria_ingresada;
        cola_tiempo_procesos[i] = tiempo_ingresado;
      }

      //imprimir el estado de mi memoria
      System.out.println("La memoria restante es: " + memoria_restante);
    }

    //comienzo la ejecución de mis procesos
    for(int i = 0; i < cantidad_procesos; i++) {
      if(nombre_procesos[i] == null) {
        System.out.println("El proceso ingresado es null, por lo tanto no hay algo que ejecutar");
      } else {
        System.out.println("Ejecución del proceso: " + nombre_procesos[i]);
        for(int t = tiempo_procesos[i]; t > 0; t--){
          System.out.println("Tiempo restante: " + t);
        }
        //actualizar memoria libre para trabajar una vez que termina la ejecución del proceso
        memoria_restante = memoria_restante + memoria_procesos[i];
        //imprimir el estado de mi memoria
        System.out.println("La memoria restante es: " + memoria_restante);
      }

      //preguntamos si hay algún proceso en cola
      //si su memoria es menor a la memoria que tenemos restante
      // -> lo ejecutamos
      //no
      // -> (...)
      if(cola_nombre_procesos[i] == null) {
        System.out.println("El proceso en cola es null, por lo tanto no hay algo que ejecutar");
      } else {
        if(cola_memoria_procesos[i] <= memoria_restante) {
          System.out.println("Ejecución del proceso en cola: " + cola_nombre_procesos[i]);
          for(int t = cola_tiempo_procesos[i]; t > 0; t--) {
            System.out.println("Tiempo restante: " + t);
          }
        }
      }
    }
  }
}
