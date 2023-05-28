<template>
  <q-page>
    <h2>Pick List</h2>
    <div style="float: right; margin-right: 0.7em">
      <q-btn
        v-on:click="getData()"
        label="Refresh"
        type="submit"
        color="primary"
      />
      <q-btn
        v-on:click="addPick()"
        label="Add Pick"
        type="submit"
        color="primary"
      />
    </div>
    <div id="q-app" style="min-height: 100vh">
      <div class="q-pa-md">
        <q-table
          @row-click="editPick"
          title="Picks"
          :rows="picks"
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
import Pick from 'src/domain/domainInterfaces';

import axios from 'axios';
import { QTableProps } from 'quasar';
import { route } from 'quasar/wrappers';

const router = useRouter();

const picks = ref<Pick>([]);

onMounted(() => {
  getData();
});

function addPick() {
  router.push({path: '/editPick?param=add'} )
}
async function getData() {
  //alert('getting data');

  await axios
    .get('http://localhost:3000/picks')
    .then((response) => {
      picks.value = response.data;

      //alert('data = ' + picks.value);
    })
    .catch((e) => {
      alert('error: ' + e);
    });
}
function editPick() {
  router.push({ path: '/editPick' });
}

//const rows: QTableProps['rows'] = picks;

const columns: QTableProps['columns'] = [
  {
    name: 'teamId',
    align: 'left',
    label: 'Team',
    field: 'teamId',
    sortable: true,
  },
  {
    name: 'selectionRound',
    align: 'left',
    label: 'Round',
    field: 'selectionRound',
    sortable: true,
  },
  {
    name: 'selectionNumber',
    align: 'left',
    label: 'Number',
    field: 'selectionNumber',
    sortable: true,
  },
  {
    name: 'selectionFrom',
    align: 'left',
    label: 'Pick From',
    field: 'selectionFrom',
    sortable: true,
  },
  {
    name: 'selectionSentTo',
    align: 'left',
    label: 'Pick Sent To',
    field: 'selectionSentTo',
    sortable: true,
  },
];
</script>
