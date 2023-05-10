import {Getter, inject} from '@loopback/core';
import {BelongsToAccessor, DefaultCrudRepository, repository} from '@loopback/repository';
import {DraftDsDataSource} from '../datasources';
import {CombineScore, CombineScoreRelations} from '../models';
import {Player} from '../models/player.model';
import {PlayerRepository} from './player.repository';
export class CombineScoreRepository extends DefaultCrudRepository<
  CombineScore,
  typeof CombineScore.prototype.id,
  CombineScoreRelations
> {

  public readonly player: BelongsToAccessor<Player, typeof CombineScore.prototype.id>;

  constructor(
    @inject('datasources.draftDS') dataSource: DraftDsDataSource, @repository.getter('PlayerRepository') protected playerRepositoryGetter: Getter<PlayerRepository>,
  ) {
    super(CombineScore, dataSource);
    this.player = this.createBelongsToAccessorFor('player', playerRepositoryGetter,);
    this.registerInclusionResolver('player', this.player.inclusionResolver);
  }
}
