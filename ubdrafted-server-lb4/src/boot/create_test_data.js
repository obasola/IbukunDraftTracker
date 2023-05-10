module.exports = function(app) {
  app.dataSources.draftDS.automigrate('teams', function(err) {
    if (err) throw err;

    app.models.team.create([{
      name: 'Cleveland Browns',
      city: 'Cleveland',
      state: 'Ohio',
      conference: 'AFC Central'
    }, {
      name: 'Atlanta Falcons',
      city: 'Atlanta',
      state: 'Georgia',
      conference: 'NFC South'
    }, {
      name: 'Cincinnati Bengals',
      city: 'Cincinnati',
      state: 'Ohio',
      conference: 'AFC Central'
    }, ], function(err, teams) {
      if (err) throw err;

      console.log('Models created: \n', teams);
    });
  });
};