/**
 * The maximum sum of a contiguous subarray, numbers could be negative
 * but we know there's at least one positive number
 *
 * Solution:
 * Use dynamic programming to compute the sum of all subarrays
 *       █ █ █ █        given the sum from i to j
 *       █ █ █    -     we substract the sum from i to j-1
 *         █ █    +     Add the sum from i+1 to j-1
 *  ----------------
 *         █ █ █  =     w get the sum from i+1 to j
 *
 * @author: Ramzi Ben Yahya
 * 10 minute to solve
 * I wrote the code in the scala repl, building small functions to test
 * quickly. Then I saved and edited the session in vim.
 * Note: I think it could be done in 5 lines using memoization.
 */
object ArraySum {
    type Matrix = Array[Array[Int]]
    def matrix(size:Int) = new Array[Int](size).map(_ => new Array[Int](size))
    def next_val(m:Matrix, i:Int, j:Int) = {
        val x = if (i == 0 || j == 0) 0 else m(i-1)(j-1);
        val y = if(i == 0) 0 else m(i-1)(j);
        val z = if(j==0) 0 else m(i)(j-1);
        y - x + z
    }
    def fill(arr:Array[Int], m: Matrix) = {
        var max, sum, i = 0;
        while(i<arr.size) {
            sum += arr(i);
            m(0)(i) = sum;
            if(sum > max) max = sum;
            i+=1
        };
        max
    }
    def solveMatrix(m: Matrix, initial:Int) = {
        var (max,i,j) = (initial,1,1);
        while(i<m.size){
            while(j<m.size){
                var n = next_val(m,i,j);
                m(i)(j) = n;
                if (n > max) max = n;
                j+=1
            }
            i+=1;
            j = i
        }
        max
    }

    def solve(arr:Array[Int]) = {
        val m = matrix(arr.size)
        var max = fill(arr, m)
        solveMatrix(m, max)
    }
}
// Test
// assert solve(Array(-1, -2, 4, -1, 2, -1, 3)) == 7
