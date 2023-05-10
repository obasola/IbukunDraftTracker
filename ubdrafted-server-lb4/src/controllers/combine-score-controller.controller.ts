import {
  Count,
  CountSchema,
  Filter,
  FilterExcludingWhere,
  repository,
  Where,
} from '@loopback/repository';
import {
  post,
  param,
  get,
  getModelSchemaRef,
  patch,
  put,
  del,
  requestBody,
  response,
} from '@loopback/rest';
import {CombineScore} from '../models';
import {CombineScoreRepository} from '../repositories';

export class CombineScoreControllerController {
  constructor(
    @repository(CombineScoreRepository)
    public combineScoreRepository : CombineScoreRepository,
  ) {}

  @post('/combine-scores')
  @response(200, {
    description: 'CombineScore model instance',
    content: {'application/json': {schema: getModelSchemaRef(CombineScore)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(CombineScore, {
            title: 'NewCombineScore',
            exclude: ['id'],
          }),
        },
      },
    })
    combineScore: Omit<CombineScore, 'id'>,
  ): Promise<CombineScore> {
    return this.combineScoreRepository.create(combineScore);
  }

  @get('/combine-scores/count')
  @response(200, {
    description: 'CombineScore model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(CombineScore) where?: Where<CombineScore>,
  ): Promise<Count> {
    return this.combineScoreRepository.count(where);
  }

  @get('/combine-scores')
  @response(200, {
    description: 'Array of CombineScore model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(CombineScore, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(CombineScore) filter?: Filter<CombineScore>,
  ): Promise<CombineScore[]> {
    return this.combineScoreRepository.find(filter);
  }

  @patch('/combine-scores')
  @response(200, {
    description: 'CombineScore PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(CombineScore, {partial: true}),
        },
      },
    })
    combineScore: CombineScore,
    @param.where(CombineScore) where?: Where<CombineScore>,
  ): Promise<Count> {
    return this.combineScoreRepository.updateAll(combineScore, where);
  }

  @get('/combine-scores/{id}')
  @response(200, {
    description: 'CombineScore model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(CombineScore, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.number('id') id: number,
    @param.filter(CombineScore, {exclude: 'where'}) filter?: FilterExcludingWhere<CombineScore>
  ): Promise<CombineScore> {
    return this.combineScoreRepository.findById(id, filter);
  }

  @patch('/combine-scores/{id}')
  @response(204, {
    description: 'CombineScore PATCH success',
  })
  async updateById(
    @param.path.number('id') id: number,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(CombineScore, {partial: true}),
        },
      },
    })
    combineScore: CombineScore,
  ): Promise<void> {
    await this.combineScoreRepository.updateById(id, combineScore);
  }

  @put('/combine-scores/{id}')
  @response(204, {
    description: 'CombineScore PUT success',
  })
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() combineScore: CombineScore,
  ): Promise<void> {
    await this.combineScoreRepository.replaceById(id, combineScore);
  }

  @del('/combine-scores/{id}')
  @response(204, {
    description: 'CombineScore DELETE success',
  })
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.combineScoreRepository.deleteById(id);
  }
}
