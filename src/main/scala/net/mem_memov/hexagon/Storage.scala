package net.mem_memov.hexagon

trait Storage[E]:

  val start: Entry

  sealed trait Append
  case class Appended(destination: Entry) extends Append
  object NotAppended extends Append
  object NotAppendedContentTooBig extends Append

  def append(content: E): Append

  sealed trait Update
  object Updated extends Update
  object NotUpdatedContentTooBig extends Update
  object NotUpdatedDestinationTooBig extends Update
  object NotUpdated extends Update

  def update(destination: E, content: E): Update

  sealed trait Read
  case class ReadResult(content: E) extends Read
  object NotRead extends Read

  def read(source: E): Read

  def foreach(f: E => Unit): Unit
