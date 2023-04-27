import component from '../shims-vue';
<template>
  <ListTeamsComponent />
</template>

<script setup lang="ts">
import ListTeamsComponent from '../components/ListTeamsComponent.vue';

const header = 'NFL Draft - Teams Page';
components: {
  ListTeamsComponent;
}
</script>
