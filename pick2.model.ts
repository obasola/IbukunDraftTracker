import {Entity, belongsTo, hasMany, model, property} from '@loopback/repository';
import {Player, PlayerWithRelations} from './player.model';
import {Team} from './team.model';

@model()
export class Pick extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  id?: number;

  @property({
    type: 'number',
    required: true,
  })
  selectionRound: number;

  @property({
    type: 'number',
  })
  selectionNumber: number;

  @property({
    type: 'number',
  })
  selectionYear: number;


@property({
  type: 'string',
  })
  selectionPickFrom?: string;

  @property({
    type: 'string',
  })
  selectionPickTo?: string;

  @property({
  type: 'number',
  })
  combineScore?: number;

  @belongsTo(() => Team)
  teamId?: number; // relation name will default to `team`

  @hasMany(() => Player)
  players?: Player[]

  constructor(data?: Partial<Pick>) {
    super(data);
  }
}

export interface PickRelations {
  // describe navigational properties here
  players?: PlayerWithRelations;
}

export type PickWithRelations = Pick & PickRelations;

