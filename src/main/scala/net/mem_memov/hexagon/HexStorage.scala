package net.mem_memov.hexagon

import cats.Id
import cats.effect.IO

class HexStorage(
  private val one: Storage[Id, Entry],
  private val two: Storage[Id, Entry],
  private val three: Storage[Id, Entry],
  private val four: Storage[Id, Entry],
  private val five: Storage[Id, Entry],
  private val six: Storage[Id, Entry],
) extends Storage[IO, HexEntry]:

  override val start: IO[HexEntry] = ???

  override def append(content: HexEntry): IO[Append] = ???

  override def update(destination: HexEntry, content: HexEntry): IO[Update] = ???

  override def read(source: HexEntry): IO[Read] = ???

  override def foreach(f: HexEntry => Unit): Unit = ???
