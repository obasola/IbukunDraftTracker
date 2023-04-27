<template>
  <q-page>
    <h2>ADD OR UP</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-md">
        <q-inputfilled
          v-model="instance.name"
          label="Team name *"
          hint="The name of the team"
          lazy-rules
          :rules="[(val) => (val && val.length > 0) || 'Team name is required']"
        />
        <q-input
          v-model="instance.city"
          type="text"
          label="City"
          lazy-rules
          :rules="[(val) => (val && val.length > 0) || 'City is Required']"
        />

        <q-input
          v-model="instance.state"
          type="text"
          label="State"
          lazy-rules
          :rules="[(val) => (val && val.length > 0) || 'State is Required']"
        />

        <q-input
          v-model="instance.conference"
          type="text"
          label="Conference"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Conference is Required',
          ]"
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
class Team {
  name!: string;
  city!: string;
  state!: string;
  conference!: string;
}
const instance: Team = new Team();
instance.name = '';
instance.city = '';
instance.state = '';
instance.conference = '';

function submit() {
  alert('Submit clicked');
}
function reset() {
  alert('Reset clicked');
}
</script>
