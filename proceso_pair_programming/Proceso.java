public class Proceso {
  String estado;
  boolean interrupcion;
  boolean espera;

  public Proceso(String estado) {
    this.estado = estado;
    this.interrupcion = false;
  }

  public String estado() {
    //getter
    //checa estas instrucciones
    //ya que iniciar_interrupcion nos devuelve:
    //"En ejecución"
    //ya no hay necesidad de preguntar si tal interrupcion existe
    // if(interrupcion){
    //   return "Listo";
    // }else{
    // }
    // sólo hay que regresar el atributo estado :D
    return estado;
  }

  public String cambiar_estado(String nuevo_estado) {
    //setter
    estado = nuevo_estado;
    return estado;
  }

  public String iniciar_interrupcion() {
    interrupcion = true;
    return "Listo";
  }

  public String finalizar_interrupcion() {
    interrupcion = false;
    return "Listo";
  }

  public String iniciar_espera() {
    espera = true;
    return "En espera";
  }

  public String finalizar_espera() {
    espera = false;
    return "Listo";
  }

  public static void main(String args []) {
    Proceso p = new Proceso("Nuevo");
    System.out.println(p.estado());

    System.out.println("Cambiando estado: " + p.estado() + " -> " + p.cambiar_estado("Listo"));

    System.out.println("Cambiando estado: " + p.estado() + " -> " + p.cambiar_estado("En ejecución"));

    System.out.println("Entra una interrupción: " + p.estado() + " -> " + p.iniciar_interrupcion());

    System.out.println("Finaliza una interrupción: " + p.finalizar_interrupcion() + " -> " + p.estado());

    System.out.println("Entra una operación E/S: " + p.estado() + " -> " + p.iniciar_espera());

    System.out.println("Finaliza una operación E/S: " + p.finalizar_espera() + " -> " + p.estado());

    System.out.println("Cambiando estado: " + p.estado() + " -> " + p.cambiar_estado("Terminado"));
  }
}
