package steganography.services

import daos.DAO

trait Service[F[_], E, ID] {
  val dao: DAO[F, E, ID]

  def getAll: F[Seq[E]] = dao.getAll

  def get(id: ID): F[Option[E]] = dao.get(id)

  def create(entity: E): F[ID] = dao.create(entity)

  def update(entity: E): F[Int] = dao.update(entity)

  def delete(id: ID): F[Int] = dao.delete(id)
}
