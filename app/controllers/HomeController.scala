package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

// Controlador del aplicativo CodeBreaker
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  
  // Metodo para convertir un numero decimal (1 al 100) a su equivalente romano
  def decToRoman(num: Int): String = {
    num match {
      case 1 => "I" 
      case 2 => "II" 
      case 3 => "III" 
      case 4 => "IV" 
      case 5 => "V" 
      case 6 => "VI" 
      case 7 => "VII" 
      case 8 => "VIII" 
      case 9 => "IX" 
      case 10 => "X" 
      case aux if (aux < 20) => ("X" + decToRoman(num - 10)) 
      case 20 => "XX" 
      case aux if (aux < 30) => "XX" + decToRoman(num - 20) 
      case 30 => "XXX" 
      case aux if (aux < 40)=> "XXX" + decToRoman(num - 30) 
      case 40 => "XL"
      case aux if (aux < 50) => "XL" + decToRoman(num - 40)
      case 50 => "L"
      case aux if (aux < 60) => "L" + decToRoman(num - 50)
      case 60 => "LX" 
      case aux if (aux < 70)=> "LX" + decToRoman(num - 60)
      case 70 => "LXX" 
      case aux if (aux < 80) =>  "LXX" + decToRoman(num - 70)
      case 80 => "LXXX" 
      case aux if (aux < 90) => "LXXX" + decToRoman(num - 80)
      case 90 => "XC" 
      case aux if (aux < 100) => "XC" + decToRoman(num - 90)
      case 100 => "C" 
    }
  }
  
  // Metodo de prueba - NO PRESTARLE ATENCION
  def hello() : String = {
    "Hola mundo"
  }
  
  // Variable que alamcena el numero a adivinar (Numero magico)
  var magicNumber = "3428"
  
  // Metodo CodeBreaker
  def codeBreaker(num: String) :String = {
    var i = 0
    var aux : String = ""
    var resulX  = ""
    var resul_  = ""
    var resul   = "" 
      for (i <- 0 to 3)
      {
        aux = num(i).toString

        if (!magicNumber.contains(aux))
        {
          resul += " ";
        }
        else
        {
          // lo contiene  en la posicion correcta
          if (i == magicNumber.indexOf(aux))
          {
            resulX += "X";
          }else{ // en otra posicion
            resul_ += "_";
          }
        }

      }
      
      return resulX + resul_ + resul 
  }
  
  // Metodo para cambiar el numero magico
  def changeSecretCode(num: String) :String = {
    
    magicNumber = num
    return "Changed!"
  }
  
  // Metodo que expone el servicio de cambio de numero
  def changeSecretCodeService(num: String) = Action {
    val resul = changeSecretCode(num)
    Ok(resul)
  }
  
  // Metodo que expone el servicio de CodeBreaker
  def codeBreakerService(num: String) = Action {
    val resul = codeBreaker(num)
    val jsonAux = Json.obj("status" -> "Ok", "message" -> s"Resultado es: ${resul}")
    Ok(jsonAux)
  }

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
