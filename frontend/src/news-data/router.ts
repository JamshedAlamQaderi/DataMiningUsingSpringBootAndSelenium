import { Router } from "vue-router";
import LocalModule from "./module.vue";

const moduleRoute = {
  path: "/news-data",
  component: LocalModule,
  children: [
    {
      path: "news-dashboard",
      component: () =>
        import(
          /*webpackChunkName: "NewsDashboard"*/ "./views/news-dashboard.vue"
        ),
    },
    {
      path: "create-news",
      component: () =>
        import(/*webpackChunkName: "CreateNews"*/ "./views/create-news.vue"),
    },
  ],
};

// eslint-disable-next-line
export default (router: Router) => {
  router.addRoute(moduleRoute);
};
