package busy.labs04

import scala.util._

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 28 Apr 2020
  *
  */
object Main extends App {

  //varianta 1: exception
  //varianta 2: print something
  //varianta 3: set perror
  //varianta 4: magic value (NULL, null, 0, -1, etc)

  val Solution = TrySol
  type Effect[+A] = Try[A]


//  def broken(s: Any): Int = s.asInstanceOf[Int]

//  val brokenInt = broken("notAnInt")
  val int1: Effect[Int] = Solution.castToInt(42)
  val int2: Effect[Int] = Solution.castToInt(13)
  val int3: Effect[Int] = Solution.castToInt(13)
  val int4: Effect[Int] = Solution.castToInt("13")

  val intAdd: Effect[Int] = int1.flatMap { int1Value: Int =>
    int2.flatMap { (int2Value: Int) => int3.map(int3Value => int1Value + int2Value + int3Value) }
  }

//  val intAddNotSoCool = for {
//    int1 <- intL1
//    int2 <- intL2
//    int3 <- intL3
//  } yield int1 + int2 + int3

  val intAddNice: Effect[Int] = for {
    intValue1 <- int1
    intValue2 <- int2
    intValue3 <- int3
    intValue4 <- int4
  } yield intValue1 + intValue2 + intValue3 + intValue4

  val intPlus10: Effect[Int] = int1.map(x => x + 10)

  println(intAdd)
  println(intAddNice)

  //  val x: Try[Int] = (??? : Try[Try[Int]]).flatten

  //  val intAddHorror: Try[Int] = if (int1.isDefined) {
  //    val intValue1 = int1.get
  //    if (int2.isDefined) {
  //      val intValue2 = int2.get
  //      if (int3.isDefined) {
  //        val intValue3 = int3.get
  //        Try(intValue1 + intValue2 + intValue3)
  //      }
  //      else {
  //        Try.empty
  //      }
  //    }
  //    else {
  //      Try.empty
  //    }
  //  }
  //  else {
  //    Try.empty
  //  }
}
