import component from '../shims-vue';
<template>
  <ListPicksComponent />
</template>

<script setup lang="ts">
import ListPicksComponent from 'src/components/picks/ListPicksComponent.vue';

components: {
  ListPicksComponent;
}
</script>
