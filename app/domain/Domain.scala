package domain

object Domain extends App {

  val sample = DomainBuilder()
    .name("new")
    .id(2)
  val x = Seq(
    "sample",
    "seq",
    "ence",
    "X!!!"
  )
  x.foldLeft(sample){_.seq(_)}.build()
}

case class DomainBase(name: String, id: Int, sq: Seq[String])

object DomainBuilder {
  def apply(): DomainBuilder = new DomainBuilder()
}

class DomainBuilder(
     domain: DomainBase = DomainBase("", 0, Seq.empty[String])
   ) {

  def name(name: String) = new DomainBuilder(domain.copy(name = name))
  def id(id: Int) = new DomainBuilder(domain.copy(id = id))
  def seq(value: String) = new DomainBuilder(domain.copy(sq = domain.sq :+ value))
  def build(): Unit = {
    println(s"name=${domain.name}, id=${domain.id}")
    println(domain.sq.mkString)
  }


}