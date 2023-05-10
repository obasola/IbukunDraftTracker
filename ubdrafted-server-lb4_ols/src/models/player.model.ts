import {Entity, model, property} from '@loopback/repository';

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
  first_name: string;

  @property({
    type: 'string',
    required: true,
  })
  last_name: string;

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
  hand_size?: number;

  @property({
    type: 'number',
  })
  arm_length?: number;

  @property({
    type: 'string',
    default: home_state,
  })
  home_city?: string;

  @property({
    type: 'string',
  })
  home_state?: string;

  @property({
    type: 'string',
  })
  university?: string;

  @property({
    type: 'number',
  })
  selection_id?: number;

  @property({
    type: 'string',
    required: true,
  })
  position: string;


  constructor(data?: Partial<Player>) {
    super(data);
  }
}

export interface PlayerRelations {
  // describe navigational properties here
}

export type PlayerWithRelations = Player & PlayerRelations;
