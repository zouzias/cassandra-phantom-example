package org.zouzias.cassandra.example.user


import java.util.UUID

import com.websudos.phantom.dsl._
import org.joda.time.DateTime

case class User(id: UUID, email: String, name: String, registrationDate: DateTime)

class Users extends CassandraTable[ConcreteUsers, User] {
  object id extends UUIDColumn(this) with PartitionKey[UUID]
  object email extends StringColumn(this)
  object name extends StringColumn(this)
  object registrationDate extends DateTimeColumn(this)

  def fromRow(row: Row): User = {
    User(
      id(row),
      email(row),
      name(row),
      registrationDate(row)
    )
  }
}
