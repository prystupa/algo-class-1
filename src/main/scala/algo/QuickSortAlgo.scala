package algo

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 2/9/13
 * Time: 10:40 AM
 */

class QuickSortAlgo {

  type PivotStrategy = (Array[Int], Int, Int) => Int

  def sort(input: Array[Int], choosePivotIndex: PivotStrategy): Int = {

    def swap(i: Int, j: Int) {
      val temp = input(i)
      input(i) = input(j)
      input(j) = temp
    }

    def sort(start: Int, end: Int): Int = {

      if (end - start <= 1) 0
      else {
        val pivotIndex = choosePivotIndex(input, start, end)
        val pivot = input(pivotIndex)

        swap(start, pivotIndex)
        var k = start + 1

        for (i <- start + 1 until end) {
          if (input(i) < pivot) {
            swap(i, k)
            k = k + 1
          }
        }

        swap(start, k - 1)

        val left = sort(start, k - 1)
        val right = sort(k, end)
        end - start - 1 + left + right
      }
    }

    sort(0, input.length)
  }
}
