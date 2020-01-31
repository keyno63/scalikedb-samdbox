package domain

case class SampleData[Base](ingredients: Map[String, Int])

sealed trait Base
trait On extends Base
trait Off extends Base

type NotMocoRecipe = SampleData[On]
type MocosRecipe = SampleData[Off]

object SampleTypeSafeBuilder {
}
