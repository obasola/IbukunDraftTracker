import {inject, lifeCycleObserver, LifeCycleObserver} from '@loopback/core';
import {juggler} from '@loopback/repository';

const config = {
  name: 'draftDS',
  connector: 'mysql',
  url: 'mysql://root:Password2023!@localhost/MyNFL',
  host: 'localhost',
  port: 3306,
  user: 'root',
  password: 'Password2023!',
  database: 'MyNFL'
};

// Observe application's life cycle to disconnect the datasource when
// application is stopped. This allows the application to be shut down
// gracefully. The `stop()` method is inherited from `juggler.DataSource`.
// Learn more at https://loopback.io/doc/en/lb4/Life-cycle.html
@lifeCycleObserver('datasource')
export class DraftDsDataSource extends juggler.DataSource
  implements LifeCycleObserver {
  static dataSourceName = 'draftDS';
  static readonly defaultConfig = config;

  constructor(
    @inject('datasources.config.draftDS', {optional: true})
    dsConfig: object = config,
  ) {
    super(dsConfig);
  }
}
