package domain

object Domain extends App {
  DomainBuilder().name("some").id(1).build
}

case class DomainBase(name: String, id: Int)

object DomainBuilder {
  def apply(): DomainBuilder = new DomainBuilder()
}

class DomainBuilder(
     domain: DomainBase = DomainBase("", 0)
   ) {

  def name(name: String) = new DomainBuilder(domain.copy(name = name))
  def id(id: Int) = new DomainBuilder(domain.copy(id = id))
  def build: Unit = {
    println(s"name=${domain.name}, id=${domain.id}")
  }


}