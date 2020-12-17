import java.util.Scanner;

public class PedirPorScanner
{
    public PedirPorScanner()
    {
        
    }
    
    public String pedir_numero(){
        //NombreClase nombre_objeto = new NombreClase(args...)
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese un numero y presione ENTER");
        String numero_ingresado = lector.nextLine();
        return numero_ingresado;
    }
    
    public static int pedir_otro_numero(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese un numero y presione ENTER");
        int numero_ingresado = lector.nextInt();
        return numero_ingresado;
    }
    
    /*4 tipos de métodos en JAVA
     * static -> Métodos de clase
     *      void -> no nos devuelve un valor
     *      Tipo -> nos devuelve ese Tipo (return)
     * no static -> Métodos de objeto
     *      void -> no nos devuelve un valor
     *      Tipo -> nos devuelve ese Tipo (return)
     *TODO
     * - [ ] Métodos void
     * - [ ] JOptionPane -> "100"
    */
}
