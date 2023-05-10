import {Entity, hasMany, model, property} from '@loopback/repository';
import {Pick, PickWithRelations} from './pick.model';
@model()
export class Team extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  id?: number;

  @property({
    type: 'string',
    required: true,
  })
  name: string;

  @property({
    type: 'string',
    required: true,
  })
  city: string;

  @property({
    type: 'string',
    required: true,
  })
  state: string;

  @hasMany(() => Pick)
  picks?: Pick[]

  constructor(data?: Partial<Team>) {
    super(data);
  }
}

export interface TeamRelations {
  // describe navigational properties here
  picks?: PickWithRelations;
}

export type TeamWithRelations = Team & TeamRelations;
