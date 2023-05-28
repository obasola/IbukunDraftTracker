import {Entity, model, property} from '@loopback/repository';

@model()
export class Schedule extends Entity {
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
  teamId: number;

  @property({
    type: 'number',
    required: true,
  })
  opponentId: number;

  @property({
    type: 'string',
    required: true,
  })
  scheduleWeek: string;

  @property({
    type: 'date',
  })
  gameDate?: string;

  @property({
    type: 'string',
  })
  gameCity?: string;

  @property({
    type: 'string',
  })
  gameStateProvince?: string;

  @property({
    type: 'string',
    required: true,
  })
  gameCountry: string;

  @property({
    type: 'string',
  })
  gameLocation?: string;

  @property({
    type: 'string',
    required: true,
  })
  opponentConference: string;

  @property({
    type: 'string',
    required: true,
  })
  opponentDivision: string;

  @property({
    type: 'string',
    required: true,
  })
  wonLostFlag: string;

  @property({
    type: 'string',
    required: true,
  })
  homeOrAway: string;


  constructor(data?: Partial<Schedule>) {
    super(data);
  }
}

export interface ScheduleRelations {
  // describe navigational properties here
}

export type ScheduleWithRelations = Schedule & ScheduleRelations;
