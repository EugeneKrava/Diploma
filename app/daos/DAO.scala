package daos

/**
 * Base DAO for base entity, with generalized Monad. Provide CRUD actions.
 *
 * @tparam F  - monad type
 * @tparam E  - entity type
 * @tparam ID - id type
 */
trait DAO[F[_], E, ID] {
  def getAll: F[Seq[E]]

  def get(id: ID): F[Option[E]]

  def create(entity: E): F[ID]

  def update(entity: E): F[Int]

  def delete(id: ID): F[Int]
}
