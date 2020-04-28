package busy.labs04

import scala.util.{Failure, Try}

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 28 Apr 2020
  *
  */
object OptSol {

  def castToInt(s: Any): Option[Int] = {
    if (s.isInstanceOf[Int]) Option(s.asInstanceOf[Int]) else Option.empty
  }

}

object TrySol {

  def castToInt(s: Any): Try[Int] = {
    if (s.isInstanceOf[Int]) Try(s.asInstanceOf[Int]) else Failure(new RuntimeException(s"$s is not an Int"))
  }

}
