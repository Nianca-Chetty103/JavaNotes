public class Fabonacci {
  public static double Fabonacci( int n ) {
    if (n == 1 || n == 0 ) {
      return 1;
    }
    else 
    {
      return Fabonacci(n - 1 ) + Fabonacci( n - 2 ) ;
    }

  public static void main( String[] args ) {
    System.out.println(Fabonacci(4));
  }
