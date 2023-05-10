const path = require('path');

const app = require(path.resolve(__dirname, '../server/server'));
const ds = app.datasources.nfldraftDS;
ds.discoverAndBuildModels('Player', {schema: 'MyNFL'},
    function(err, models) {
  if (err) throw err;

  models.Player.find(function(err, players) {
    if (err) throw err;

    console.log('Found:', players);

    ds.disconnect();
  });
});
