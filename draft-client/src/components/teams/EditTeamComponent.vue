<template>
  <q-page>
    <h2>Edit Team Data</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="submit" @reset="reset" class="q-gutter-md">

        <q-input v-if="4 " v-model="teamInstance.name" label="Team name *" />
        <q-select v-if="param === 'UPD'"
            filled
            v-model="teamInstance.id"
            :options="teamOptionsList"
            option-label="teamName"
            option-value="id"
            label="Team"
            style="width: 250px"
        />
        <q-input v-model="teamInstance.city" type="text" label="City" />
        <q-input v-model="teamInstance.state" type="text" label="State" />
        <q-select
              filled
              v-model="teamInstance.conference"
              :options="conferenceList"
              option-label="name"
              option-value="value"
              label="Conference"
              style="width: 250px"
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
import TeamEntity from 'src/domain/domainInterfaces';
import Util from 'src/domain/util.js';
import TeamDataService from 'src/services/TeamDataService';
import { reactive, ref } from 'vue';

interface ITeam {
  id: number;
  name: string;
  city: string;
  state: string;
  conference: string;
}
const utils = new Util();
utils.getTeamList();


const teamInstance: ITeam = reactive({
  id: 0,
  name: '',
  city: '',
  state: '',
  conference: '',
});
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
const conferenceList = [
  {
    name: 'AFC East',
    value: 'AFC East'
  },
  {
    name: 'AFC West',
    value: 'AFC West'
  },
  {
    name: 'AFC North',
    value: 'AFC North'
  },
  {
    name: 'AFC South',
    value: 'AFC South'
  },
  {
    name: 'NFC East',
    value: 'NFC East'
  },
  {
    name: 'NFC West',
    value: 'NFC West'
  },
  {
    name: 'NFC North',
    value: 'NFC North'
  },
  {
    name: 'NFC South',
    value: 'NFC South'
  },
];

const param = ref<string>('UPD');
const service = new TeamDataService();

const submitted = ref<boolean>(true);

async function submit() {
  await service
    .create(teamInstance)
    .then((response) => {
      console.log(response);
      submitted.value = true;
    })
    .catch((e) => {
      console.log(e);
    });
}
function reset() {
  alert('Reset clicked');
}
</script>
