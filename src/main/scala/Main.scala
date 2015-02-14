package scaloid.converter

import ammonite.all._

object Main extends App {

  //replace the file at the path by the converted file
  def replace(f:Path) = write.over(f, RegexReplacer(read(f)))


  val wd = processWorkingDir/up/"sc"
  val (source, dest) = (wd/args(0), wd/args(1))
  rm! dest
  cp(source, dest)

  var i = 0

  //list recursively all the file inside the dest directory, then filter the scala files, then replace them and increment the file counter
  ls.rec! dest |? (_.ext == "scala") | {i += 1; replace(_);}

  println(i + " Scala Files converted to Scaloid")
  

}
