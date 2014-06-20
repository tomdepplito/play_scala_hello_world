package models
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current

case class Answer(start: Int) {
  val result = Answer.fib(start)
}

object Answer {
  def all(): List[Answer] = Nil
  def create(result: Integer) {}
  def delete(id: Integer) {}

  def save(answer: Answer) {
    DB.withConnection{ implicit connection =>
     SQL(
       """
         INSERT INTO answers(result)
         VALUES({result})
       """ ).on(
            'result -> answer.result
       ).executeUpdate
    }
  }

  def fib(num: Int): Int = {
    if(num < 2)
      return 1
    else
      fib(num-2) + fib(num-1);
  }
}
