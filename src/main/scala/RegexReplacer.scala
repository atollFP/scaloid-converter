package scaloid.converter

import scala.util.matching.Regex._

object RegexReplacer {

  val imports = """(import [a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+\n)+""".r
  val toSActivity = """extends Activity""".r  

  val shortenMeth = """.*def\s+([a-zA-Z0-9]+)=?[^\{]*""".r


  def apply(input: String) =  {
    var inp = input

    val is = imports.findFirstIn(inp).toList.lastOption
    def addM(m:Match) =
      is.map(_ + "import org.scaloid.common._")
    inp = imports.replaceSomeIn(inp, addM)

    inp = toSActivity.replaceAllIn(inp, "extends SActivity")

    def shM(m:Match) = {
      m.group(1) match {
        case "onCreate" | "onResume" => Some("  def " +m.group(1) + " ")
        case _ => None
      }
    }

    inp = shortenMeth.replaceSomeIn(inp, shM)   

    inp
  }

}
