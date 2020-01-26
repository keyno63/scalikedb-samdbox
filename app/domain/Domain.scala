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

  val sample2 = DomainBuilder()
    .name("right")
    .id(3)
  val y = Seq(
    "number 2",
    "sequence",
    "sample"
  )
  y.foldRight(sample2)((yy, ss) => ss.seq(yy)).build()

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