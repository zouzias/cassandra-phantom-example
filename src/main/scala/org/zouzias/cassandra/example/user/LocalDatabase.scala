package org.zouzias.cassandra.example.user

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoints}
import com.outworkers.phantom.dsl._


object Defaults {
  val connector = ContactPoints(Seq("192.168.99.100")).keySpace("zouzias")
}

class LocalDatabase(val keyspace: CassandraConnection) extends Database[LocalDatabase](keyspace) {
  object users extends Users with keyspace.Connector
}

object LocalDatabase extends LocalDatabase(Defaults.connector)
