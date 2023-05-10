import {Entity, model, property} from '@loopback/repository';

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
  selection_round: number;

  @property({
    type: 'number',
    required: true,
  })
  selection_number: number;

  @property({
    type: 'number',
    required: true,
  })
  selection_year: number;

  @property({
    type: 'string',
    required: true,
  })
  conference: string;


  constructor(data?: Partial<Pick>) {
    super(data);
  }
}

export interface PickRelations {
  // describe navigational properties here
}

export type PickWithRelations = Pick & PickRelations;
