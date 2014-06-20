package models
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current

case class Answer(id: Integer, start: Integer) {
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
         INSERT INTO answers(id, result)
         VALUES({id}, {result})
       """ ).on(
            'id -> answer.id,
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
