import { Router } from "vue-router";

const moduleRoute = {
  path: "/navigator",
  component: () =>
    import(/*webpackChunkName: "NavigatorView" */ "./module-view.vue"),
};

// eslint-disable-next-line
export default (router: Router) => {
  router.addRoute(moduleRoute);
};
