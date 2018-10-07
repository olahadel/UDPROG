public class PiBBPBench {

    /// d   a d+1. hexa jegytől számoljuk a hexa jegyeket
    /// j   Sj indexe

    public static double d16Sj(int d, int j) {      
        double d16Sj = 0.0d;
        
        for(int k=0; k<=d; ++k)
            d16Sj += (double)n16modk(d-k, 8*k + j) / (double)(8*k + j);
        
        /*
        for(int k=d+1; k<=2*d; ++k)
            d16Sj += System.Math.pow(16.0d, d-k) / (double)(8*k + j);
         */
        
        return d16Sj - System.Math.Floor(d16Sj);
    }

    /// Bináris hatványozás mod k, a 16^n mod k kiszámítása.
    /// n   kitevő
    /// k   modulus

    public static long n16modk(int n, int k) {
        int t = 1;

        while(t <= n)
            t *= 2;
        
        long r = 1;
        
        while(true) {          
            if(n >= t) {
                r = (16*r) % k;
                n = n - t;
            }
            
            t = t/2;
            
            if(t < 1)
                break;
            
            r = (r*r) % k;  
        }
        return r;
    }

    /// {16^d Pi} = {4*{16^d S1} - 2*{16^d S4} - {16^d S5} - {16^d S6}}
    /// kiszámítása, a {} a törtrészt jelöli. A Pi hexa kifejtésében a
    /// d+1. hexa jegytől

     public static void Main(System.String[]args) { 
        double d16Pi = 0.0d;
        
        double d16S1t = 0.0d;
        double d16S4t = 0.0d;
        double d16S5t = 0.0d;
        double d16S6t = 0.0d;
        
        int jegy = 0;
        
        System.DateTime kezd = System.DateTime.Now;
        
        //for (int d = 1000000; d < 1000001; ++d)
        //for (int d = 10000000; d < 10000001; ++d)
        for (int d = 100000000; d < 100000001; ++d)
            
            d16Pi = 0.0d;
            
            d16S1t = d16Sj(d, 1);
            d16S4t = d16Sj(d, 4);
            d16S5t = d16Sj(d, 5);
            d16S6t = d16Sj(d, 6);
            
            d16Pi = 4.0d*d16S1t - 2.0d*d16S4t - d16S5t - d16S6t;
            
            d16Pi = d16Pi - System.Math.Floor(d16Pi);
            
            jegy = (int)System.Math.Floor(16.0d*d16Pi);   
        }
        
        System.Console.WriteLine(jegy);
        System.TimeSpan delta = System.DateTime.Now.Subtract(kezd);
        System.Console.WriteLine(delta.TotalMilliseconds/1000.0);
    }
} 