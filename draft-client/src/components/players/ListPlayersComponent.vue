<template>
  <q-page>
    <h2>Player List</h2>
    <div style="float: right; margin-right: 0.7em">
      <q-btn
        v-on:click="getData()"
        label="Refresh"
        type="submit"
        color="primary"
      />
      <q-btn
        @click="newPlayer()"
        label="Add Player"
        type="submit"
        color="secondary"
      />

    </div>
    <div id="q-app" style="min-height: 100vh">
      <div class="q-pa-md">
        <q-table
          @row-click="editPlayer"
          title="Players"
          :rows="players"
          :columns="columns"
          row-key="id"
        ></q-table>
      </div>
    </div>
  </q-page>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';
import Player from 'src/domain/domainInterfaces';

import axios from 'axios';
import { QTableProps } from 'quasar';

const router = useRouter();

const players = ref<Player>([]);

onMounted(() => {
  getData();
});

function newPlayer() {
  router.push({ path: '/editPlayer?param=add' });
}
async function getData() {
  //alert('getting data');

  await axios
    .get('http://localhost:3000/players')
    .then((response) => {
      players.value = response.data;

      //alert('data = ' + players.value);
    })
    .catch((e) => {
      alert('error: ' + e);
    });
}
function editPlayer() {
  router.push({ path: '/editPlayer?param=upd' });
}

//const rows: QTableProps['rows'] = players;

const columns: QTableProps['columns'] = [
  {
    name: 'firstName',
    align: 'left',
    label: 'First Name',
    field: 'firstName',
    sortable: true,
  },
  {
    name: 'lastName',
    align: 'left',
    label: 'Surname',
    field: 'lastName',
    sortable: true,
  },
  {
    name: 'university',
    align: 'left',
    label: 'University',
    field: 'university',
    sortable: true,
  },
  {
    name: 'position',
    align: 'left',
    label: 'Position',
    field: 'position',
    sortable: true,
  },
  {
    name: 'age',
    align: 'left',
    label: 'Age',
    field: 'age',
    sortable: true,
  },
];
</script>
