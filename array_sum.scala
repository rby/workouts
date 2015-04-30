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
