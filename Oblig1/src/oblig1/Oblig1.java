

// Sondre Halvorsen, s305349, IT


package oblig1;

import java.util.*;
public class Oblig1 {

    
    
    
    
    public static int maks(int[] a){
        
       int k = 1; 
       int b = a.length - 1;
       int c = 0;
       int m = 0;
       int[] ab = a;
       
        if (a.length < 1)
      throw new java.util.NoSuchElementException("Tabellen a er tom!");
             for(int i = 0; i < a.length -1; i++){
             if(a[i] > a[i +1]){
                 c = a[i];
                 m = a[i + 1];
                 a[i +1] = c;
                 a[i] = m;
                 
                  
                 
             }
             
             
             }
             
           return a[b];
          
       }
    //Det er en dårligere metode som bruker mer tid en mer effektive maks metoder
    
    public static int ombyttinger(int[] a){
    
    int k = 1; 
       int b = a.length - 1;
       int c = 0;
       int m = 0;
       int teller = 0;
       
      
             for(int i = 0; i < a.length - 1; i++){
                 
             if(a[i] > a[i +1]){
                 c = a[i];
                 m = a[i + 1];
                 a[i +1] = c;
                 a[i] = m;
                 teller++;
                  
                 
             }
             
             
             }
             
           return teller;
    
    }
        
      
     public static int[] randPerm(int n)  
  {
    Random r = new Random();        
    int[] a = new int[n];            

    Arrays.setAll(a, i -> i + 1);   

    for (int k = n - 1; k > 0; k--)  
    {
      int i = r.nextInt(k+1);        
      bytt(a,k,i);                  
    }

    return a;                        
  }
      public static void bytt(int[] a, int i, int j)
  {
    int temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
    
    
   

     
  

 

   
    
    
    
  
    
    public static int antallUlikeSortert(int[] a){
     int[] b = {};
     int teller = 1;
     
     if(a.length < 1){
             teller = 0;
             return teller;
         }
         if(a.length == 1){
             return teller;
         }
         
         for(int i = 0; i < a.length - 1; i++){
       
         if(a[i +1] < a[i]){
             throw new IllegalStateException("Tabellen er ikke sortert!");
             
         }
         }
     
     
             
               for(int i = 0; i < a.length -1; i++){
                   
                   if(a[i +1] > a.length){
                       break;
                   }
                   if(a[i] != a[i+1]){
                       teller++;
                   }
               }
           


     
    return teller;
    }
    
    
    public static int antallUlikeUsortert(int[] a){
        
        int b;
        int c;
        int teller = 0;
        boolean f = false;
        if(a.length <= 0){
            return 0;
        }
        
        
           for(int i = 0; i < a.length; i++){
             b = a[i];
             
             for(int j = i +1; j < a.length; j++){
              if(b == a[j]){
                  f = false;
                  break;
              }
              else
                  f = true;
                  
             }
             if(f){
             teller++;}
           }
         if(teller == 0) {
             teller = 1;
         } 
        return teller;
    }
    
 public static void delsortering(int[] a){
      
      int v = 0;
      int h = a.length -1;
      boolean hasChanged = false;
      
      while(true){System.out.println(Arrays.toString(a));
       while (v <= h && a[v] % 2 != 0) v++;     
       while (v <= h && a[h] % 2 == 0) h--;    
        if(v < h){
            hasChanged = true;
            bytt(a,v,h);
            if(v > 0){
                
           if(a[v] < a[v -1]){
               
             int s = 0;
             int t = v -1 ;
             
              
             sorterv(a,s,t,v);
             
            // bytt(a,v,v-1);
             
            }
               }
            
           if(h < a.length) {
               int f = h +1;
               if(a[h] > a[h +1]){
                   sorterh(a,f,a.length-1,h);
                 // bytt(a,h,h+1); 
               }
           }
            
            
        }
        else break;
        System.out.println(Arrays.toString(a));
      }
      System.out.println(hasChanged);
      if(!(hasChanged)){
          Arrays.sort(a,0,a.length);
          
      }
     // Arrays.sort(a,0,v);
    //  Arrays.sort(a,v,a.length);
      
     int [] mas = new int[] {1,2,4,3};
     System.out.println("mas før " + Arrays.toString(mas));
     sorterv(mas,0,2,3);
             
     System.out.println("mas etter " + Arrays.toString(mas));
 }
 
 public static void sorterv(int[] a ,int s ,int t, int v){
     
      while(true){
                int indexCheck = (t-s)/2;
                
                if(t == s){
                     if(a[v] > a[t]){
                      for(int i = t + 1; i < v; i++){
                         bytt(a,i,v);
                         
                 }return;
                 }
                     
                 else if(a[v] < a[t]){
                     int start = t;
                     if(start < 0)start = 0;
                      for(int i = start; i < v; i++){
                         bytt(a,i,v);
                       
                     }
                      return;
                 }
                }
          
                 if(a[v] > a[indexCheck]){
                     s = indexCheck +1;
                 }
                 else if(a[v] < a[indexCheck]){
                     t = indexCheck -1;
                 }
                 else {
                     for(int i = indexCheck +1; i < v; i++){
                         bytt(a,i,v);
                     }return;
                 }
                 
             }
 }
 
 public static void sorterh(int[] a ,int s ,int t, int v){
     
      while(true){
                int indexCheck = (t-s)/2;
                
                if(t == s){
                     if(a[v] > a[t]){
                      for(int i = t + 1; i > v; i--){
                         bytt(a,i,v);
                 }return;
                 }
                 else if(a[v] < a[t]){
                      for(int i = t - 1; i > v; i--){
                         bytt(a,i,v);
                     }
                 }return;
                }
          
                 if(a[v] > a[indexCheck]){
                     s = indexCheck;
                 }
                 else if(a[v] < a[indexCheck]){
                     t = indexCheck;
                 }
                 else {
                     for(int i = indexCheck + 1; i > v; i--){
                         bytt(a,i,v);
                     }return;
                 }
             }
 }
 
 
 
  public static void rotasjon(char[] a){
      
      int h = a.length-1;
      
    
      if(a.length <= 1){
          return;
          
      }
     
     char temp = a[h];
     
     for(int i = a.length-1; i > 0; ){
        
             a[i] = a[i-1];
         i--;
     }
     a[0] = temp;
     
     
     
  
}
  
  
  
  public static void rotasjon(char[] a, int k){
     
    
     if(a.length <= 1) return;
     if(k == 0) return;
  
      
    if(k > 0){  
     if(k > a.length){
		k = k %a.length;
     }
 
	//length of first part
	int b = a.length - k; 
 
	reverse(a, 0, b-1);
	reverse(a, b, a.length-1);
	reverse(a, 0, a.length-1); 
      
      
      
    }
    
     else {
        
         if(k < (- a.length)){
		k = k %a.length;
     }
 
	
	int b = -(k);
        System.out.println(b);
 
	reverse(a, 0,b-1 );
	reverse(a, b,a.length-1 );
	reverse(a,0 ,a.length-1 ); 
        
  }
  }
  
  public static void reverse(char[] a, int v, int h){
	
 
	while(v < h){
		char temp = a[v];
		a[v] = a[h];
		a[h] = temp;
		v++;
		h--;
	}	
}
  
   public static String flett(String s, String t){
       
       if(s.compareTo("") == 0) return t;
       if(t.compareTo("") == 0) return s;
       if(s.length() + t.length() == 0) return "";
      char [] c = new char[s.length() + t.length()];  
    int i = 0, j = 0, k = 0;                 // løkkevariabler

    while (i < s.length() && j < t.length())
    {
      c[k++] = s.charAt(i++);      // først en verdi fra a
      c[k++] = t.charAt(j++);      // så en verdi fra b
    }
    // vi må ta med resten
    while (i < s.length()) c[k++] = s.charAt(i++);
    while (j < t.length()) c[k++] = t.charAt(j++);
    
    String b = new String(c);
    
    return b;
   }
   
   
   
    public static String flett(String... s){
        int length = s.length;
        if(length == 0) return "";
        System.out.println((s[0]));
        
        String [][] g = new String[length-1][];
        String fin = "";       
        int maxIndex = 0;
        
                
        for(int i =0; i < length; i++){
            
           int stringLength = s[i].length() -1; 
           if( stringLength > maxIndex){
               maxIndex = stringLength;
           }
                    
        }
        
        
        
    for (int i = 0;i <= maxIndex; i++)
    {
      
      for(int j = 0; j < length; j++){
          
        
          if(i < s[j].length()){
              
          fin +=  Character.toString(s[j].charAt(i));
          }

      }
      
       
     
     
    }
   
    
    return fin;
    }
        
    
  
  
}
