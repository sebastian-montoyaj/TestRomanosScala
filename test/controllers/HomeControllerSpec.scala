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
  
  //----- Desde aqui comienzan las pruebas del convertidor romano
  
  "Convirtiendo el 1 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(1)
      result mustBe "I"
    }
  }
  
  "Convirtiendo el 2 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(2)
      result mustBe "II"
    }
  }
  
  "Convirtiendo el 3 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(3)
      result mustBe "III"
    }
  }
  
  "Convirtiendo el 4 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(4)
      result mustBe "IV"
    }
  }
  
  "Convirtiendo el 5 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(5)
      result mustBe "V"
    }
  }
  
  "Convirtiendo el 6 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(6)
      result mustBe "VI"
    }
  }
  
  "Convirtiendo el 7 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(7)
      result mustBe "VII"
    }
  }
  
  "Convirtiendo el 8 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(8)
      result mustBe "VIII"
    }
  }
  
  "Convirtiendo el 9 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(9)
      result mustBe "IX"
    }
  }
  
  "Convirtiendo el 10 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(10)
      result mustBe "X"
    }
  }
  
  "Convirtiendo el 15 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(15)
      result mustBe "XV"
    }
  }
  
  "Convirtiendo el 20 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(20)
      result mustBe "XX"
    }
  }
  
  "Convirtiendo el 28 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(28)
      result mustBe "XXVIII"
    }
  }
  
  "Convirtiendo el 30 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(30)
      result mustBe "XXX"
    }
  }
  
  "Convirtiendo el 31 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(31)
      result mustBe "XXXI"
    }
  }
  
  "Convirtiendo el 40 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(40)
      result mustBe "XL"
    }
  }
  
  "Convirtiendo el 44 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(44)
      result mustBe "XLIV"
    }
  }
  
  "Convirtiendo el 50 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(50)
      result mustBe "L"
    }
  }
  
  "Convirtiendo el 55 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(55)
      result mustBe "LV"
    }
  }
  
  "Convirtiendo el 60 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(60)
      result mustBe "LX"
    }
  }
  
  "Convirtiendo el 66 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(66)
      result mustBe "LXVI"
    }
  }
  
  "Convirtiendo el 70 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(70)
      result mustBe "LXX"
    }
  }
  
  "Convirtiendo el 72 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(72)
      result mustBe "LXXII"
    }
  }
  
  "Convirtiendo el 80 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(80)
      result mustBe "LXXX"
    }
  }
  
  "Convirtiendo el 88 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(88)
      result mustBe "LXXXVIII"
    }
  }
  
  "Convirtiendo el 90 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(90)
      result mustBe "XC"
    }
  }
  
  "Convirtiendo el 99 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(99)
      result mustBe "XCIX"
    }
  }
  
  "Convirtiendo el 100 a romano" should {
    "should be valid" in {
      val result = controller.decToRoman(100)
      result mustBe "C"
    }
  }
  
  "Saludando" should {
    "should be valid" in {
      val result = controller.hello
      result mustBe "Hola mundo"
    }
  }
  
  //----- Aui terminan las pruebas del convertidor romano
  
  
  
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

  // Pruebas para ver que los servicios responden de manera exitosa
  "HomeController" should {
    "Servicio CodeBreaker exitoso" in {
      controller.changeSecretCodeService("1234").apply(FakeRequest(GET, "/changeSecret/1234"))
      val result = controller.codeBreakerService("1234").apply(FakeRequest(GET, "/codebreaker/1234"))

      status(result) mustBe OK
      contentType(result) mustBe Some("application/json")
      contentAsString(result) must include ("""{"status":"Ok","message":"Resultado es: XXXX"}""")
      
    }
  }
  
  "HomeController GET" should {
    "Servicio index exitoso" in {
      val home = controller.index().apply(FakeRequest(GET, "/"))
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Welcome to Play")
    }
  }

  
  //------ Aqui terminan las pruebas del CodeBreaker

}
