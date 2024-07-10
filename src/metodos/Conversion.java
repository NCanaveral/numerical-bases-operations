package metodos;
import java.util.HashMap;
import java.util.Map;

/*
 * Este codigo trata de simular como harian las operaciones solicitados
 * un humano comun y corriente con conocimientos basicos de bases numericas
 * puedes entender cualquier metodo aqui realizado buscando un video
 * tutorial en youtube que haga cualquiera de estas operaciones
 */


public class Conversion 
{
    /*
     * este hashmap contiene las equivalencias de todos los nuemros
     * presentes en el sistema hexadecimal a binario y viceversa
     * otra implementacion puede ser transformar de binario a decimal 
     * y de decimal y de decimal a otra base pero en un entorno real 
     * se usa una tabla de equivalencia similar
     */
    final static Map<String, String> traductor = new HashMap<>();
    static
    {
        traductor.put("000", "0");
        traductor.put("001", "1");
        traductor.put("010", "2");
        traductor.put("011", "3");
        traductor.put("100", "4");
        traductor.put("101", "5");
        traductor.put("110", "6");
        traductor.put("111", "7");
        traductor.put("1000", "8");
        traductor.put("1001", "9");
        traductor.put("1010", "A");
        traductor.put("1011", "B");
        traductor.put("1100", "C");
        traductor.put("1101", "D");
        traductor.put("1110", "E");
        traductor.put("1111", "F");
        traductor.put("0", "000");
        traductor.put("1", "001");
        traductor.put("2", "010");
        traductor.put("3", "011");
        traductor.put("4", "100");
        traductor.put("5", "101");
        traductor.put("6", "110");
        traductor.put("7", "111");
        traductor.put("8", "1000");
        traductor.put("9", "1001");
        traductor.put("A", "1010");
        traductor.put("B", "1011");
        traductor.put("C", "1100");
        traductor.put("D", "1101");
        traductor.put("E", "1110");
        traductor.put("F", "1111");
        traductor.put("10", "A");
        traductor.put("11", "B");
        traductor.put("12", "C");
        traductor.put("13", "D");
        traductor.put("14", "E");
        traductor.put("15", "F");
    }

    public Conversion() {
    }

    public String FromOctorHexToBin(String N, int opcion)
    {
        /*  
        * los caracteres son numeros en codigo ASCII, 
        * https://www.dongee.com/tutoriales/content/images/2023/04/image-72.png 
        */
        String caracter;
        String Numero = "";
        int z = 0;
        for(int i=0; i < N.length(); i++)
        {
            caracter = N.substring(i, i + 1);
            if(opcion == 4 && caracter.charAt(0) < '8')
            {
                Numero = Numero + "0";
            }
            Numero = Numero + getCode(caracter);
        }
        while(Numero.charAt(z) == '0')
        {
            z++;
        }
        Numero = Numero.substring(z);
        return Numero;
    }

    public long FromNToDec(String N, int Base)
    {
        long acumulado = 0;
        long b_expo = 0;
        long aux;
        long numero;
        switch(Base)
        {
            case 1 -> b_expo = 2;
            case 2 -> b_expo = 8;
            case 4 -> b_expo = 16;
        }
        for(int i = 0; i < N.length(); i++)
        {
            aux = N.charAt(N.length() - i  - 1);
            numero = getNumber(aux);
            acumulado = (long) (acumulado + (numero * Math.pow(b_expo, i)));
        }
        return acumulado;
    }

    public String FromBintoOctorHex(String N, int opcion)
    {
        String caracter;
        String Numero = "";
        int longitud = 0;

        while(N.charAt(0) == '0')
        {
            N = N.substring(1);
        }

        switch(opcion)
        {
            case 2 -> longitud = 3;
            case 4 -> longitud = 4;
        }

        while(N.length() % longitud != 0)
        {
           N = "0".concat(N);
        }
        
        while(!"".equals(N))
        {
            if(N.length() == longitud)
            {
                caracter = N;
                N = "";
            }
            else
            {
                caracter = N.substring(0, longitud);
                N = N.substring(longitud);
            }
            Numero = Numero + getCode(caracter);
        }
        return Numero;
    }

    public String FromOcttoHexorViceversa(String N, int base, int convertir)
    {
        String aux;
        aux = FromOctorHexToBin(N, base);
        return FromBintoOctorHex(aux, convertir);
    }

    public String FromDecToN(String N, int NBase)
    {
        int aux;
        long base_div = 0;
        long Nnumero =  Long.parseLong(N);
        String parte;
        String NuevoNumero = "";
        switch(NBase)
        {
            case 1 -> base_div = 2;
            case 2 -> base_div = 8;
            case 4 -> base_div = 16;
        }
        while(Nnumero != 0)
        {
            aux = (int) ((int) Nnumero % base_div);
            Nnumero = Nnumero / base_div;
            if(aux > 9)
            {
                parte = traductor.get((String.valueOf(aux)));
            }
            else
            {
                parte = Integer.toString(aux);
            }
            NuevoNumero = NuevoNumero + parte;
        }
        StringBuilder revert = new StringBuilder(NuevoNumero);
        NuevoNumero = revert.reverse().toString();
        return NuevoNumero;        
    }

    public boolean Validacion(String N, int Base)
    {
        long code;
        long LI = 48;
        long LS = 0;
        switch(Base)
        {
            case 1 -> LS = 49;
            case 2 -> LS = 55;
            case 3 -> LS = 57;
            case 4 -> LS = 70;
        }
        for(int i = 0; i < N.length(); i++)
        {
            code = N.charAt(i);
            if(code < LI || code > LS)
            {
                return false;
            }
            if(code < 65 && code > 57)
            {
                return false;
            }
        }
        return true;
    }

    public String getCode(String OldCode)
    {
        if(OldCode.charAt(0) == '0' && OldCode.length() > 3)
        {
            OldCode = OldCode.substring(1);
        }
        return traductor.get(OldCode);
    }

    public long getNumber(long n)
    {
        if(n > 60)
        {
            n = n - 55;
        }
        else
        {
            n = n - 48;
        }
        return n;
    }
}