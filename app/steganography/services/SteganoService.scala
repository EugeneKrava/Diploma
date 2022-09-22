package steganography.services

import steganography.encoders.Encoder
import steganography.methods.SteganoMethod

object SteganoService {
  def encode[T <: SteganoMethod](image: Seq[Byte], message: String, method: T)(implicit e: Encoder[T]) =
    e.encode(image, message, method)

}
