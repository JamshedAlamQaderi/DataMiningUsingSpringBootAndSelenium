<template>
  <div>
    <div class="container mx-auto p-10">
      <div class="font-bold text-2xl">{{ newsData.newsTitle }}</div>
      <a
        class="
          text-sm
          font-thin
          text-gray-600
          hover:text-green-600
          cursor-pointer
          truncate
        "
        :href="newsData.newsUrl"
        >{{ newsData.newsUrl }}</a
      >
      <div class="mt-10 font-mono">{{ newsData.newsContent }}</div>
    </div>
  </div>
</template>

<script>
import apiHelper from "../api-helper";
export default {
  data() {
    return { newsData: {} };
  },
  mounted() {
    apiHelper
      .readNewsById(this.$route.params.newsId)
      .then((response) => response.json())
      .then((data) => {
        this.newsData = {
          newsId: data.id,
          newsTitle: data.title,
          newsUrl: data.url,
          newsContent: data.news,
        };
      })
      .catch((e) => console.log(e));
  },
};
</script>

<style>
</style>