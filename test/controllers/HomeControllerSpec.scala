package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Future
import play.api.mvc._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HomeControllerSpec extends PlaySpec with Results {


  "Convirtiendo el 100 a romano" should {
    "should be valid" in {
      val controller = new HomeController(stubControllerComponents())
      val result = controller.decToRoman(100)
      result mustBe "C"
    }
  }

  "Convirtiendo el 1 a romano" should {
    "should be valid" in {
      val controller = new HomeController(stubControllerComponents())
      val result = controller.decToRoman(1)
      result mustBe "I"
    }
  }

  "Convirtiendo el 28 a romano" should {
    "should be valid" in {
      val controller = new HomeController(stubControllerComponents())
      val result = controller.decToRoman(28)
      result mustBe "XXVIII"
    }
  }



/*
  "HomeController GET" should {

    "render the index page from a new instance of controller" in {
      val controller = new HomeController(stubControllerComponents())
      val home = controller.index().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Welcome to Play")
    }

    "render the index page from the application" in {
      val controller = inject[HomeController]
      val home = controller.index().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Welcome to Play")
    }

    "render the index page from the router" in {
      val request = FakeRequest(GET, "/")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Welcome to Play")
    }
  }
*/

}
