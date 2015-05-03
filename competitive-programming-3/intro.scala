// ex 1.2.3
import System.out.printf

//1.
printf("%7.3f\n", java.lang.Double.valueOf(1.4732))

//2.

def printPIRounded(n:Int) {
  val mul = Math.pow(10, n)
  println((Math.PI * mul + 0.5).intValue / mul)
}

//3.
import java.time.LocalDate
def dayOfWeek(date:String) = LocalDate.parse(date).getDayOfWeek



