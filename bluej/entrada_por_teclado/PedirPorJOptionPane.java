// * <- wildcard (comodín)
import javax.swing.JOptionPane;

public class PedirPorJOptionPane
{
    public PedirPorJOptionPane()
    {
      
    }
    
    public static void pedir_por_joptionpane(){
        String entrada = JOptionPane.showInputDialog("Tamaño del arreglo:");
        System.out.println(entrada);
        int entrada_como_entero = Integer.parseInt(entrada);
        int numeros [] = new int[entrada_como_entero];
        System.out.println(entrada);
    }
    
    /*
     * TODO:
     * - [ ] Rellenar el arreglo con números que nos de el usuario
     */
}
