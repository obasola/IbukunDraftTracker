<template>
  <q-page>
    <h2>ADD OR UPDATE TEAMS</h2>
    <div style="float: right; margin-right: 0.7em">
      <q-btn
        v-on:click="getData()"
        label="Refresh"
        type="submit"
        color="primary"
      />
      <q-btn
          @click="newTeam()"
          label="Add Team"
          type="submit"
          color="secondary"
        />
    </div>
    <div id="q-app" style="min-height: 100vh">
      <div class="q-pa-md">
        <q-table
          @row-click="editTeam"
          title="Teams"
          :rows="teams"
          :columns="columns"
          v-model:selected="selectedRow"
          row-key="id"
        ></q-table>
      </div>
    </div>
  </q-page>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';

import axios from 'axios';
import { QTableProps } from 'quasar';

const selectedRow = ref([]);

const router = useRouter();
export interface Team {
  id: number;
  name: string;
  city: string;
  state: string;
  conference: string;
}

const teams = ref<Team>([]);

onMounted(() => {
  getData();
});

function newTeam() {
  router.push({ path: '/editTeam?param=add' });
}

async function getData() {
  //alert('getting data');

  await axios
    .get('http://localhost:3000/teams')
    .then((response) => {
      teams.value = response.data;

      //alert('data = ' + teams.value);
    })
    .catch((e) => {
      alert('error: ' + e);
    });
}
function editTeam() {
  console.log('selection = '+selectedRow.value)
  router.push({ path: '/editTeam' });
}

//const rows: QTableProps['rows'] = teams;

const columns: QTableProps['columns'] = [
  {
    name: 'id',
    align: 'right',
    label: 'ID',
    field: 'id',
    sortable: true,
  },
  {
    name: 'name',
    align: 'left',
    label: 'Name',
    field: 'name',
    sortable: true,
  },
  {
    name: 'city',
    align: 'left',
    label: 'City',
    field: 'city',
    sortable: true,
  },
  {
    name: 'state',
    align: 'left',
    label: 'State',
    field: 'state',
    sortable: true,
  },
  {
    name: 'conference',
    align: 'left',
    label: 'Conference',
    field: 'conference',
    sortable: true,
  },
];
</script>
