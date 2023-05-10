import component from '../shims-vue';
<template>
  <EditTeamComponent />
</template>

<script setup lang="ts">
import EditTeamComponent from 'src/components/teams/EditTeamComponent.vue';

components: {
  EditTeamComponent;
}
</script>
