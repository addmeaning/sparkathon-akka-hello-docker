package com.addmeaning

import java.net.InetAddress

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContextExecutor

object HelloWorldService {
  implicit val system: ActorSystem = ActorSystem()
  implicit val executor: ExecutionContextExecutor = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val logger = Logging(system, getClass)

    val routes =
      get {
        pathSingleSlash {
          complete {
            s"Hello from ${InetAddress.getLocalHost.getHostName}!"
          }
        }
      }

    Http().bindAndHandle(
      routes,
      config.getString("http.address"),
      config.getInt("http.port")
    )
  }
}