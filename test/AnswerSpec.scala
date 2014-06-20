import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import models.Answer

@RunWith(classOf[JUnitRunner])
class AnswerSpec extends Specification {

  "Answer" should {
    "calculate fibonacci correctly" in {
      val answer = new Answer(4)
      Answer.fib(4) must equalTo(5)
      answer.result must equalTo(Answer.fib(4))
    }
  }
}
