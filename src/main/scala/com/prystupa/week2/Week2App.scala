package com.prystupa.week2

import io.Source
import algo.QuickSortAlgo

object Week2App extends App {

  val algo = new QuickSortAlgo

  val runTimeStart = algo.sort(readInput, (input, start, end) => start)
  val runTimeEnd = algo.sort(readInput, (input, start, end) => end - 1)
  val runTimeMedian = algo.sort(readInput, chooseMedian)

  def readInput = {
    val source = Source.fromURL(getClass.getResource("QuickSort.txt"))
    val input = source.getLines().map(_.toInt).toArray

    input
  }

  println(runTimeStart, runTimeEnd, runTimeMedian)

  /*
  0 until 2 => 0
  0 until 3 => 1
  10 until 12 => 10
  10 until 13 => 11
   */
  def chooseMedian(input: Array[Int], start: Int, end: Int) = {

    val indexes = Vector(start, (start + end - 1) / 2, end - 1)
    val sorted = indexes.sortBy(input(_))
    sorted(1)
  }
}
