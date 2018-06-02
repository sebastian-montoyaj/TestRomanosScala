package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Future
import play.api.mvc._
import play.api.Application
import controllers._

// Clase para realizar las pruebas
class HomeControllerSpec extends PlaySpec with Results {
  
  // Variable comun a las pruebas
  val controller = new HomeController(stubControllerComponents())
  
  "Convirtiendo el 100 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(100)
      result mustBe "C"
    }
  }

  "Convirtiendo el 1 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(1)
      result mustBe "I"
    }
  }

  "Convirtiendo el 28 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(28)
      result mustBe "XXVIII"
    }
  }

  "Saludando" should {
    "should be valid" in {
      val result = controller.hello
      result mustBe "Hola mundo"
    }
  }
  
  //------ Desde aqui comienzan las pruebas del CodeBreaker
  
  
  
  "Probando que ninguno este" should {
    "should be valid" in {
      val result = controller.codeBreaker("1111")
      result mustBe "    "
    }
  }

  "Probando que los contenga pero todos en desorden" should {
    "should be valid" in {
      val result = controller.codeBreaker("1234")
      result mustBe "___ "
    }
  }

  "Probando que no contenga ninguno" should {
    "should be valid" in {
      val result = controller.codeBreaker("1834")
      result mustBe "___ "
    }
  }

  "Probando que contenga tres en la posicion correcta y uno no exista" should {
    "should be valid" in {
      val result = controller.codeBreaker("1236")
      result mustBe "__  "
    }
  }

  "Probando que contenga cuatro en la posición correcta" should {
    "should be valid" in {
      val result = controller.codeBreaker("3428")
      result mustBe "XXXX"
    }
  }

   "Probando que contenga la cuatro en desorden" should {
    "should be valid" in {
      val result = controller.codeBreaker("4283")
      result mustBe "____"
    }
  }

    "Probando que tenga tres bien y uno incorrecto" should {
    "should be valid" in {
      val result = controller.codeBreaker("3128")
      result mustBe "XXX "
    }
  }

  // Prueba para ver que los servicios responden de manera exitosa
  "HomeController" should {
    " - Servicio exitoso" in {
      val controller = new HomeController(stubControllerComponents())
      controller.changeSecretCodeService("1234").apply(FakeRequest(GET, "/changeSecret/1234"))
      val result = controller.codeBreakerService("1234").apply(FakeRequest(GET, "/codebreaker/1234"))

      status(result) mustBe OK
      contentType(result) mustBe Some("application/json")
      contentAsString(result) must include ("""{"status":"Ok","message":"Resultado es: XXXX"}""")
      
    }
  }
  
  //------ Aqui terminan las pruebas del CodeBreaker

}
