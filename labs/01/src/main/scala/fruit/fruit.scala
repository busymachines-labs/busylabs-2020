package fruit

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 31 Mar 2020
  *
  */

sealed trait Fruit
final case class Apple(nrOfSeeds: Int)  extends Fruit
final case class Orange() extends Fruit