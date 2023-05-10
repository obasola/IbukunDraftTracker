import {Entity, belongsTo, hasMany, model, property} from '@loopback/repository';
import {CombineScore} from './combine-score.model';
import {Pick, PickWithRelations} from './pick.model';

@model()
export class Player extends Entity {
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
  firstName: string;

  @property({
    type: 'string',
    required: true,
  })
  lastName: string;

  @property({
    type: 'number',
  })
  age?: number;

  @property({
    type: 'number',
  })
  height?: number;

  @property({
    type: 'number',
  })
  weight?: number;

  @property({
    type: 'number',
  })
  handSize?: number;

  @property({
    type: 'number',
  })
  armLength?: number;

  @property({
    type: 'string',
  })
  homeCity?: string;

  @property({
    type: 'string',
  })
  homeState?: string;

  @property({
    type: 'string',
  })
  university?: string;

  @property({
    type: 'string',
    required: true,
  })
  position: string;

  @belongsTo(() => Pick)
  pickId?: number;

  @hasMany(() => CombineScore)
  combineScores?: CombineScore[];

  constructor(data?: Partial<Player>) {
    super(data);
  }
}

export interface PlayerRelations {
  // describe navigational properties herenode .
  pickId?: PickWithRelations;
}

export type PlayerWithRelations = Player & PlayerRelations;
