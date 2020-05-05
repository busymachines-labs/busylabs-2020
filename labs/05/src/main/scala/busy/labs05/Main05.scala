package busy.labs05

import busymachines.pureharm.effects.pools.IORuntime
import busymachines.pureharm.internals.effects.PureharmIOApp
//import cats.Later
//import cats.effect.{ContextShift, ExitCode, IO, Timer}
import busymachines.pureharm.effects._ //cleaner import of the above two

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 05 May 2020
  *
  */
object Main05 extends PureharmIOApp {

  override val ioRuntime: Later[(ContextShift[IO], Timer[IO])] =
    IORuntime.defaultMainRuntime(threadNamePrefix = "busylabs-05")

  override def run(args: List[String]): IO[ExitCode] =
    IO(println("hello-world")).map(_ => ExitCode.Success)
}
