<template>
  <q-page>
    <h2>Edit Team Data</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="submit" @reset="reset" class="q-gutter-md">
        <q-input v-model="teamInstance.name" label="Team name *" />
        <q-input v-model="teamInstance.city" type="text" label="City" />
        <q-input v-model="teamInstance.state" type="text" label="State" />
        <q-input
          v-model="teamInstance.conference"
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
import TeamDataService from 'src/services/TeamDataService';
import { reactive, ref } from 'vue';

const teamInstance = reactive({
  id: 0,
  name: '',
  city: '',
  state: '',
  conference: '',
});
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
