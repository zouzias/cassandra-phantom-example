package org.zouzias.cassandra.example.user

import java.util.UUID

import com.outworkers.phantom.dsl._
import org.joda.time.DateTime

import scala.concurrent.Future

case class User(
  id: UUID,
  email: String,
  name: String,
  registrationDate: DateTime
)

abstract class Users extends CassandraTable[Users, User] with RootConnector {
  object id extends UUIDColumn(this) with PartitionKey
  object email extends StringColumn(this)
  object name extends StringColumn(this)
  object registrationDate extends DateTimeColumn(this)

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
