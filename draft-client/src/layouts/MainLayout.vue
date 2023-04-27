<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title> Ub Drafted! </q-toolbar-title>
        <q-btn>
          <span style="margin-bottom: 0.2 em"
            ><img src="../assets/nfl-logo.svg" width="35" height="35"
          /></span>
        </q-btn>
        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
      <q-list>
        <q-item-label header> Essential Links </q-item-label>

        <q-item href="https://quasar.dev">
          <q-item-section>
            <q-icon name="school" />
          </q-item-section>

          <q-item-section style="margin-left: -1.5em">
            <q-item-label>Quasar Docs</q-item-label>
            <q-item-label caption>Quasar Docs</q-item-label>
          </q-item-section>
        </q-item>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useQuasar } from 'quasar';
import EssentialLink, {
  EssentialLinkProps,
} from 'components/EssentialLink.vue';

const essentialLinks: EssentialLinkProps[] = [
  {
    title: 'Teams',
    caption: 'nfl teams',
    icon: 'code',
    link: '/teams',
  },
  {
    title: 'Picks',
    caption: 'draft picks',
    icon: 'code',
    link: '/picks',
  },
  {
    title: 'Players',
    caption: 'eligable players',
    icon: 'record_voice_over',
    link: '/players',
  },
  {
    title: 'Forum',
    caption: 'forum.quasar.dev',
    icon: 'record_voice_over',
    link: 'https://forum.quasar.dev',
  },
  {
    title: 'Twitter',
    caption: '@quasarframework',
    icon: 'rss_feed',
    link: 'https://twitter.quasar.dev',
  },
];

const leftDrawerOpen = ref(false);

const $q = useQuasar();

// get status
console.log($q.dark.isActive); // true, false

// get configured status
console.log($q.dark.mode); // "auto", true, false

// set status
$q.dark.set(true); // or false or "auto"

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value;
}
</script>
