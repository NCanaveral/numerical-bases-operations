package metodos;
public class Operacion 
{
   static Conversion conver = new Conversion();
   public String SumaN(String N, String N2, int Base)
   {
       long margen_excedente = 0;
       int z = 0;
       long cont_excedente = 0;
       long suma = 0;
       long auxM;
       long auxm;
       int mnt = 0;
       String resultado = "";
       switch(Base)
       {
           case 1 -> margen_excedente = 2;
           case 2 -> margen_excedente = 8;
           case 3 -> {margen_excedente = Long.parseLong(N) + Long.parseLong(N2); return Long.toString(margen_excedente);}
           case 4 -> margen_excedente = 16;
       }
       for(int i = 0; mnt == 0; i++)
        {
            if(N.length() - i - 1 < 0)
            {
                auxM = 0;
            }
            else
            {
                auxM = N.charAt(N.length() - i  - 1);
                auxM = conver.getNumber(auxM);
            }
            if(N2.length() - i - 1 < 0)
            {
                auxm = 0;
            }
            else
            {
                auxm = N2.charAt(N2.length() - i  - 1);
                auxm = conver.getNumber(auxm);
            }
            suma = auxM + auxm + cont_excedente;
            if(suma == 0 && cont_excedente == 0)
            {
               if(i >= N.length() && i >= N2.length())
               {
                   mnt++;
               }
            }
            cont_excedente = 0;
            if(suma >= margen_excedente)
            {
                for(;suma >= margen_excedente;)
                {
                    cont_excedente++;
                    suma = suma - margen_excedente;
                }
            }
            if(suma > 9)
            {
                resultado = resultado + conver.getCode(Long.toString(suma));
            }
            else
            {
                if(suma == 0)
                {
                    resultado  = resultado.concat("0");
                }
                else
                {
                    resultado = resultado + Long.toString(suma);
                }
            }
        }
       StringBuilder revert = new StringBuilder(resultado);
       resultado = revert.reverse().toString();
       while(resultado.charAt(z) == '0')
       {
           z++;
       }
       resultado = resultado.substring(z); 
       return resultado;
   }
   public String RestaN(String N, String N2, int Base)
   {
       long margen_excedente = 0;
       int z = 0;
       long cont_excedente = 0;
       long resta = 0;
       long auxM;
       long auxm;
       int esnegativo = 0;
       int mnt = 0;
       String resultado = "";
       String mayor;
       String menor;
       switch(Base)
       {
           case 1 -> margen_excedente = 2;
           case 2 -> margen_excedente = 8;
           case 3 -> {margen_excedente = Long.parseLong(N) - Long.parseLong(N2); return Long.toString(margen_excedente);}
           case 4 -> margen_excedente = 16;
       }
       if(conver.FromNToDec(N, Base) > conver.FromNToDec(N2, Base))
       {
           mayor = N;
           menor = N2;
       }
       else
       {
           mayor = N2;
           menor = N;
           esnegativo++;
       }
       for(int i = 0; mnt == 0; i++)
        {
            if(mayor.length() - i - 1 < 0)
            {
                auxM = 0;
            }
            else
            {
                auxM = mayor.charAt(mayor.length() - i  - 1);
                auxM = conver.getNumber(auxM);
            }
            if(menor.length() - i - 1 < 0)
            {
                auxm = 0;
            }
            else
            {
                auxm = menor.charAt(menor.length() - i  - 1);
                auxm = conver.getNumber(auxm);
            }
            resta = auxM - auxm + cont_excedente;
            if(resta == 0 && cont_excedente == 0)
            {
                if(N.length() - i - 1 < 0 && N2.length() - i - 1 < 0)
                {
                    mnt++;
                }
            }
            cont_excedente = 0;
            if(resta < 0)
            {
                for(;resta < 0;)
                {
                    cont_excedente--;
                    resta = resta + margen_excedente;
                }
            }
            if(resta > 9)
            {
                resultado = resultado + conver.getCode(Long.toString(resta));
            }
            else
            {
                if(resta == 0)
                {
                    resultado  = resultado + "0";
                }
                else
                {
                    resultado = resultado + Long.toString(resta);
                }
            }
        }
       StringBuilder revert = new StringBuilder(resultado);
       resultado = revert.reverse().toString();
        while(resultado.charAt(z) == 48)
        {
           if(resultado.length() - 1 > z)
           {
               z++;
           }
           else
           {
               break;
           }
        }
       resultado = resultado.substring(z); 
       if(esnegativo > 0 && resultado.charAt(0) != 48)
       {
           resultado = "-" + resultado;
       }
       return resultado;
   }
   public String MultiplicacionN(String N, String N2, int Base)
   {
       long margen_excedente = 0;
       int z = 0;
       long cont_excedente = 0;
       long multip = 0;
       long auxM;
       long auxm;
               
       int mnt = 0;
       String resultadoParcial = "";
       String resultadoFinal = "0";
       String mayor;
       String menor;
       switch(Base)
       {
           case 1 -> margen_excedente = 2;
           case 2 -> margen_excedente = 8;
           case 3 -> {margen_excedente = Long.parseLong(N) * Long.parseLong(N2); return Long.toString(margen_excedente);}
           case 4 -> margen_excedente = 16;
       }
       if(N.length() > N2.length())
       {
           mayor = N;
           menor = N2;
       }
       else
       {
           mayor = N2;
           menor = N;
       }
       for(int i = 0; i < menor.length() ; i++)
        {
            auxm = menor.charAt(menor.length() - i  - 1);
            auxm = conver.getNumber(auxm);
            for(int o = 0; mnt == 0; o++)
            {
                if(mayor.length() - o - 1 < 0)
                {
                    auxM = 0;
                }
                else
                {
                    auxM = mayor.charAt(mayor.length() - o  - 1);
                    auxM = conver.getNumber(auxM);
                }
                multip = (auxm * auxM) + cont_excedente;
                if(multip == 0 && cont_excedente == 0)
                {
                    if(o >= mayor.length())
                    {
                        mnt++;
                    }
                }
                cont_excedente = 0;
                if(multip >= margen_excedente)
                {
                    for(;multip >= margen_excedente;)
                    {
                        cont_excedente++;
                        multip = multip - margen_excedente;
                    }
                }
                if(multip > 9)
                {
                    resultadoParcial = resultadoParcial + conver.getCode(Long.toString(multip));
                }
                else
                {
                    if(multip == 0)
                    {
                        resultadoParcial  = resultadoParcial.concat("0");
                    }
                    else
                    {
                        resultadoParcial = resultadoParcial + Long.toString(multip);
                    }
                }
            }
            StringBuilder revert = new StringBuilder(resultadoParcial);
            resultadoParcial = revert.reverse().toString();
            for(int p = 0; p != i; p++)
            {
                resultadoParcial = resultadoParcial + "0";
            }
            resultadoFinal = SumaN(resultadoFinal, resultadoParcial, Base);
            resultadoParcial = "";
            revert = revert.delete(0, revert.length()-1);
            mnt--;
        }
       while(resultadoFinal.charAt(z) == 48)
       {
           z++;
       }
       resultadoFinal = resultadoFinal.substring(z); 
       return resultadoFinal;
   }
   public String DivisionN(String N, String N2, int Base)
   {
       int zparte = 0;
       long adicion = 0;
       int nm=0;
       int z=0;
       String resultado = "";
       String mayor;
       String menor;
       String parte = "0";
       if(conver.FromNToDec(N, Base) > conver.FromNToDec(N2, Base))
       {
           mayor = N;
           menor = N2;
       }
       else
       {
           mayor = N2;
           menor = N;
       }
       for(;nm == 0;)
       {
            while(conver.FromNToDec(parte, Base) < conver.FromNToDec(menor, Base))
            {
                if(zparte < mayor.length())
                {
                    parte = parte + mayor.substring(zparte, zparte + 1);
                    if(zparte > 1)
                    {
                        resultado = resultado + "0";
                    }
                    zparte++;
                }else
                {
                    break;
                }
            }
            while(conver.FromNToDec(menor, Base) <= conver.FromNToDec(parte, Base))
            {
                parte = RestaN(parte, menor, Base);
                adicion++;
            }
            if(zparte < mayor.length())
            {
                mayor = parte + mayor.substring(zparte);
                zparte = 0;
                parte = "0";
            }
            else
            {
                nm++;
            }
            if(adicion > 9)
            {
                resultado = resultado + conver.getCode(Long.toString(adicion));
            }
            else
            {
                resultado = resultado + Long.toString(adicion); 
            }
            adicion = 0;
       }
       while(resultado.charAt(z) == 48)
       {
           z++;
       }
       resultado = resultado.substring(z); 
       return resultado;
   }
}