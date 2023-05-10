import http from '../http-common';

class PickDataService {
  getAll() {
    return http.get('/picks');
  }

  get(id) {
    return http.get(`/pick/${id}`);
  }

  create(data) {
    return http.post('/picks', data);
  }

  update(id, data) {
    return http.put(`/picks/${id}`, data);
  }

  delete(id) {
    return http.delete(`/picks/${id}`);
  }

  deleteAll() {
    return http.delete('/picks');
  }

  findByName(name) {
    return http.get(`/picks?name=${name}`);
  }
  async getTeamListDropdown() {
    await axios
      .get('http://localhost:3000/teams')
      .then((response) => {
        picks.value = response.data;

        //alert('data = ' + picks.value);
      })
      .catch((e) => {
        alert('error: ' + e);
      });
  }
}
export default PickDataService;
