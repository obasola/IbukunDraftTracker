<template>
  <q-page>
    <h2>Team Component Page</h2>

    <q-btn color="primary" icon="check" label="Edit" @click="edit" />
  </q-page>
</template>

<script setup lang="ts">
import TeamDataService from '../../services/TeamDataService';
import { useRouter } from 'vue-router';
import { ref } from 'vue';

const router = useRouter();

const count = ref<number>(0);
const data = ref<Team>({});

function edit() {
  router.push('/editTeam');
}
function increment() {
  count.value++;
}

const service: TeamDataService = new TeamDataService();
class Team {
  id = 0;
  name = '';
  city = '';
  state = '';
  conference = '';
}
let submitted = false;
const team = ref<Team>(new Team());
function saveTeam() {
  data.value = {
    id: team.value.id,
    name: team.value.name,
    city: team.value.city,
    state: team.value.state,
    conference: team.value.conference,
  };

  service
    .create(data)
    .then((response) => {
      team.value = response.data;

      alert('response = ' + response);
      submitted = true;
    })
    .catch((e) => {
      console.log(e);
    });
}
</script>
