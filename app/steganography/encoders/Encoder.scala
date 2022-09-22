package steganography.encoders

import steganography.methods.SteganoMethod

trait Encoder[T <: SteganoMethod] {
  def encode(image: Seq[Byte], string: String, t: T): (Array[Byte], T)
}
