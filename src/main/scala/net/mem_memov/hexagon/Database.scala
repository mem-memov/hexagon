package net.mem_memov.hexagon

import net.mem_memov.bingjvm.Entry

class Database:

  def create(): Entry = ???

  def has(source: Entry): Boolean = ???

  def readSources(target: Entry): List[Entry] = ???

  def readTargets(source: Entry): List[Entry] = ???

  def setReference(source: Entry, reference: Entry): Unit = ???

  def getReference(source: Entry): (Entry, Entry) = ???

  def connect(source: Entry, target: Entry): Unit = ???

  def disconnect(source: Entry, target: Entry): Unit = ???

  def delete(source: Entry): Unit = ???


