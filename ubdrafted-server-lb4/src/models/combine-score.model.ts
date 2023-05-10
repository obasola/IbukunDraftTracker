import {Entity, belongsTo, model, property} from '@loopback/repository';
import {Player} from './player.model';

@model()
export class CombineScore extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  id?: number;

  @property({
    type: 'number',
  })
  fortyTime?: number;

  @property({
    type: 'number',
  })
  tenYardSplit?: number;

  @property({
    type: 'number',
  })
  twentyYardShuffle?: number;

  @property({
    type: 'number',
  })
  threeCone?: number;

  @property({
    type: 'number',
  })
  verticalLeap?: number;

  @property({
    type: 'number',
  })
  broadJump?: number;

  @belongsTo(() => Player)
  playerId: number;

  constructor(data?: Partial<CombineScore>) {
    super(data);
  }
}

export interface CombineScoreRelations {
  // describe navigational properties here
}

export type CombineScoreWithRelations = CombineScore & CombineScoreRelations;
