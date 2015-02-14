package scaloid.converter

import scala.util.matching.Regex._

object RegexReplacer {

  val imports = """(import [a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+\n)+""".r
  val toSActivity = """extends Activity""".r  

  val shortenMeth = """.*def\s+([a-zA-Z0-9]+)=?[^\{]*""".r


  def apply(input: String) =  {

    var inp = input

    var b = true    
    //add a string at the end of the match if it's the first block of imports
    //We don't want to mess with inner imports
    def addM(m:Match) = {
      if (b) {
        b = false
        Some(m.toString + "import org.scaloid.common._")
      } else
        None     
    }

    //replace imports based on addM which only add the import to the first import block
    inp = imports.replaceSomeIn(inp, addM)

    //replace Activity by SActivity
    inp = toSActivity.replaceFirstIn(inp, "extends SActivity")

    //"shorten" the methods onlyif their name fit
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
