import component from '../shims-vue';
<template>
  <ListPickComponent />
</template>

<script setup lang="ts">
import ListPickComponent from '../components/ListPickComponent.vue';

const header = 'NFL Draft - Draft Picks Page';
components: {
  ListPickComponent;
}
</script>
