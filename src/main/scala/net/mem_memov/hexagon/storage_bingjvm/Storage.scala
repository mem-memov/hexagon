package net.mem_memov.hexagon.storage_bingjvm

import net.mem_memov.bingjvm
import net.mem_memov.hexagon.{Storage as HexagonStorage, Entry as HexagonEntry}
import cats.Id

class Storage(
  private val bingjvmInventory: bingjvm.Inventory[bingjvm.Entry]
) extends HexagonStorage[Id, Entry]:

  override val start: Id[Entry] =
    Id(Entry(bingjvmInventory.start))

  override def append(content: Entry): Id[Append] =
    content match
      case Entry(bingjvmContent) =>
        bingjvmInventory.append(bingjvmContent) match
          case bingjvmInventory.Appended(destination: bingjvm.Entry) =>
            Id(Appended(Entry(destination)))
          case bingjvmInventory.NotAppended =>
            Id(NotAppended)
          case bingjvmInventory.NotAppendedContentTooBig =>
            Id(NotAppendedContentTooBig)

  override def update(destination: Entry, content: Entry): Id[Update] =
    destination match
      case Entry(bingjvmDestination) =>
        content match
          case Entry(bingjvmContent) =>
            bingjvmInventory.update(bingjvmDestination, bingjvmContent) match
              case bingjvmInventory.Updated =>
                Id(Updated)
              case bingjvmInventory.NotUpdatedContentTooBig =>
                Id(NotUpdatedContentTooBig)
              case bingjvmInventory.NotUpdatedDestinationTooBig =>
                Id(NotUpdatedDestinationTooBig)
              case bingjvmInventory.NotUpdated =>
                Id(NotUpdated)

  override def read(source: Entry): Id[Read] =
    source match
      case Entry(bingjvmSource) =>
        bingjvmInventory.read(bingjvmSource) match
          case bingjvmInventory.ReadResult(content) =>
            Id(ReadResult(Entry(content)))
          case bingjvmInventory.NotRead =>
            Id(NotRead)

  override def foreach(f: Entry => Unit): Unit =
    bingjvmInventory.foreach { bingjvmEntry =>
      f(Entry(bingjvmEntry))
    }
