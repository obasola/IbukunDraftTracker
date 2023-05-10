import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {DraftDsDataSource} from '../datasources';
import {Pick, PickRelations} from '../models';

export class PickRepository extends DefaultCrudRepository<
  Pick,
  typeof Pick.prototype.id,
  PickRelations
> {
  constructor(
    @inject('datasources.draftDS') dataSource: DraftDsDataSource,
  ) {
    super(Pick, dataSource);
  }
}
