package zio.crypto

import zio.Chunk

import java.util.Base64
import scala.util.Try

private[crypto] object ByteHelpers {
  def toB64String(decoded: Chunk[Byte]): String = Base64.getEncoder.encodeToString(decoded.toArray)

  def fromB64String(encoded: String): Option[Chunk[Byte]] =
    Try(Base64.getDecoder.decode(encoded)).toOption.map(Chunk.fromArray)
}
