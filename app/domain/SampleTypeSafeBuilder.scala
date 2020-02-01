package domain

case class SampleData[Base](ingredients: Map[String, Int])

sealed trait Base
trait On extends Base
trait Off extends Base

type OnSampleData = SampleData[On]
type OffSampleData = SampleData[Off]

object SampleTypeSafeBuilder {
  def apply(): SampleTypeSafeBuilder[Off] = new SampleTypeSafeBuilder()
}

class SampleTypeSafeBuilder[T <: Base] private(
  recipe: SampleData[Base] = SampleData(Map.empty[String, Int].withDefaultValue(0))
) {
}