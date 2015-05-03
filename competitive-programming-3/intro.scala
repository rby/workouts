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

//4.
def sortedUnique(numbers: Array[Int]) {
  if (numbers.size > 0) {
    var sorted = numbers.sorted
    var current = sorted(0)
    println(current)
    for( x <- sorted )
      if ( x != current ) {
        current = x
        println(current)
      }
  }
}
//5.
type DD = Int
type MM = Int
type YYYY = Int
type Birthday = (DD, MM, YYYY)

def birthSort(birthdays: Array[Birthday]) =
    birthdays.sortBy{case (dd, mm, yyyy) => (mm, dd, (-yyyy, -mm, -dd))}
// 6.
import scala.annotation.tailrec
def binSearch(v:Int, array:Array[Int]) : Boolean = {
  @tailrec
  def aux(start:Int, end:Int, count:Int) : (Boolean, Int) =
    (end - start) match {
      // trivial
      case 0 => (array(start) == v, count + 1)
      case 1 => if (array(start) == v) (true, count + 1)
                else (array(end) == v, count + 2)
      // bin search
      case _ =>
        val middle = (end - start) / 2 + start
        (array(middle) - v) match {
          case 0 => (true, count + 1)
          case x if x > 0 => aux(start, middle - 1, count + 1)
          case _ => aux(middle + 1, end, count + 1)
        }
    }
  val (res, count) = aux(0, array.size - 1, 0)
  println("comparisons : " + count)
  res
}

//7.
// takes too much time for 10 elements
def perms(set : List[Char]) : List[List[Char]] =
  set match {
    case Nil => List(Nil)
    case _ => for(x<-set; xx <- perms(set diff List(x))) yield x::xx
  }

def permsArr(arr: Array[Char]): Array[Array[Char]] =
  if (arr.size == 0) Array(Array()) else
  for (i <- arr.indices.toArray;
       val x = arr(i);
       val subarr = arr.slice(0,i) ++ arr.slice(i+1,arr.size);
       xx <- permsArr(subarr)) yield Array(x) ++ xx
