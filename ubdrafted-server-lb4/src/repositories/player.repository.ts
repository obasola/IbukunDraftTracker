import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {DraftDsDataSource} from '../datasources';
import {Player, PlayerRelations} from '../models/player.model';

export class PlayerRepository extends DefaultCrudRepository<
  Player,
  typeof Player.prototype.id,
  PlayerRelations
> {
  constructor(
    @inject('datasources.draftDS') dataSource: DraftDsDataSource,
  ) {
    super(Player, dataSource);
  }
}
