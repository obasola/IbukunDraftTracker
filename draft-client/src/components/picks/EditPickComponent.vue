<template>
  <q-page>
    <h2>Edit Pick</h2>
    <div>
      <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-md">
        <q-input
          v-model="pickInstance.selectionYear"
          label="Draft Year *"
          hint="The year the draft pick is available"
        />

        <q-select
          filled
          v-model="pickInstance.teamId"
          :options="teamOptionsList"
          option-label="teamName"
          option-value="id"
          label="Single"
          style="width: 250px"
        />
        <q-input
          v-model="pickInstance.selectionRound"
          type="text"
          label="Round"
        />

        <q-input
          v-model="pickInstance.selectionNumber"
          type="text"
          label="Pick Number"
        />

        <q-input
          v-model="pickInstance.selectionFrom"
          type="text"
          label="Pick Received From"
        />

        <q-input
          v-model="pickInstance.selectionSentTo"
          type="text"
          label="Pick Sent To"
        />
        <q-input
          v-model="pickInstance.combineScore"
          type="number"
          label="Combine Score"
        />
        <div>
          <q-btn
            v-on:click="submit"
            label="Submit"
            type="submit"
            color="primary"
          />
          <q-btn
            v-on:click="reset"
            label="Reset"
            type="reset"
            color="primary"
            flat
            class="q-ml-sm"
          />
        </div>
      </q-form>
    </div>
  </q-page>
</template>

<script setup lang="ts">
import axios from 'axios';
import Pick from 'src/domain/domainInterfaces';

import { reactive, ref } from 'vue';
import { Team } from '../../../../draft-server-lb4/src/models/team.model';
import PickDataService from 'src/services/PickDataService';

const teamOptionsList = [
  {
    id: 12,
    teamName: 'Arizona Cardinals',
  },
  {
    id: 13,
    teamName: 'Atlanta Falcons',
  },
  {
    id: 15,
    teamName: 'Baltimore Ravens',
  },
  {
    id: 16,
    teamName: 'Cincinnati Bengals',
  },
  {
    id: 14,
    teamName: 'Cleveland Browns',
  },
  {
    id: 17,
    teamName: 'Detroit Lions',
  },
  {
    id: 11,
    teamName: 'Kansas City Chiefs',
  },
];

const pickService = new PickDataService();
const picks = ref<Pick>([]);

const pickInstance = reactive({
  id: 0,
  teamId: 0,
  selectionRound: 0,
  selectionNumber: 0,
  selectionYear: '',
  selectionFrom: '',
  selectionSentTo: '',
  combineScore: 0,
});

function submit() {
  alert('Submit clicked');
  pickService.create(pickInstance);
}
function reset() {
  alert('Reset clicked');
}

async function getData() {
  //alert('getting data');

  await axios
    .get('http://localhost:3000/picks')
    .then((response) => {
      let records: Array<Team> = response.data;
      return records;
    })
    .catch((e) => {
      alert('error: ' + e);
    });
}
</script>
