package net.coacoas.scala


class GroovyLike[T](val opt: Option[T]) { 
  def ?[U](f: T => U): GroovyLike[U] = new GroovyLike(opt.map(f))
  def ?|(f: => T): T = opt.getOrElse(f)
}

object GroovyLike {
  implicit def optToGroovyLike[T](o: Option[T]): GroovyLike[T] = new GroovyLike(o)
}