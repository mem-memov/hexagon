package net.mem_memov.hexagon.storage_bingjvm

import net.mem_memov.bingjvm.Entry as BingJvmEntry
import net.mem_memov.hexagon.Entry as HexagonEntry

case class Entry(underlying: BingJvmEntry) extends HexagonEntry
