import org.squeryl.KeyedEntity
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column

object BaseEntity extends KeyedEntity[Int] {
  val id: Int = 0
}