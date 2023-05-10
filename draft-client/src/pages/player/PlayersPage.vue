import component from '../shims-vue';
<template>
  <ListPlayersComponent />
</template>

<script setup lang="ts">
import ListPlayersComponent from 'src/components/players/ListPlayersComponent.vue';

components: {
  ListPlayersComponent;
}
</script>
