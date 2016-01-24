package org.zouzias.cassandra.example.user

import com.websudos.phantom.connectors.{ContactPoints, KeySpaceDef}


object Defaults {
  val connector = ContactPoints(Seq("192.168.99.100")).keySpace("zouzias")
}

class LocalDatabase(val keyspace: KeySpaceDef) extends com.websudos.phantom.db.DatabaseImpl(keyspace) {
  object users extends ConcreteUsers with keyspace.Connector
}

object LocalDatabase extends LocalDatabase(Defaults.connector)
