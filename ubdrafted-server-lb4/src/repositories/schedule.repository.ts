import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {DraftDsDataSource} from '../datasources';
import {Schedule, ScheduleRelations} from '../models';

export class ScheduleRepository extends DefaultCrudRepository<
  Schedule,
  typeof Schedule.prototype.id,
  ScheduleRelations
> {
  constructor(
    @inject('datasources.draftDS') dataSource: DraftDsDataSource,
  ) {
    super(Schedule, dataSource);
  }
}
