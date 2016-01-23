package org.zouzias.cassandra.example.user

import java.util.UUID
import com.websudos.phantom.dsl._
import scala.concurrent.Future

// The root connector comes from import com.websudos.phantom.dsl._
abstract class ConcreteUsers extends Users with RootConnector {

  def store(user: User): Future[ResultSet] = {
    insert.value(_.id, user.id).value(_.email, user.email)
      .value(_.name, user.name)
      .value(_.registrationDate, user.registrationDate)
      .future()
  }

  def getById(id: UUID): Future[Option[User]] = {
    select.where(_.id eqs id).one()
  }

  def getLimit(limit: Int): Future[ResultSet] = {
    select.limit(limit).future()
  }
}
