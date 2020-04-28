package app

import fruit._

trait Printer {
  def print(msg: String): Unit
}

object Printer {
  final val IGuessItIsUsed: Int = 42
  def ThisIsAlsoUsed:       Int = 42
}

final class PrinterImpl extends Printer {
  override def print(msg: String): Unit = println(msg)
}

object Main {

  private val printer: Printer = new PrinterImpl

  private val otherPrinter: String => Unit = printer.print

  private val appleStringer: Apple => String = apple => apple.toString

  final def main(args: Array[String]): Unit = {
//    printer.print(Apple(42).toString)
//    printer.print(Printer.IGuessItIsUsed.toString)
//    printer.print(Printer.ThisIsAlsoUsed.toString)
    val apples: List[Apple] = List(Apple(1), Apple(2), Apple(3), Apple(4))
//    printList(apples)

    apples
      .filter(apple => (apple.nrOfSeeds % 2 == 0))
      .map(appleStringer)
      .map(printer.print)
    //.map(otherPrinter)

//    apples
//      .map(otherPrinter.compose(appleStringer))
  }

  @scala.annotation.tailrec
  def printList(apples: List[Apple]): Unit = apples match {
    case head :: Nil => printer.print(head.toString)
    case head :: tail =>
      printer.print(head.toString)
      printList(tail)
  }
}
