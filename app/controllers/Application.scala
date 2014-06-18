package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    var answer:String = "Answer: " + fib(4)
    Ok(views.html.index(answer))
  }

  def fib(num: Int): Int = {
    if(num < 2)
      return 1
    else
      fib(num-2) + fib(num-1);
  }

}