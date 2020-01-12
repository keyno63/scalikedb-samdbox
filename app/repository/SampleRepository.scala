package repository

import java.time.OffsetDateTime

import play.api.libs.json.{Json, Writes}
import scalikejdbc.NamedDB
import scalikejdbc._
import scalikejdbc.jsr310._

object SampleRepository {
  def findAll: Seq[Post] = NamedDB('pgsql) readOnly { implicit session =>
    sql"SELECT name, date FROM company".map { rs =>
      Post(
        rs.long("id"),
        rs.string("body"),
        rs.offsetDateTime("date")
      )
    }.list().apply()
  }

  def add(post: Post): Unit = NamedDB('pgsql) localTx { implicit session =>
    sql"INSERT INTO posts (body, date) VALUES (${post.body}, ${post.date})".update().apply()
  }
}

case class Post(id: Long, body: String, date: OffsetDateTime)

object Post {

  implicit val writes: Writes[Post] = Json.writes[Post]

  def apply(body: String, date: OffsetDateTime): Post =
    Post(0, body, date)
}