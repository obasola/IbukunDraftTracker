<template>
  <q-page>
    <h2>ADD OR UPDATE PICK</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-md">
        <q-inputfilled
          v-model="instance.selection_year"
          label="Draft Year *"
          hint="The year the draft pick is available"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Draft year is required',
          ]"
        />

        <q-input
          v-model="instance.selection_round"
          type="text"
          label="Round"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Draft round is Required',
          ]"
        />

        <q-input
          v-model="instance.selection_number"
          type="text"
          label="Pick Number"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Pick Number is Required',
          ]"
        />

        <q-input
          v-model="instance.selection_from"
          type="text"
          label="Pick Received From"
          lazy-rules
          :rules="[(val) => (val && val.length > 0) || 'Pick From is Required']"
        />

        <q-input
          v-model="instance.selection_to"
          type="text"
          label="Pick Sent To"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Pick Sent To is Required',
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
class Pick {
  id: number;
  team_id number;
  selection_round number;
  selection_number number;
  selection_year: string;
  selection_from: string;
  selection_sent_to: string;
}
const instance: Pick = new Pick();
instance.team_id = 0;
instance.id = 0;
instance.selection_round = '';
instance.selection_number = '';
instance.selection_year = '';
instance.selection_from = '';
instance.selection_send_to = '';

function submit() {
  alert('Submit clicked');
}
function reset() {
  alert('Reset clicked');
}
</script>
