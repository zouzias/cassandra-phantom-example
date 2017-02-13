package org.zouzias.cassandra.example.user

import java.util.UUID

import com.outworkers.phantom.connectors.KeySpace
import org.joda.time.DateTime

import scala.concurrent.ExecutionContext

/**
  * Example from http://blog.websudos.com/2015/04/04/a-series-on-phantom-part-1-getting-started-with-phantom/
  */
object UsersExampleMain extends App{

  implicit val ex = ExecutionContext.Implicits.global
  implicit val session = LocalDatabase.session
  implicit val keySpace = KeySpace(LocalDatabase.keyspace.name)

  LocalDatabase.create()

  val user = User(UUID.randomUUID(), "zouzias@swisscom.com", "Tassos Zouzias", new DateTime())
  LocalDatabase.users.store(user)

  val returnedUser = LocalDatabase.users.getLimit(1)

  returnedUser.onSuccess{ case result =>
  println(s"Size is ${result.all().size()}")
  }

}
