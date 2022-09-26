package util;

/**
 *
 * @author Joao Samuel Gomes
 */
public class Formatador {
    /**
     * converte uma virgula em uma string para um ponto
     * @param pString
     * @return double
     */
    public double converteVirgulaParaPontoReturn(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ','){
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
    }
}
