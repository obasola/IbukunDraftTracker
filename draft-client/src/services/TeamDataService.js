import axios from '../http-common';
class TeamDataService {

  getAll() {
    return axios.get('/teams');
  }

  get(id) {
    return axios.get(`/team/${id}`);
  }

  async create(data) {

    axios
      .post('http://localhost:3000/teams', data)
      .then((response) =>
        console.log('data = ' + response.data).catch((error) => {
        console.error('There was an error!', error);
        })
      )
      .catch((error) => {
        console.log('There was an error!', error);
        console.log('Error: ' + error.message);
      });

     // body: JSON.stringify(data) */
    /*  body: {
        name:   data.name,
        city:   data.city,
        state: data.state,
        conference: data.conference
      }*/
   // })


    // data = await response.json();
  }

  update(id, data) {
    return axios.put(`/teams/${id}`, data);
  }

  delete(id) {
    return axios.delete(`/teams/${id}`);
  }

  deleteAll() {
    return axios.delete('/teams');
  }

  findByName(name) {
    return axios.get(`/teams?name=${name}`);
  }
}
export default TeamDataService;
