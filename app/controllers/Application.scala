package controllers

import play.api._
import play.api.mvc._
import models.Answer

object Application extends Controller {

  def index = Action {
    var testAnswer = new Answer(123, 6)
    Answer.save(testAnswer)
    println(testAnswer.result) // Test log to console
    var answer:String = "Answer: " + testAnswer.result
    Ok(views.html.index(answer))
  }
}