package net.mem_memov.hexagon.storage_bingjvm

import net.mem_memov.bingjvm
import net.mem_memov.hexagon.{Storage as HexagonStorage, Entry as HexagonEntry}

class Storage(
  private val bingjvmInventory: bingjvm.Inventory[bingjvm.Entry]
) extends HexagonStorage[Entry]:

  override val start: Entry =
    Entry(bingjvmInventory.start)

  override def append(content: Entry): Append =
    content match
      case Entry(bingjvmContent) =>
        bingjvmInventory.append(bingjvmContent) match
          case bingjvmInventory.Appended(destination: bingjvm.Entry) =>
            Appended(Entry(destination))
          case bingjvmInventory.NotAppended =>
            NotAppended
          case bingjvmInventory.NotAppendedContentTooBig =>
            NotAppendedContentTooBig

  override def update(destination: Entry, content: Entry): Update =
    destination match
      case Entry(bingjvmDestination) =>
        content match
          case Entry(bingjvmContent) =>
            bingjvmInventory.update(bingjvmDestination, bingjvmContent) match
              case bingjvmInventory.Updated =>
                Updated
              case bingjvmInventory.NotUpdatedContentTooBig =>
                NotUpdatedContentTooBig
              case bingjvmInventory.NotUpdatedDestinationTooBig =>
                NotUpdatedDestinationTooBig
              case bingjvmInventory.NotUpdated =>
                NotUpdated

  override def read(source: Entry): Read =
    source match
      case Entry(bingjvmSource) =>
        bingjvmInventory.read(bingjvmSource) match
          case bingjvmInventory.ReadResult(content) =>
            ReadResult(Entry(content))
          case bingjvmInventory.NotRead =>
            NotRead

  override def foreach(f: Entry => Unit): Unit =
    bingjvmInventory.foreach { bingjvmEntry =>
      f(Entry(bingjvmEntry))
    }
