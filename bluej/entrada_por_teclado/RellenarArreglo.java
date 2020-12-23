import javax.swing.JOptionPane;

public class RellenarArreglo
{
    
    public RellenarArreglo()
    {
      
    }
    
    public static void rellenar_arreglo(){
        String entrada = JOptionPane.showInputDialog("De que tamaño quieres tu arreglo");
        int entrada_como_entero = Integer.parseInt(entrada);
        int numeros [] = new int[entrada_como_entero];
        
        for(int i = 0; i < numeros.length; i++){
            String numero_en_turno = JOptionPane.showInputDialog("Ingrese un numero");
            numeros[i] = Integer.parseInt(numero_en_turno);
        }
        
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
