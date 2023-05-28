<template>
  <q-page>
    <h2>Edit Team Data</h2>
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="submit" @reset="reset" class="q-gutter-md">

        <q-input v-if="4" v-model="teamInstance.name" label="Team name *" />
        <q-select v-if="param === 'UPD'" filled v-model="teamInstance.id" :options="teamOptionsList"
          option-label="teamName" option-value="id" label="Team" style="width: 250px" />
        <q-input v-model="teamInstance.city" type="text" label="City" />
        <q-input v-model="teamInstance.state" type="text" label="State" />
        <q-select filled v-model="teamInstance.conference" :options="conferenceList" option-label="name"
          option-value="value" label="Conference" style="width: 250px" />

        <div>
          <q-btn v-on:click="submit" label="Submit" type="submit" color="primary" />
          <q-btn v-on:click="reset" label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
        </div>
      </q-form>
    </div>
  </q-page>
</template>

<script setup lang="ts">
</script>

<style lang="scss" scoped>

</style>

