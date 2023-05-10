import {
  repository,
} from '@loopback/repository';
import {
  get,
  getModelSchemaRef,
  param,
} from '@loopback/rest';
import {
  CombineScore,
} from '../models';
import {Player} from './../models/player.model';

import {CombineScoreRepository} from '../repositories';

export class CombineScorePlayerController {
  constructor(
    @repository(CombineScoreRepository)
    public combineScoreRepository: CombineScoreRepository,
  ) { }

  @get('/combine-scores/{id}/player', {
    responses: {
      '200': {
        description: 'Player belonging to CombineScore',
        content: {
          'application/json': {
            schema: getModelSchemaRef(Player),
          },
        },
      },
    },
  })
  async getPlayer(
    @param.path.number('id') id: typeof CombineScore.prototype.id,
  ): Promise<Player> {
    return this.combineScoreRepository.player(id);
  }
}
