<template>
  <q-page :style-fn="myTweak" padding>
    <h2>Hard Coded Title</h2>
  </q-page>
</template>

<script setup lang="ts">
export interface Team {
  name: string;
  city: string;
  state: string;
  conference: string;
}
</script>
