import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: '/teams', component: () => import('pages/team/TeamsPage.vue') },
      { path: '/picks', component: () => import('pages/pick/PicksPage.vue') },
      {
        path: '/players',
        component: () => import('pages/player/PlayersPage.vue'),
      },
      {
        path: '/editTeam',
        component: () => import('pages/team/EditTeamPage.vue'),
      },
      {
        path: '/editPlayer',
        component: () => import('pages/player/EditPlayerPage.vue'),
      },
      {
        path: '/editPick',
        component: () => import('pages/pick/EditPickPage.vue'),
      },
      {
        path: '/editScore',
        component: () => import('pages/score/EditScorePage.vue'),
      },
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
