package models

case class Answer(id: Long, start: Integer) {
  val result = Answer.fib(start)
}

object Answer {
  def all(): List[Answer] = Nil
  def create(result: Integer) {}
  def delete(id: Long) {}
  def fib(num: Int): Int = {
    if(num < 2)
      return 1
    else
      fib(num-2) + fib(num-1);
  }
}