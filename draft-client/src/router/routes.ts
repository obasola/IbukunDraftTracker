import { RouteRecordRaw } from 'vue-router';
import TeamComponent from '../components/TeamComponent.vue';
import

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: '/teams', component: () => import('pages/TeamsPage.vue') },
      { path: '/picks', component: () => import('pages/PicksPage.vue') },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
