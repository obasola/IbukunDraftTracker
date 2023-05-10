<template>
  <q-page>
    <h2>Draft Players</h2>
  </q-page>
</template>

<script setup lang="ts">
import { reactive } from 'vue';
import PlayerDataService from 'src/services/PlayerDataService';

class Player {
  id: number = 0;
  first_name: string = '';
  last_name: string = '';
  age: number = 0;
  height: number = '0;
  weight: number = 0;
  hand_size: number = 0;
  arm_length: number = 0;
  home_city: string = '';
  home_state: string = '';
  university: string = '';
  selection_id: number = 0;
  position: string = '';
}
let submitted: boolean = false;
const player: Player = initializeInstance();

initializeInstance()  {
  return player = reactive({
  id: 0;
  first_name: '';
  last_name: '';
  age: number;
  height: 0.0;
  weight: 0.0;
  hand_size: 0.0;
  arm_length: 0.0;
  home_city: '';
  home_state: '';
  university: '';
  selection_id: 0;
  position: '';
})

}
savePlayer() {
      var data = {
        id: player.id;
        first_name: player.first_name;
        last_name: player.last_name;
        age: player.age;
        height: player.height;
        weight: player.weight;
        hand_size: player.hand_size;
        arm_length: player.arm_length;
        home_city: player.home_city;
        home_state: player.home_state;
        university: player.university;
        selection_id: player.selection_id;
        position: player.position;
      };

      PlayerDataService.create(data)
        .then(response => {
          player.id = response.data.id;
          console.log(response.data);
          submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },

    newPlayer() {
      submitted = false;
      player = {};
    }

function initializeInstance() {
throw new Error('Function not implemented.');
}

function savePlayer() {
throw new Error('Function not implemented.');
}

function newPlayer() {
throw new Error('Function not implemented.');
}
</script>
