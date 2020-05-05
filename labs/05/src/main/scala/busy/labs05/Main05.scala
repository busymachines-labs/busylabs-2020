package busy.labs05

import busymachines.pureharm.aws.cloudfront.CloudfrontConfig
import busymachines.pureharm.effects.pools.IORuntime
import busymachines.pureharm.internals.effects.PureharmIOApp
//import cats.Later
//import cats.effect.{ContextShift, ExitCode, IO, Timer}
import busymachines.pureharm.effects._ //cleaner import of the above two
import busymachines.pureharm.aws.s3.S3Config

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 05 May 2020
  *
  */
object Main05 extends PureharmIOApp {

  private val logger = io.chrisdavenport.log4cats.slf4j.Slf4jLogger.getLogger[IO]

  override val ioRuntime: Later[(ContextShift[IO], Timer[IO])] =
    IORuntime.defaultMainRuntime(threadNamePrefix = "busylabs-05")

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _        <- logger.info("Starting-main")
      s3Config <- S3Config.fromNamespace[IO]("busylabs.lab05.aws.s3")
      cfConfig <- CloudfrontConfig.fromNamespace[IO]("busylabs.lab05.aws.cloudfront")
      _        <- logger.info(s"S3Config: $s3Config")
      _        <- logger.info(s"S3Config: $cfConfig")
    } yield ExitCode.Success
  }

}
