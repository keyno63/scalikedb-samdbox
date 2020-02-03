package domain

case class SampleData[Base](ingredients: Map[String, Int])

sealed trait Base
private trait On extends Base
private trait Off extends Base

object Util {
  type SampleOn = SampleData[On]
  type SampleOff = SampleData[Off]
}

object SampleTypeSafeBuilder {
  def apply(): SampleTypeSafeBuilder[Off] = new SampleTypeSafeBuilder()
}

class SampleTypeSafeBuilder[T <: Base] private(
  recipe: SampleData[Base] = SampleData(Map.empty[String, Int].withDefaultValue(0))
) {
}