<template>
  <q-page>
    <h2>{{ param }}</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form class="q-gutter-md">
        <q-select
          filled
          v-model="playerinstance.teamId"
          :options="teamOptionsList"
          option-label="teamName"
          option-value="id"
          label="Team"
          style="width: 250px"
        />
        <q-input
          v-model="playerinstance.name"
          label="Player name *"
          hint="The name of the Player"
        />
        <q-input v-model="playerinstance.city" type="text" label="City" />

        <q-input v-model="playerinstance.state" type="text" label="State" />

        <q-select
            filled
            v-model="playerinstance.conference"
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
import { reactive, ref } from 'vue';
import { useRoute } from 'vue-router'
import PlayerDataService from 'src/services/PlayerDataService';

const route = useRoute();
const param = ref(route.params.param);


console.log('title = ' + route.params.param);
const playerService = new PlayerDataService();
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
const playerinstance = reactive({
  id: 0,
  teamId: 0,
  name: '',
  city: '',
  state: '',
  conference: '',
});

if (param.value === 'add') {
  param.value  = 'New Player Info';
} else {
  param.value = 'Edit Player Info';
}
// const submitted = ref<boolean>(true);

function submit() {
  alert('Submit clicked');
  playerService.create(playerinstance);
}
function reset() {
  alert('Reset clicked');
}
</script>
