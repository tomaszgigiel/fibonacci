package pl.tomaszgigiel.fibonacci

import cats.effect.IOApp
import com.typesafe.scalalogging.Logger

@main
def ScalaApp(): Unit =
  val logger = Logger("fibonacci")
  logger.info("ok")
