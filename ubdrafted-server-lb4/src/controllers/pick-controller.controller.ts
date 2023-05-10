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
import {Pick} from '../models';
import {PickRepository} from '../repositories';

export class PickControllerController {
  constructor(
    @repository(PickRepository)
    public pickRepository : PickRepository,
  ) {}

  @post('/picks')
  @response(200, {
    description: 'Pick model instance',
    content: {'application/json': {schema: getModelSchemaRef(Pick)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Pick, {
            title: 'NewPick',
            exclude: ['id'],
          }),
        },
      },
    })
    pick: Omit<Pick, 'id'>,
  ): Promise<Pick> {
    return this.pickRepository.create(pick);
  }

  @get('/picks/count')
  @response(200, {
    description: 'Pick model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(Pick) where?: Where<Pick>,
  ): Promise<Count> {
    return this.pickRepository.count(where);
  }

  @get('/picks')
  @response(200, {
    description: 'Array of Pick model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(Pick, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(Pick) filter?: Filter<Pick>,
  ): Promise<Pick[]> {
    return this.pickRepository.find(filter);
  }

  @patch('/picks')
  @response(200, {
    description: 'Pick PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Pick, {partial: true}),
        },
      },
    })
    pick: Pick,
    @param.where(Pick) where?: Where<Pick>,
  ): Promise<Count> {
    return this.pickRepository.updateAll(pick, where);
  }

  @get('/picks/{id}')
  @response(200, {
    description: 'Pick model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(Pick, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.number('id') id: number,
    @param.filter(Pick, {exclude: 'where'}) filter?: FilterExcludingWhere<Pick>
  ): Promise<Pick> {
    return this.pickRepository.findById(id, filter);
  }

  @patch('/picks/{id}')
  @response(204, {
    description: 'Pick PATCH success',
  })
  async updateById(
    @param.path.number('id') id: number,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Pick, {partial: true}),
        },
      },
    })
    pick: Pick,
  ): Promise<void> {
    await this.pickRepository.updateById(id, pick);
  }

  @put('/picks/{id}')
  @response(204, {
    description: 'Pick PUT success',
  })
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() pick: Pick,
  ): Promise<void> {
    await this.pickRepository.replaceById(id, pick);
  }

  @del('/picks/{id}')
  @response(204, {
    description: 'Pick DELETE success',
  })
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.pickRepository.deleteById(id);
  }
}
