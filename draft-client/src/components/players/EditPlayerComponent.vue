<template>
  <q-page>
    <h2>Edit Player Info</h2>
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

        <q-input
          v-model="playerinstance.conference"
          type="text"
          label="Conference"
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
import PlayerDataService from 'src/services/PlayerDataService';

const playerService = new PlayerDataService();
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
// const submitted = ref<boolean>(true);

function submit() {
  alert('Submit clicked');
  playerService.create(playerinstance);
}
function reset() {
  alert('Reset clicked');
}
</script>
