package net.coacoas.scala

/**
 * Common functions that I use all over the place. 
 */
object Common {
  def ??? = sys.error("Not implemented yet")

 /**
   * Returns a tuple with the time elapsed for calling the parameter f (in nanoseconds)
   * and the return value of f.
   *
   * @param f
   * @return
   */
   def time[T](f: => T): (Long, T) = {
    val start = System.nanoTime()
    val result = f
    val end = System.nanoTime()
    (end - start, result)
  }

  /**
   * Allows a side-effecting function to be paired with any value. 
   * This will run the side-effecting function, and return the 
   * value from the original.  
   */
   implicit def anyWithSideEffects[T](any: T) = new {
    def ~(fn: T => Unit) = {
      fn(any)
      any
    }
  }
}

object Groovy { 
  class GroovyLike[T](val opt: Option[T]) { 
    def ?[U](f: T => U): GroovyLike[U] = new GroovyLike(opt.map(f))
    def ?|(f: => T): T = opt.getOrElse(f)
  }

  implicit def optToGroovyLike[T](o: Option[T]): GroovyLike[T] = new GroovyLike(o)
}