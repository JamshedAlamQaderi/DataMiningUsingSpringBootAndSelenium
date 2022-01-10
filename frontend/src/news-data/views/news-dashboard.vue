<template>
  <div class="bg-blue-50 w-full h-full">
    <div
      class="absolute bg-blue-50 h-screen w-full"
      style="z-index: -100"
    ></div>
    <div class="p-4 w-full h-12 flex justify-end">
      <button
        class="
          h-10
          rounded-full
          px-6
          text-black
          bg-white
          border-2 border-green-700
          shadow-xl
          hover:bg-gray-300 hover:-translate-y-0.5
          transform
        "
        @click="gotoCreatePage"
      >
        Add new
      </button>
    </div>
    <div class="p-10 flex flex-row gap-4">
      <NewsListItem
        v-for="news in newsDatas"
        :key="news.id"
        :newsData="news"
      ></NewsListItem>
    </div>
    <div
      class="w-full h-12 flex justify-center gap-4"
      v-if="newsDatas.length > 0"
    >
      <button
        class="
          h-8
          rounded-sm
          px-4
          text-black
          bg-white
          shadow-xl
          hover:bg-gray-300
        "
        v-if="currentPageNo > 1"
        @click="currentPageNo = currentPageNo + 1"
      >
        Previous
      </button>
      <p>Page {{ currentPageNo }} of {{ totalPages }}</p>
      <button
        class="
          h-8
          rounded-sm
          px-4
          text-black
          bg-white
          shadow-xl
          hover:bg-gray-300
        "
        v-if="currentPageNo < totalPages"
        @click="currentPageNo = currentPageNo + 1"
      >
        Next
      </button>
    </div>
  </div>
</template>

<script>
import NewsListItem from "../components/NewsListItem.vue";
import apiHelper from "../api-helper";
import newsData from "..";
import router from '@/router';
export default {
  name: "NewsDashboard",
  components: {
    NewsListItem,
  },
  mounted() {
    this.loadNews(this.currentPageNo);
  },
  watch: {
    currentPageNo: function (newValue) {
      this.loadNews(newValue);
    },
  },
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types
  data() {
    return {
      newsDatas: [],
      currentPageNo: 1,
      totalPages: 0,
    };
  },
  methods: {
    loadNews(pageNo) {
      apiHelper
        .readNewsByPage(pageNo - 1)
        .then((response) => response.json())
        .then((data) => {
          this.totalPages = data.totalPages;
          this.currentPageNo = data.pageable.pageNumber + 1;
          console.log("page info", data.totalPages, data.pageable.pageNumber);
          this.newsDatas = [];
          let mappedData = data.content.forEach((item) => {
            const newsItem = {
              newsId: item.id,
              newsTitle: item.title,
              newsUrl: item.url,
              newsContent: item.news,
            };
            this.newsDatas.push(newsItem);
          });
          console.log(mappedData);
        })
        .catch((e) => console.log(e));
    },
    gotoCreatePage(){
      router.push('/news-data/create-news')
    }
  },
};
</script>