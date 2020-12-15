public class Arreglo
{   
    //tipo_de_dato [] nombre_variable = new tipo_de_dato [longitud_de_arreglo]
    int [] numeros = new int [10];
    public Arreglo()
    {
        numeros[0] = 100;
        numeros[1] = 25;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;
        numeros[5] = 6;
        numeros[6] = 10;
        numeros[7] = 8;
        numeros[8] = 9;
        numeros[9] = 1;
    }
    
    public int minimo() {
        System.out.println(numeros.length);
        int min = numeros[0];
        for(int i = 0; i < numeros.length; i = i + 1){
            if(numeros[i] < min){
                min = numeros[i];
            }
        }
        return min;
    }
    
    public static void main(String [] args){
        Arreglo a = new Arreglo();       
        System.out.println(a.minimo());

    }
    /*
     * TODO
     * - [ ] Diferencia entre while/for/do while
     * - [ ] Entrada de parámetros desde el teclado
     * - [ ] Condición else
     * - [ ] Filtrar pares e impares de un arreglo de números
     */
}

