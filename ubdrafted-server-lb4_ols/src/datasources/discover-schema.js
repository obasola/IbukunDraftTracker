const path = require('path');

const app = require(path.resolve(__dirname, '../server/server'));
const ds = app.datasources.nfldraftDS;
ds.discoverSchema('Player', {schema: 'MyNFL'}, function(err,
    schema) {
  if (err) throw err;

  const json = JSON.stringify(schema, null, '  ');
  console.log(json);

  ds.disconnect();
});
