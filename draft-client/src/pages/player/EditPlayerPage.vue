import component from '../shims-vue';
<template>
  <EditPlayerComponent />
</template>

<script setup lang="ts">
import EditPlayerComponent from 'src/components/players/EditPlayerComponent.vue';

components: {
  EditPlayerComponent;
}
</script>
