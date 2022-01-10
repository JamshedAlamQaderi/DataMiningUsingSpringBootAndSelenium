// eslint-disable
class ApiHelper {
  private apiBase = process.env.VUE_APP_SERVER_API_URL;
  createNews(newsTitle: string, newsUrl: string, newsContent: string) {
    return fetch(this.apiBase + "/create", {
      headers: { "Content-Type": "application/json" },
      method: "POST",
      body: JSON.stringify({
        title: newsTitle,
        url: newsUrl,
        news: newsContent,
      }),
    });
  }

  readNewsByPage(pageNo: number) {
    return fetch(this.apiBase + "/news/" + pageNo);
  }

  readNewsById(newsId: number) {
    return fetch(this.apiBase + "/singlenews/" + newsId);
  }

  deleteNewsById(newsId: number) {
    return fetch(this.apiBase + "/delete/" + newsId);
  }
}

export default new ApiHelper();
