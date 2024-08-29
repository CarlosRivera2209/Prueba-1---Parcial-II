
package progra2;


public class funcionesRecursivas {

   public static int sumaNUP(int num){
       if(num>=1){
           return sumaNUP(num-1)+num;
       }else{
           return 0;
       }
   }
   
   public static int sumaNDOWN(int num,int total){
       if (num>=1){
           return sumaNDOWN(num-1,total+num);
       }else{
           return total;
       }
   }
   
   public static int sumanNDOWN(int num){
       return sumaNDOWN(num,0);
   }
   
   private static boolean esPalindromo(String palabra,int posInicio, int posFin){
     if (posFin>=posInicio)  {
         if (palabra.charAt(posInicio)==palabra.charAt(posFin)){
             return esPalindromo(palabra,posInicio+1,posFin-1);
         }else{
             return false;
         }
     }
     return true;
   }
   
   public static boolean esPalindromo(String palabra){
       return esPalindromo(palabra,0,palabra.length()-1);
   }
   
   private static void piramide(int base){
     piramide(base,1,1)  ;
   }
   
    private static void piramide(int base,int fila,int col) {
       if (fila<=base){
           if (col<=fila){
               System.out.print("*");
               piramide(base,fila,col+1);
           }else{
               System.out.println("");
               piramide(base,fila+1,1);
           }
       }
    }
}
