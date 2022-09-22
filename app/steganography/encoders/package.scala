package steganography

import steganography.methods.LSB


package object encoders {
  implicit val lsbEncoder = new Encoder[LSB] {
    override def encode(image: Seq[Byte], string: String, t: LSB): (Array[Byte], LSB) =
      ("".getBytes(), LSB("", Seq(""), 2))
  }
}
