package org.zouzias.cassandra.example.user

import scala.concurrent.ExecutionContext
import com.outworkers.phantom.connectors.KeySpace
import com.outworkers.util.testing._

/**
  * Example from http://blog.websudos.com/2015/04/04/a-series-on-phantom-part-1-getting-started-with-phantom/
  */
object UsersExampleMain extends App{

  implicit val ex = ExecutionContext.Implicits.global
  implicit val session = LocalDatabase.session
  implicit val keySpace = KeySpace(LocalDatabase.keyspace.name)

  LocalDatabase.create()

  val user = gen[User]
  LocalDatabase.users.store(user)

  val returnedUser = LocalDatabase.users.getLimit(1)

  returnedUser.onSuccess{ case result =>
  println(s"Size is ${result.all().size()}")
  }

}
