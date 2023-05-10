import component from '../shims-vue';
<template>
  <ListTeamsComponent />
</template>

<script setup lang="ts">
import ListTeamsComponent from 'src/components/teams/ListTeamsComponent.vue';

components: {
  ListTeamsComponent;
}
</script>
