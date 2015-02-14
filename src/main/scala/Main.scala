package scaloid.converter

import ammonite.all._

object Main extends App {

  def replace(f:Path) = write.over(f, RegexReplacer(read(f)))
//  def editRec(f:File) = ()

  val wd = processWorkingDir/up/"sc"
  val (source, dest) = (wd/args(0), wd/args(1))
  rm! dest
  cp(source, dest)

  var i = 0
  ls.rec! dest |? (_.ext == "scala") | {i += 1; replace(_);}
  println(i + " Scala Files converted to Scaloid")
  

}
