import component from '../shims-vue';
<template>
  <q-page class="row items-center justify-evenly">
    <q-header v-model="header" reveal elevated bordered>
      Teams Landing Page
    </q-header>

    <TeamComponent />
  </q-page>
</template>

<script setup lang="ts">
import TeamComponent from '../components/TeamComponent.vue';

const header = 'NFL Draft - Teams Page';
components: {
  TeamComponent;
}
</script>
