package controllers

import play.api._
import play.api.mvc._
//import models.Answer

import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.adapters.MySQLAdapter


import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column

object Schema extends Schema {
  val answers = table[Answers]
  val databaseUsername = "root"
  val databasePassword = ""
  val databaseConnection = "jdbc:mysql://localhost/scala_hello_world"
  on(answers)(answer => declare(
  ))
  def startDatabaseSession(): Unit = {
  Class.forName("com.mysql.jdbc.Driver")
  SessionFactory.concreteFactory = Some(() => Session.create(
    java.sql.DriverManager.getConnection(databaseConnection,
    databaseUsername, databasePassword),
    new MySQLAdapter)
  )
}
}



class Answers(result: Int) {
  val thisResult = Answer.fib(result)
  //def this() = this("", "")
}

object Answer {
  def fib(num: Int): Int = {
    if(num < 2)
      return 1
    else
      fib(num-2) + fib(num-1);
  }
}



object Application extends Controller {

  def index = Action {
    var testAnswer = new Answers(4)
    transaction {
      Schema.answers.insert(testAnswer)
    }
    //var testAnswer = new Answer(6)
    //Answer.save(testAnswer)
    //println(testAnswer.result) // Test log to console
    var answer:String = "Answer: " + testAnswer.thisResult
    Ok(views.html.index(answer))
  }
}