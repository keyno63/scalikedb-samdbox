package domain

object Domain extends App {



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

}