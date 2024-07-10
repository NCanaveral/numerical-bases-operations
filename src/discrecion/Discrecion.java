package discrecion;
import java.util.Scanner;
import metodos.Conversion;
import metodos.Operacion;
public class Discrecion 
{
    static Conversion conver = new Conversion();
    static Operacion oper = new Operacion();
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        int a;
        int Op;
        int Base;
        int Convertir;
        int continuar;
        String Numero;
        String Numero2;
        do
        {
            do
            {
                System.out.println("Que desea hacer?\n1.Convertir un numero a otra base     2.Realizar una operacion basica entre dos numeros");
                a = read.nextInt();
                if(a == 1)
                {
                    do
                    {
                        do
                        {
                            System.out.println("En que base se encuentra el numero que desea convertir?\n 1. Binaria   2. Octal   3. Decimal   4. Hexadecimal");
                            Base = read.nextInt();
                            if(Base < 1 || Base > 4)
                            {
                                System.out.println("ERROR: seleccione una base valida");
                            }
                        }while(Base < 1 || Base > 4);
                        do
                        {
                            System.out.println("A que base desea convertir el numero?\n 1. Binaria   2. Octal   3. Decimal   4. Hexadecimal");
                            Convertir = read.nextInt();
                            if(Convertir < 1 || Convertir > 4)
                            {
                                System.out.println("ERROR: Seleccione una base valida a la cual convertir");
                            }
                        }while(Convertir < 1 || Convertir > 4);
                        if(Base == Convertir)
                        {
                            System.out.println("ERROR: la base a la que quiere convertir es igual a la original, seleccione de nuevo");
                        }
                    }while(Base == Convertir);
                    do
                    {
                        System.out.println("Ingrese el numero a convertir");
                        Numero = read.next();
                        if(conver.Validacion(Numero, Base) == false)
                        {
                            System.out.println("ERROR: El numero no se encuentra en la base digitada, por favor ingreselo de nuevo");
                        }
                    }while(conver.Validacion(Numero, Base) == false);
                    if(Base == 3)
                    {
                        System.out.println("Su numero es: " + conver.FromDecToN(Numero, Convertir));
                    }
                    else
                    {
                        if(Convertir == 1)
                        {
                            System.out.println("Su numero es: " + conver.FromOctorHexToBin(Numero, Base));
                        }
                        if(Convertir == 2 || Convertir == 4)
                        {
                            if(Base == 1)
                            {
                                System.out.println("Su numero es: " + conver.FromBintoOctorHex(Numero, Convertir));
                            }
                            else
                            {
                                System.out.println("Su numero es: " + conver.FromOcttoHexorViceversa(Numero, Base, Convertir));
                            }
                        }
                    }
                    if(Convertir == 3)
                    {
                        System.out.println("Su numero es: " + conver.FromNToDec(Numero, Base));
                    }
                }
                if(a == 2)
                {
                    do
                    {
                        System.out.println("En que base se encunetran los numeros que desea operar?\n 1. Binario   2. Octal   3. Decimal   4. Hexadecimal");
                        Base = read.nextInt();
                        if(Base < 1 || Base > 4)
                        {
                            System.out.println("ERROR: Por favor ingrese una base valida!");
                        }
                    }while(Base < 1 || Base > 4);
                    do
                    {
                        System.out.println("Ingrese el primer numero");
                        Numero = read.next();
                        System.out.println("Ingrese el segundo numero");
                        Numero2 = read.next();
                        if(conver.Validacion(Numero, Base) == false || conver.Validacion(Numero2, Base) == false)
                        {
                            System.out.println("ERROR: Algun numero ingresado no existe en la base seleccionada, intente nuevamente");
                        }
                    }while(conver.Validacion(Numero, Base) == false || conver.Validacion(Numero2, Base) == false);
                    do
                    {
                        System.out.println("Que operacion desea realizar?\n1. Suma   2. Resta   3. Multiplicacion   4. Division");
                        Op = read.nextInt();
                        if(Op < 1 || Op > 4)
                        {
                            System.out.println("ERROR: Ingrese una operacion valida");
                        }
                    }while(Op < 1 || Op > 4);
                    switch(Op)
                    {
                        case 1 -> System.out.println("La suma en misma base es: " + oper.SumaN(Numero, Numero2, Base)); 
                        case 2 -> System.out.println("La resta en misma base es: " + oper.RestaN(Numero, Numero2, Base));
                        case 3 -> System.out.println("La multiplicacion en misma base es: " + oper.MultiplicacionN(Numero, Numero2, Base));
                        case 4 -> System.out.println("La division entera en misma base es: " + oper.DivisionN(Numero, Numero2, Base));
                    }
                }
                if(a < 1 || a > 2)
                {
                    System.out.println("ERROR: Por favor ingrese una opcion valida");
                }
            }while(a < 1 || a > 2);
            do
            {
                System.out.println("Desea realizar otra operacion?\n 1. Si   0. No");
                continuar = read.nextInt();
                if(continuar > 1 || continuar < 0)
                {
                    System.out.println("ERROR: Por favor ingrese una opcion valida");
                }
            }while(continuar > 1 || continuar < 0);
        }while(continuar == 1);
    }
}
